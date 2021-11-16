package de.mkccl.flyingbarber.barbier.controller;

import de.mkccl.flyingbarber.barbier.model.BarbierModel;
import de.mkccl.flyingbarber.barbier.repository.BarbierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/barbier")
public class BarbierController {

    @Autowired
    BarbierRepository barbierRepository;

    

    @GetMapping
    public List<BarbierModel> listBarbiers() {
        return barbierRepository.findAll();
    }

}
