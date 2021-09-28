package prbd.construction_company.repositories;

import org.springframework.data.repository.CrudRepository;
import prbd.construction_company.entities.Apartment;

public interface ApartmentRep extends CrudRepository<Apartment, Integer> {
}
