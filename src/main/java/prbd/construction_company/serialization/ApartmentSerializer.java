package prbd.construction_company.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import prbd.construction_company.entities.Apartment;

import java.io.IOException;

@JsonComponent
public class ApartmentSerializer extends JsonSerializer<Apartment> {

    @Override
    public void serialize(Apartment apartment, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", apartment.getId());
        jsonGenerator.writeNumberField("number", apartment.getNumber());
        jsonGenerator.writeNumberField("house_id", apartment.getHouse().getId());
        jsonGenerator.writeNumberField("company_id", apartment.getHouse().getCompany().getId());
        jsonGenerator.writeNumberField("rooms_count", apartment.getRoomsCount());
        jsonGenerator.writeNumberField("entrance", apartment.getEntranceNumber());
        jsonGenerator.writeNumberField("floor", apartment.getFloorNumber());
        jsonGenerator.writeNumberField("total_area", apartment.getTotalArea());
        jsonGenerator.writeNumberField("living_area", apartment.getLivingArea());
        jsonGenerator.writeNumberField("price", apartment.getPrice());
        jsonGenerator.writeStringField("status", apartment.getStatus().getStatus());
        jsonGenerator.writeStringField("layout_img", apartment.getLayoutImg());
        jsonGenerator.writeStringField("house_photo", apartment.getHouse().getPhoto());
        jsonGenerator.writeStringField("address", apartment.getHouse().getAddress());

        jsonGenerator.writeEndObject();

    }

}