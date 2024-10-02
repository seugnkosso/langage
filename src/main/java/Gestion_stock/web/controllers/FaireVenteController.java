package Gestion_stock.web.controllers;

import Gestion_stock.web.dto.request.DetailVenteRequestDto;
import Gestion_stock.web.dto.request.FaireVenteRequestDto;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface FaireVenteController {
    @PostMapping("/vendres") //Get request
    ResponseEntity<?> faireVente(
            @RequestBody FaireVenteRequestDto faireVenteRequestDto
    );

    @PostMapping("/vendres/detail") //Get request
    ResponseEntity<?> detailVendre(
            @RequestBody DetailVenteRequestDto detailVenteRequestDto
    );
}
