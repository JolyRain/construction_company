package prbd.construction_company.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.entities.Apartment;

import java.io.IOException;

@JsonComponent
public class ApartmentSerializer extends JsonSerializer<ApartmentDto> {

    @Override
    public void serialize(ApartmentDto apartmentDto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", apartmentDto.getId());
        jsonGenerator.writeNumberField("number", apartmentDto.getNumber());
        jsonGenerator.writeNumberField("house_id", apartmentDto.getHouse().getId());
        jsonGenerator.writeNumberField("company_id", apartmentDto.getHouse().getCompany().getId());
        jsonGenerator.writeNumberField("rooms_count", apartmentDto.getRoomsCount());
        jsonGenerator.writeNumberField("entrance", apartmentDto.getEntranceNumber());
        jsonGenerator.writeNumberField("floor", apartmentDto.getFloorNumber());
        jsonGenerator.writeNumberField("total_area", apartmentDto.getTotalArea());
        jsonGenerator.writeNumberField("living_area", apartmentDto.getLivingArea());
        jsonGenerator.writeNumberField("price", apartmentDto.getPrice());
        jsonGenerator.writeStringField("status", apartmentDto.getStatus().getStatus());
        jsonGenerator.writeStringField("layout_img", apartmentDto.getLayoutImg());
        jsonGenerator.writeStringField("house_photo", apartmentDto.getHouse().getPhoto());
        jsonGenerator.writeStringField("address", apartmentDto.getHouse().getAddress());

        jsonGenerator.writeEndObject();

    }

}