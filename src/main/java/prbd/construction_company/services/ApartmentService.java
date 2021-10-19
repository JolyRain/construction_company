package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.Apartment;
import prbd.construction_company.entities.House;
import prbd.construction_company.entities.SaleStatus;
import prbd.construction_company.repositories.ApartmentRep;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
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

    public Iterable<Apartment> allApartments() {
        return apartmentRep.findAll();
    }

    public List<Apartment> apartmentList() {
        return toList(allApartments());
    }

    public List<Apartment> getFilteredApartments(Integer company, Integer house, Integer roomsCount,
                                                 String floorFrom, String floorTo,
                                                 String priceFrom, String priceTo,
                                                 String areaFrom, String areaTo,
                                                 SaleStatus status) {
        Predicate<Apartment> byAllParams =
                apartment -> apartment.getHouse().getCompany().getId() == company && apartment.getHouse().getId() == house || all(company)
                        && apartment.getRoomsCount() == roomsCount || all(company)
                        && apartment.getFloorNumber() >= Integer.parseInt(floorFrom) && apartment.getFloorNumber() <= Integer.parseInt(floorTo)
                        && apartment.getPrice() >= Integer.parseInt(priceFrom) && apartment.getPrice() <= Integer.parseInt(priceTo)
                        && apartment.getTotalArea() >= Float.parseFloat(areaFrom) && apartment.getTotalArea() <= Float.parseFloat(areaTo)
                        && apartment.getStatus().equals(status);
        return filter(byAllParams);
    }

    private boolean all(Integer param) {
        return param == -1;
    }
    private boolean all(String param) {
        return all(Integer.parseInt(param)) || param.isBlank();
    }

    private List<Apartment> filter(Predicate<Apartment> predicate) {
        List<Apartment> apartments = toList(allApartments());
        return apartments.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Apartment> getByCompanyId(Integer companyId) {
        return filter(apartment -> apartment.getHouse().getCompany().getId() == companyId);
    }

    public List<Apartment> getByHouseId(Integer houseId) {
        return filter(apartment -> apartment.getHouse().getId() == houseId);
    }

    public List<Apartment> getByRoomsCount(Integer roomsCount) {
        return filter(apartment -> apartment.getRoomsCount() == roomsCount);
    }

    public List<Apartment> getByFloor(Integer floorFrom, Integer floorTo) {
        return filter(apartment -> apartment.getFloorNumber() >= floorFrom && apartment.getFloorNumber() <= floorTo);
    }

    public List<Apartment> getByPrice(Integer priceFrom, Integer priceTo) {
        return filter(apartment -> apartment.getPrice() >= priceFrom && apartment.getPrice() <= priceTo);
    }

    public List<Apartment> getByArea(Float areaFrom, Float areaTo) {
        return filter(apartment -> apartment.getTotalArea() >= areaFrom && apartment.getTotalArea() <= areaTo);
    }

    public List<Apartment> getByStatus(SaleStatus status) {
        return filter(apartment -> apartment.getStatus().equals(status));
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
        List<Apartment> apartments = new ArrayList<>();
        apartmentRep.findAll().forEach(apartments::add);
        IntStream stream = apartments.stream().mapToInt(attribute);
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

    private List<Apartment> toList(Iterable<Apartment> apartments) {
        List<Apartment> result = new ArrayList<>();
        apartments.forEach(result::add);
        return result;
    }

}
