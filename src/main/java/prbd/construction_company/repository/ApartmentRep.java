package prbd.construction_company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import prbd.construction_company.entity.Apartment;

@Repository
public interface ApartmentRep extends JpaRepository<Apartment, Integer> {

    @Query("select max (roomsCount) from Apartment")
    int findMaxRoomsCount();

    @Query("select min (roomsCount) from Apartment")
    int findMinRoomsCount();

    @Query("select min (price) from Apartment ")
    int findMinPrice();

    @Query("select max (price) from Apartment ")
    int findMaxPrice();

    @Query("select min (floorNumber) from Apartment ")
    int findMinFloor();

    @Query("select max (floorNumber) from Apartment ")
    int findMaxFloor();

}
