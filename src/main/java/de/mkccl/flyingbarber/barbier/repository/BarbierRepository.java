package de.mkccl.flyingbarber.barbier.repository;

import de.mkccl.flyingbarber.barbier.model.BarbierModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbierRepository extends JpaRepository<BarbierModel, Integer> {
}
