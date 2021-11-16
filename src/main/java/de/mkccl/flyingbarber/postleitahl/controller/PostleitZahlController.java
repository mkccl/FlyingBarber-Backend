package de.mkccl.flyingbarber.postleitahl.controller;

import de.mkccl.flyingbarber.postleitahl.model.PostleitzahlModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/plz")
public class PostleitZahlController {

    /**
     * Eine Postleitzahl muss im Bereich 30 liegen
     * andernfalls gibt ein Bad Request zurück
     *
     * @param input
     * @return
     */

    @GetMapping("/{input}")
    public ResponseEntity<Object> validPostleitzahl(@PathVariable int input) {

        String plz = "" + input;

        if (plz.length() == 5) {
            if (plz.startsWith("30")) {
                return ResponseEntity.status(200).body(new PostleitzahlModel(input, "Postleitzahl im Bereich 30"));
            }
            return ResponseEntity.status(400).body("Postleitzahl nicht im Bereich 30");

        }

        return ResponseEntity.status(404).body("Bad request");

    }

}
