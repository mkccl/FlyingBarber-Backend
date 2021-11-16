package de.mkccl.flyingbarber.bestellung.repository;

import de.mkccl.flyingbarber.bestellung.model.BestellungModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<BestellungModel, Integer> {
}
