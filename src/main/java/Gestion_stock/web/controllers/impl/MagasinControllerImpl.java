package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.entities.Magasin;
import Gestion_stock.services.MagasinService;
import Gestion_stock.web.controllers.MagasinController;
import Gestion_stock.web.dto.response.RestResponsDto;
import Gestion_stock.web.dto.response.magasin.MagasinSelectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@Controller
@CrossOrigin(GlobalVariable.urlFront)
@RequiredArgsConstructor
public class MagasinControllerImpl implements MagasinController {
    private final MagasinService magasinService;
    @Override
    public ResponseEntity<?> magasinVendeurId(int id) {
        Magasin magasinByVendeurId = magasinService.findMagasinByVendeurId(id);
        MagasinSelectDto magasinSelectDto = MagasinSelectDto.toDto(magasinByVendeurId);
        return new ResponseEntity<>(magasinSelectDto, HttpStatus.OK);
    }
}
