package prbd.construction_company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prbd.construction_company.entity.Apartment;
import prbd.construction_company.entity.Client;

import java.util.List;

@Repository
public interface ClientRep extends JpaRepository<Client, Integer> {

    @Query("select c.apartments from Client c where c = :client")
    List<Apartment> findOwnApartments(@Param("client") Client client);
}
