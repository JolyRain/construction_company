package prbd.construction_company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.ClientDto;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.ApartmentMapper;
import prbd.construction_company.mapper.ClientMapper;
import prbd.construction_company.repository.ClientRep;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRep clientRep;
    private final ClientMapper clientMapper;
    private final ApartmentService apartmentService;
    private final ApartmentMapper apartmentMapper;

    public List<ClientDto> allClients() {
        return clientMapper.toDtoList(clientRep.findAll(), ClientMapper.CONTEXT);
    }

    public ClientDto getClientById(Integer id) {
        return clientMapper.toDto(clientRep.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found!")), ClientMapper.CONTEXT);
    }

    public ClientDto addClient(ClientDto clientDto) {
        clientRep.save(clientMapper.toEntity(clientDto, ClientMapper.CONTEXT));
        return clientDto;
    }

    public ClientDto addClient(ClientDto clientDto, List<Integer> apartmentIds) {
        apartmentService.updateStatus(clientDto.getApartments());
        clientDto.getApartments().clear();
        return addClient(addOwnApartments(clientDto, apartmentIds));
    }

    public ClientDto addOwnApartments(ClientDto clientDto, List<Integer> apartmentIds) {
        if (apartmentIds == null) {
            return clientDto;
        }
        apartmentIds.forEach(apartmentId -> {
            var apartment = apartmentService.getApartmentById(apartmentId);
            clientDto.getApartments().add(apartment);
            apartmentService.addOwner(apartment, clientDto);
            apartmentService.addApartment(apartment);
        });
        return clientDto;
    }


    public List<ApartmentDto> getOwnApartments(ClientDto clientDto) {
        var ownApartments = clientRep.findOwnApartments(
                clientMapper.toEntity(clientDto, ClientMapper.CONTEXT));
        return apartmentMapper.toDtoList(ownApartments, ApartmentMapper.CONTEXT);
    }

    public void deleteClient(ClientDto clientDto) {
        clientRep.delete(clientMapper.toEntity(clientDto, ClientMapper.CONTEXT));
    }

    public void deleteClient(Integer id) {
        deleteClient(getClientById(id));
    }


}
