package prbd.construction_company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.House;

import java.util.List;

public interface ApartmentRep extends JpaRepository<Apartment, Integer> {
    Iterable<Apartment> findAllByHouse(House house);
}
