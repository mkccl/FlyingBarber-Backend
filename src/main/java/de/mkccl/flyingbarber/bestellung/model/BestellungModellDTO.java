package de.mkccl.flyingbarber.bestellung.model;

import de.mkccl.flyingbarber.leistung.model.LeistungModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BestellungModellDTO {

    private String name;
    private String vorname;
    private String strasse;

    private List<LeistungModel> leistungen;

}
