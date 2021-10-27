package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.mapper.ClientMapper;
import prbd.construction_company.repositories.ClientRep;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRep clientRep;
    private final ClientMapper clientMapper;

    public List<ClientDto> allClients() {
        return clientRep.findAll()
                .stream()
                .map(client -> clientMapper.toDto(client, ClientMapper.CONTEXT))
                .collect(Collectors.toList());
    }

    public ClientDto getClientById(Integer id) {
        // todo обработать исключения
        return clientMapper.toDto(clientRep.findById(id).orElse(null), ClientMapper.CONTEXT);
    }

    public ClientDto addClient(ClientDto clientDto) {
        clientRep.save(clientMapper.toEntity(clientDto, ClientMapper.CONTEXT));
        return clientDto;
    }

    public void deleteClient(ClientDto clientDto) {
        clientRep.delete(clientMapper.toEntity(clientDto, ClientMapper.CONTEXT));
    }

    public void deleteClient(Integer id) {
        deleteClient(getClientById(id));
    }


}
