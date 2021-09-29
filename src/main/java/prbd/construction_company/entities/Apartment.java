package prbd.construction_company.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apartment")
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

    public Apartment() {
    }

    public Apartment(int number, House house, int entranceNumber, int floorNumber, int roomsCount,
                     float totalArea, float livingArea, int price, SaleStatus status, String layoutImg) {
        this.number = number;
        this.house = house;
        this.entranceNumber = entranceNumber;
        this.floorNumber = floorNumber;
        this.roomsCount = roomsCount;
        this.totalArea = totalArea;
        this.livingArea = livingArea;
        this.price = price;
        this.status = status;
        this.layoutImg = layoutImg;
    }

    public Apartment(int number, House house, int entranceNumber, int floorNumber, int roomsCount) {
        this.number = number;
        this.house = house;
        this.entranceNumber = entranceNumber;
        this.floorNumber = floorNumber;
        this.roomsCount = roomsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getEntranceNumber() {
        return entranceNumber;
    }

    public void setEntranceNumber(int entranceNumber) {
        this.entranceNumber = entranceNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public float getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(float livingArea) {
        this.livingArea = livingArea;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public Set<Client> getOwners() {
        return owners;
    }

    public void setOwners(Set<Client> owners) {
        this.owners = owners;
    }

    public String getLayoutImg() {
        return layoutImg;
    }

    public void setLayoutImg(String layoutImg) {
        this.layoutImg = layoutImg;
    }
}
