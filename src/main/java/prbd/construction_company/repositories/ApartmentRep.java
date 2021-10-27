package prbd.construction_company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.House;

public interface ApartmentRep extends JpaRepository<Apartment, Integer> {
    Iterable<Apartment> findAllByHouse(House house);


}
