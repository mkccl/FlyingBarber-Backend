package de.mkccl.flyingbarber.barbier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "barbier")
public class BarbierModel {

    @Id
    private int id;

    @Column(name = "barbier_name")
    private String name;

    @Column(name = "barbier_vorname")
    private String vorname;

    @Column(name = "barbier_beschreibung")
    private String beschreibung;

    @Column(name = "barbier_bildPath")
    private String bildPath;

}
