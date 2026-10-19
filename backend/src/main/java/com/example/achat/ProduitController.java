package com.example.achat;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitRepository repository;

    public ProduitController(ProduitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produit> lister() {
        return repository.findAll();
    }

    @PostMapping
    public Produit ajouter(@RequestBody Produit produit) {
        produit.setId(null);
        return repository.save(produit);
    }
}
