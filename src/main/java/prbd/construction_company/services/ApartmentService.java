package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.House;
import prbd.construction_company.entities.SaleStatus;
import prbd.construction_company.repositories.ApartmentRep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

@Service
public class ApartmentService {
    private final ApartmentRep apartmentRep;

    @Autowired
    public ApartmentService(ApartmentRep apartmentRep) {
        this.apartmentRep = apartmentRep;
    }

    public void addApartment(Apartment apartment) {
        apartmentRep.save(apartment);
    }

    public Apartment getApartmentById(Integer id) {
        return apartmentRep.findById(id).orElse(null);
    }

    public List<Apartment> allApartments() {
        return apartmentRep.findAll();
    }

    public void deleteApartment(Apartment apartment) {
        apartmentRep.delete(apartment);
    }

    public void deleteApartment(Integer id) {
        apartmentRep.deleteById(id);
    }

    public void updateApartment(Integer id, House house, Integer number,
                                Integer floor, Integer entrance, Integer roomsCount,
                                Float totalArea, Float livingArea, Integer price,
                                SaleStatus status, String layoutImg) {
        Apartment apartment = getApartmentById(id);
        apartment.setHouse(house);
        apartment.setNumber(number);
        apartment.setFloorNumber(floor);
        apartment.setEntranceNumber(entrance);
        apartment.setRoomsCount(roomsCount);
        apartment.setTotalArea(totalArea);
        apartment.setLivingArea(livingArea);
        apartment.setPrice(price);
        apartment.setStatus(status);
        apartment.setLayoutImg(layoutImg);
        addApartment(apartment);
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

    public Map<SaleStatus, String> statusMap() {
        Map<SaleStatus, String> map = new HashMap<>();
        for (SaleStatus s : SaleStatus.values()) {
            map.put(s, s.getStatus());
        }
        return map;
    }

}
