package prbd.construction_company.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prbd.construction_company.dto.HouseDto;
import prbd.construction_company.mapper.HouseMapper;
import prbd.construction_company.repositories.HouseRep;

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
        // todo обработать исключения
        return houseMapper.toDto(houseRep.findById(id).orElse(null), HouseMapper.CONTEXT);
    }
}
