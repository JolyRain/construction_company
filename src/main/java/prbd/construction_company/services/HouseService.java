package prbd.construction_company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prbd.construction_company.entities.House;
import prbd.construction_company.repositories.HouseRep;

@Service
public class HouseService {
    private final HouseRep houseRep;

    @Autowired
    public HouseService(HouseRep houseRep) {
        this.houseRep = houseRep;
    }

    public Iterable<House> allHouses() {
        return houseRep.findAll();
    }

    public void addHouse(House house) {
        houseRep.save(house);
    }

    public House getHouseById(Integer id) {
        return houseRep.findById(id).orElse(null);
    }
}
