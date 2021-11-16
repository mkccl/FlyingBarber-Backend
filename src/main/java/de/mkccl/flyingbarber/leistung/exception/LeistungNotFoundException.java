package de.mkccl.flyingbarber.leistung.exception;

public class LeistungNotFoundException extends Exception {
    public LeistungNotFoundException(int id) {
        super("Leistung mit der ID: " + id + " nicht gefunden");
    }
}
