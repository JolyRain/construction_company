package prbd.construction_company.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "constr_company")
public class ConstructionCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int id;

    @Column(name = "company_name", unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", orphanRemoval = true)
    private Set<House> houses;

    public ConstructionCompany() {
    }

    public ConstructionCompany(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ConstructionCompany(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ConstructionCompany(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
