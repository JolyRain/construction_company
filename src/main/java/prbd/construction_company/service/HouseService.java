package prbd.construction_company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.CompanyDto;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.CompanyMapper;
import prbd.construction_company.mapper.HouseMapper;
import prbd.construction_company.repository.HouseRep;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final HouseRep houseRep;
    private final HouseMapper houseMapper;

    public List<HouseDto> allHouses() {
        return houseRep.findAll()
                .stream()
                .map(house -> houseMapper.toDto(house, HouseMapper.CONTEXT))
                .collect(Collectors.toList());
    }

    public HouseDto addHouse(HouseDto houseDto) {
        houseRep.save(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT));
        return houseDto;
    }

    public HouseDto getHouseById(Integer id) {
        return houseMapper.toDto(houseRep.findById(id)
                .orElseThrow(() -> new NotFoundException("House not found!")), HouseMapper.CONTEXT);
    }

    public void deleteHouse(HouseDto houseDto) {
        houseRep.delete(houseMapper.toEntity(houseDto, CompanyMapper.CONTEXT));
    }

    public void deleteHouse(Integer id) {
        deleteHouse(getHouseById(id));
    }

    public int getMaxApartPrice(HouseDto houseDto) {
        return houseRep.maxApartmentPrice(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT));
    }

    public int getMinApartPrice(HouseDto houseDto) {
        return houseRep.minApartmentPrice(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT));
    }
    public double getAvgPrice(HouseDto houseDto) {
        return houseRep.findAvgPrice(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT));
    }

    public double getAvgArea(HouseDto houseDto) {
        return houseRep.avgApartmentArea(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT));
    }

}
