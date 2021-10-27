package prbd.construction_company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import prbd.construction_company.entities.Client;

public interface ClientRep extends JpaRepository<Client, Integer> {
}
