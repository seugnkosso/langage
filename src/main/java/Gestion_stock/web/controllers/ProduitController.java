package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface ProduitController {
    @GetMapping("/produits") //Get request
    ResponseEntity<?> produit(
            @RequestParam(defaultValue = "0") int page, //paramettre d'Url
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam(defaultValue = "") int id,
            @RequestParam(defaultValue = "") String search
    );
}
