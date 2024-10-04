package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface VenteController {
    @GetMapping("/ventes") //Get request
    ResponseEntity<?> ventes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam(defaultValue = "") String tel,
            @RequestParam(defaultValue = "") String dateVente
    );

    @GetMapping("/ventes/id") //Get request
    ResponseEntity<?> ventesId(
            @RequestParam() int id
    );

    @GetMapping("/ventes/total") //Get request
    ResponseEntity<?> totals(
            @RequestParam(defaultValue = "") String tel,
            @RequestParam(defaultValue = "") String dateVente
    );
}
