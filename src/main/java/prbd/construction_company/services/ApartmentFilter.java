package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.repositories.ApartmentRep;
import prbd.construction_company.repositories.CompanyRep;
import prbd.construction_company.repositories.HouseRep;

import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

@Service
public class ApartmentFilter {
    private final ApartmentRep apartmentRep;
    private final HouseRep houseRep;
    private final CompanyRep companyRep;


    @Autowired
    public ApartmentFilter(ApartmentRep apartmentRep, HouseRep houseRep, CompanyRep companyRep) {
        this.apartmentRep = apartmentRep;
        this.houseRep = houseRep;
        this.companyRep = companyRep;
    }

    private Integer boundaryValues(ToIntFunction<Apartment> attribute, Function<IntStream, OptionalInt> function) {
        IntStream stream = apartmentRep.findAll().stream().mapToInt(attribute);
        OptionalInt result = function.apply(stream);
        return result.isPresent() ? result.getAsInt() : -1;
    }

    public Integer maxRoomsCount() {
        return boundaryValues(Apartment::getRoomsCount, IntStream::max);
    }

    public Integer minRoomsCount() {
        return boundaryValues(Apartment::getRoomsCount, IntStream::min);
    }

    public Integer minPrice() {
        return boundaryValues(Apartment::getPrice, IntStream::min);
    }

    public Integer maxPrice() {
        return boundaryValues(Apartment::getPrice, IntStream::max);
    }

    public Integer minFloor() {
        return boundaryValues(Apartment::getFloorNumber, IntStream::min);
    }

    public Integer maxFloor() {
        return boundaryValues(Apartment::getFloorNumber, IntStream::max);
    }

}
