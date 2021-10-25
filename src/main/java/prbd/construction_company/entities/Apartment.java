package prbd.construction_company.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prbd.construction_company.serialization.ApartmentSerializer;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apartment")
@JsonSerialize(using = ApartmentSerializer.class)
public class Apartment {

    @Id
    @Column(name = "apart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house", nullable = false)
    private House house;

    @Column(name = "entrance", nullable = false)
    private int entranceNumber;

    @Column(name = "floor", nullable = false)
    private int floorNumber;

    @Column(name = "rooms_count", nullable = false)
    private int roomsCount;

    @Column(name = "total_area")
    private float totalArea;

    @Column(name = "living_area")
    private float livingArea;

    private int price;

    @Enumerated(EnumType.STRING)
    private SaleStatus status;

    @ManyToMany(mappedBy = "apartments")
    private Set<Client> owners;

    @Column(name = "layout_img")
    private String layoutImg;
}
