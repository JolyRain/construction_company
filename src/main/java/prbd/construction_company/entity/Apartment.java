package prbd.construction_company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @Column(name = "apart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
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
