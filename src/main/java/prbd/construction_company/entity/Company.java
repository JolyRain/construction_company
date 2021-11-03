package prbd.construction_company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "constr_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<House> houses;

    @Column(name = "logo")
    private String logo;
}
