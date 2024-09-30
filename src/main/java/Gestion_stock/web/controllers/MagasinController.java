package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface MagasinController {
    @GetMapping("/magasins/vendeur") //Get request
    ResponseEntity<?> magasinVendeurId(
            @RequestParam(defaultValue = "") int id
    );

}
