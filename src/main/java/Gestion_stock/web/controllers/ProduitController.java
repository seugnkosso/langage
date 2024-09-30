package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ProduitController {
    @GetMapping("/produits") //Get request
    ResponseEntity<?> produit(
            @RequestParam(defaultValue = "0") int page, //paramettre d'Url
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam(defaultValue = "") int id,
            @RequestParam(defaultValue = "") String search
    );
    @PostMapping("/produits") //Post request
    ResponseEntity<?> create(
            @RequestBody ProduitRequestDto produitRequestDto
    );

    @PutMapping("/produits") //Post request
    ResponseEntity<?> update(
            @RequestBody ProduitRequestDto produitRequestDto
    );

    @GetMapping("/produits/libelle") //Get request
    ResponseEntity<?> produitLibelle(
            @RequestParam(defaultValue = "") String libelle
    );
}
