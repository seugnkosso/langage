package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


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
}
