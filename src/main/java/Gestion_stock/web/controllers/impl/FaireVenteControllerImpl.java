package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.entities.Vente;
import Gestion_stock.services.FaireVenteService;
import Gestion_stock.web.controllers.FaireVenteController;
import Gestion_stock.web.dto.request.DetailVenteRequestDto;
import Gestion_stock.web.dto.request.FaireVenteRequestDto;
import Gestion_stock.web.dto.response.RestResponsDto;
import Gestion_stock.web.dto.response.vente.VenteSelectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@CrossOrigin(GlobalVariable.urlFront)
public class FaireVenteControllerImpl implements FaireVenteController {
    private final FaireVenteService faireVenteService;

    @Override
    public ResponseEntity<?> faireVente(FaireVenteRequestDto faireVenteRequestDto) {
        Vente vente = faireVenteService.FaireVente(faireVenteRequestDto);
        VenteSelectDto dto = VenteSelectDto.toDto(vente);
        Map<Object, Object> response = RestResponsDto.response(dto, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> detailVendre(DetailVenteRequestDto detailVenteRequestDto) {
        faireVenteService.detailvente(detailVenteRequestDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
