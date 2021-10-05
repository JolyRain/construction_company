package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.Client;
import prbd.construction_company.repositories.ClientRep;

@Service
public class ClientService {

    private final ClientRep clientRep;

    @Autowired
    public ClientService(ClientRep clientRep) {
        this.clientRep = clientRep;
    }

    public Iterable<Client> allClients() {
        return clientRep.findAll();
    }

    public Client getClientById(Integer id) {
        return clientRep.findById(id).orElse(null);
    }

    public void addClient(Client client) {
        clientRep.save(client);
    }

    public void deleteClient(Integer id) {
        clientRep.deleteById(id);
    }

    public void deleteClient(Client client) {
        clientRep.delete(client);
    }


}
