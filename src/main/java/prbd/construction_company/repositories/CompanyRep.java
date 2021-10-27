package prbd.construction_company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import prbd.construction_company.entities.Company;

@Repository
public interface CompanyRep extends JpaRepository<Company, Integer> {
}
