package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ClientController {
    @PostMapping("/clients") //Get request
    ResponseEntity<?> create(
            @RequestBody ClientListeDto clientListeDto
    );

    @GetMapping("/clients/telephone") //Get request
    ResponseEntity<?> clientTelephone(
            @RequestParam(defaultValue = "") String tel
    );
}
