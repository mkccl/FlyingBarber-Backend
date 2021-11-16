package de.mkccl.flyingbarber.leistung.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "leistung")
public class LeistungModel {

    @Id
    @GeneratedValue
    private int id;

    private String titel;

    private String beschreibung;

    private double preis;

    private int dauer;

    private String picturePath;

}
