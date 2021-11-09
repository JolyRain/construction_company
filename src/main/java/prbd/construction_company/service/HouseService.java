package prbd.construction_company.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.exception.NotFoundException;
import prbd.construction_company.mapper.CompanyMapper;
import prbd.construction_company.mapper.HouseMapper;
import prbd.construction_company.repository.HouseRep;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final HouseRep houseRep;
    private final HouseMapper houseMapper;
    private final CompanyService companyService;

    public List<HouseDto> allHouses() {
        return houseRep.findAll()
                .stream()
                .map(house -> houseMapper.toDto(house, HouseMapper.CONTEXT))
                .collect(Collectors.toList());
    }

    public HouseDto addHouse(HouseDto houseDto, Integer companyId) {
        var companyDto = companyService.getCompanyById(companyId);
        houseDto.setCompany(companyDto);
        companyDto.getHouses().add(houseDto);

        companyService.addCompany(companyDto);
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
        var optMaxPrice = Optional.ofNullable(
                houseRep.maxApartmentPrice(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT)));
        return optMaxPrice.orElse(0);
    }

    public int getMinApartPrice(HouseDto houseDto) {
        var optMinPrice = Optional.ofNullable(
                houseRep.minApartmentPrice(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT)));
        return optMinPrice.orElse(0);
    }

    public double getAvgPrice(HouseDto houseDto) {
        var optAvgPrice = Optional.ofNullable(
                houseRep.findAvgPrice(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT)));
        return optAvgPrice.orElse(0);
    }

    public double getAvgArea(HouseDto houseDto) {
        var optAvgArea = Optional.ofNullable(
                houseRep.avgApartmentArea(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT)));
        return optAvgArea.orElse(0.0);
    }

}
