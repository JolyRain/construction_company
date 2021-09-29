package prbd.construction_company.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company", nullable = false)
    private ConstructionCompany company;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "house_name", nullable = false, unique = true)
    private String name;

    @Column(name = "constr_start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "constr_complete_date", columnDefinition = "DATE")
    private LocalDate completeDate;

    @Column(name = "exploit_date", columnDefinition = "DATE")
    private LocalDate exploitDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "house", orphanRemoval = true)
    private Set<Apartment> apartments;

    @Column(name = "photo")
    private String photo;

    public House() {
    }

    public House(ConstructionCompany company, String address, String name,
                 LocalDate startDate, LocalDate completeDate, LocalDate exploitDate, String photo) {
        this.company = company;
        this.address = address;
        this.name = name;
        this.startDate = startDate;
        this.completeDate = completeDate;
        this.exploitDate = exploitDate;
        this.photo = photo;
    }

    public House(ConstructionCompany company, String address, String name) {
        this.company = company;
        this.address = address;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConstructionCompany getCompany() {
        return company;
    }

    public void setCompany(ConstructionCompany company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }

    public LocalDate getExploitDate() {
        return exploitDate;
    }

    public void setExploitDate(LocalDate exploitDate) {
        this.exploitDate = exploitDate;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Set<Apartment> apartments) {
        this.apartments = apartments;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
