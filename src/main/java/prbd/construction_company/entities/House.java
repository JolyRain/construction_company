package prbd.construction_company.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company", nullable = false)
    private Company company;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
    private Set<Apartment> apartments;

    @Column(name = "photo")
    private String photo;

}
