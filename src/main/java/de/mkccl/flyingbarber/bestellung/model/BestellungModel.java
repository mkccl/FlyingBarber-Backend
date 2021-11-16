package de.mkccl.flyingbarber.bestellung.model;

import de.mkccl.flyingbarber.leistung.model.LeistungModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "bestellung")
public class BestellungModel {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String vorname;

    private String strasse;


    @ManyToMany
    @JoinTable(
            name = "summary_leistung_bestellung",
            joinColumns = { @JoinColumn(name = "bestellung_id") },
            inverseJoinColumns = { @JoinColumn(name = "leistung_id") }
    )
    private List<LeistungModel> leistungen;

}
