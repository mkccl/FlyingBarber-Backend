package de.mkccl.flyingbarber.bestellung.exception;

public class BestellungNotFoundException extends Exception {
    public BestellungNotFoundException(int text) {
        super("Bestellung mit der ID: " + text  + "nicht gefunden");
    }

}
