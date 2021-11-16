package de.mkccl.flyingbarber.leistung.repository;

import de.mkccl.flyingbarber.leistung.model.LeistungModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeistungRepository extends JpaRepository<LeistungModel, Integer> {
}
