package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.mapper.HouseMapper;
import prbd.construction_company.repositories.HouseRep;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final HouseRep houseRep;
    private final HouseMapper houseMapper;

    public List<HouseDto> allHouses() {
        var houseDtoList = new ArrayList<HouseDto>();
        houseRep.findAll().forEach(house -> houseDtoList.add(houseMapper.toDto(house, HouseMapper.CONTEXT)));
        return houseDtoList;
    }

    public HouseDto addHouse(HouseDto houseDto) {
        houseRep.save(houseMapper.toEntity(houseDto, HouseMapper.CONTEXT));
        return houseDto;
    }

    public HouseDto getHouseById(Integer id) {
        return houseMapper.toDto(houseRep.findById(id).orElse(null), HouseMapper.CONTEXT);
    }
}
