package prbd.construction_company.repositories;

import org.springframework.data.repository.CrudRepository;
import prbd.construction_company.entities.Company;

public interface CompanyRep  extends CrudRepository<Company, Integer> {
}
