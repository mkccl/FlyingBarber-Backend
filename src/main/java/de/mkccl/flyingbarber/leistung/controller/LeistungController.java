package de.mkccl.flyingbarber.leistung.controller;

import de.mkccl.flyingbarber.leistung.exception.LeistungNotFoundException;
import de.mkccl.flyingbarber.leistung.model.LeistungModel;
import de.mkccl.flyingbarber.leistung.repository.LeistungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/leistung")
public class LeistungController {

    @Autowired
    LeistungRepository leistungRepository;

    @GetMapping
    private ResponseEntity<List<LeistungModel>> getLeistungen() {
        return ResponseEntity.status(200).body(leistungRepository.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<LeistungModel> getLeistungById(@PathVariable int id) throws LeistungNotFoundException {
        return ResponseEntity.status(200).body(leistungRepository.findById(id).orElseThrow(() -> new LeistungNotFoundException(id)));
    }

    @PostMapping("/add")
    private ResponseEntity<LeistungModel> saveLeistung(LeistungModel leistungModel) {
        return ResponseEntity.status(200).body(leistungRepository.save(leistungModel));
    }

    @DeleteMapping("/delete/{id}")
    private void deleteLeistungById(int id) throws LeistungNotFoundException {
        leistungRepository.delete(leistungRepository.findById(id).orElseThrow(() -> new LeistungNotFoundException(id)));
    }

    @DeleteMapping("/delete")
    private String deleteLeistungen() {
        leistungRepository.deleteAll();
        return "Alle Datensätze gelöscht";
    }

}
