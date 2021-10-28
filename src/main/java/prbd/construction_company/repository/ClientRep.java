package prbd.construction_company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prbd.construction_company.entity.Client;

@Repository
public interface ClientRep extends JpaRepository<Client, Integer> {
}
