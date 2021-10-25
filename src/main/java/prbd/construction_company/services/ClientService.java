package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.entities.Client;
import prbd.construction_company.mapper.ClientMapper;
import prbd.construction_company.repositories.ClientRep;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRep clientRep;
    private final ClientMapper clientMapper;

    public List<ClientDto> allClients() {
        var clientDtoList = new ArrayList<ClientDto>();
        clientRep.findAll().forEach(client -> clientDtoList.add(clientMapper.toDto(client)));
        return clientDtoList;
    }

    public ClientDto getClientById(Integer id) {
        return clientMapper.toDto(clientRep.findById(id).orElse(null));
    }

    public ClientDto addClient(ClientDto clientDto) {
        clientRep.save(clientMapper.toEntity(clientDto));
        return clientDto;
    }

    public ClientDto deleteClient(ClientDto clientDto) {
        clientRep.delete(clientMapper.toEntity(clientDto));
        return clientDto;
    }

    public ClientDto deleteClient(Integer id) {
        var clientDto = getClientById(id);
        deleteClient(clientDto);
        return clientDto;
    }


}
