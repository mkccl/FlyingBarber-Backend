package de.mkccl.flyingbarber.bestellung.controller;

import de.mkccl.flyingbarber.bestellung.exception.BestellungNotFoundException;
import de.mkccl.flyingbarber.bestellung.model.BestellungModel;
import de.mkccl.flyingbarber.bestellung.model.BestellungModellDTO;
import de.mkccl.flyingbarber.bestellung.repository.BestellungRepository;
import de.mkccl.flyingbarber.leistung.model.LeistungModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/bestellung")
public class BestellungController {

    @Autowired
    BestellungRepository bestellungRepository;

    @GetMapping("/all")
    private List<BestellungModel> getBestellungen() {
        return bestellungRepository.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> getBestellungById(@PathVariable int id) throws BestellungNotFoundException {
        BestellungModel bestellungModel = bestellungRepository.findById(id).orElseThrow(() -> new BestellungNotFoundException(id));
        return ResponseEntity.status(200).body(bestellungModel);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Object> deleteBestellungById(@PathVariable int id) throws BestellungNotFoundException {
        BestellungModel bestellungModel = bestellungRepository.findById(id).orElseThrow(() -> new BestellungNotFoundException(id));
        bestellungRepository.delete(bestellungModel);
        return ResponseEntity.status(200).body("Datensatz gelöscht!");
    }

    @DeleteMapping("/delete")
    private void deleteAlleBestellungen() {
        List<BestellungModel> bestellungModel = bestellungRepository.findAll();
        bestellungRepository.deleteAll(bestellungModel);
    }

    @PostMapping
    private BestellungModel createBestellung(@RequestBody BestellungModellDTO bestellungModellDTO) {

        BestellungModel bestellungModel = new BestellungModel();
        List<LeistungModel> leistungsModel = new ArrayList<>(bestellungModellDTO.getLeistungen());


        bestellungModel.setVorname(bestellungModellDTO.getVorname());
        bestellungModel.setName(bestellungModellDTO.getName());
        bestellungModel.setStrasse(bestellungModellDTO.getStrasse());

        bestellungModel.setLeistungen(leistungsModel);


        return bestellungRepository.save(bestellungModel);
    }

}
