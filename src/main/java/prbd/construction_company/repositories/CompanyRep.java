package prbd.construction_company.repositories;

import org.springframework.data.repository.CrudRepository;
import prbd.construction_company.entities.ConstructionCompany;

public interface CompanyRep  extends CrudRepository<ConstructionCompany, Integer> {
}
