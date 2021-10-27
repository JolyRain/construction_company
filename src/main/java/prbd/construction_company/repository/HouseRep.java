package prbd.construction_company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prbd.construction_company.entity.Company;
import prbd.construction_company.entity.House;

@Repository
public interface HouseRep extends JpaRepository<House, Integer> {
    Iterable<House> findAllByCompany(Company company);

    @Query("select max (a.price) from House h inner join Apartment a on h.id = a.house.id where h = :house")
    int maxApartmentPrice(@Param("house") House house);

    @Query("select min (a.price) from House h inner join Apartment a on h.id = a.house.id where h = :house")
    int minApartmentPrice(@Param("house") House house);

    @Query("select avg (a.price) from House h inner join Apartment a on h.id = a.house.id where h = :house")
    int findAvgPrice(@Param("house") House house);

    @Query("select avg (a.totalArea) from House h inner join Apartment a on h.id = a.house.id where h = :house")
    double avgApartmentArea(@Param("house") House house);
}
