package prbd.construction_company.repositories;

import org.springframework.data.repository.CrudRepository;
import prbd.construction_company.entities.House;

public interface HouseRep extends CrudRepository<House, Integer> {
}
