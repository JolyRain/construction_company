package prbd.construction_company.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "constr_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int id;

    @Column(name = "company_name", unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<House> houses;

    @Column(name = "logo")
    private String logo;
}
