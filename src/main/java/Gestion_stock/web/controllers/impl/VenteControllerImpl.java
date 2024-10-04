package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.entities.Vente;
import Gestion_stock.data.repositories.VenteRepository;
import Gestion_stock.services.VenteService;
import Gestion_stock.web.controllers.VenteController;
import Gestion_stock.web.dto.response.RestResponsDto;
import Gestion_stock.web.dto.response.vente.VenteDto;
import Gestion_stock.web.dto.response.vente.VenteListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.urlFront)
public class VenteControllerImpl implements VenteController {
    private final VenteService venteService;
    private final VenteRepository venteRepository;

    @Override
    public ResponseEntity<?> ventes(int page, int size, String tel, String dateVente) {
        Page<Vente> ventes = venteService.findAllVenteByClTelOrDate(tel, dateVente, PageRequest.of(page, size));
        Page<VenteListeDto> venteListeDtos = ventes.map(VenteListeDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(venteListeDtos.getContent(),
                venteListeDtos.getTotalElements(),
                venteListeDtos.getTotalPages(),
                (long) venteListeDtos.getContent().size(),
                new int[venteListeDtos.getTotalPages()],
                venteListeDtos.getTotalPages(),
                venteListeDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> ventesId(int id) {
        Vente vente = venteService.findByid((long) id);
        VenteDto venteDto = VenteDto.toDto(vente);
        RestResponsDto.response(venteDto, HttpStatus.OK);
        return new ResponseEntity<>(venteDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> totals(String tel, String dateVente) {
        return new ResponseEntity<>(venteService.total(tel, dateVente), HttpStatus.OK) ;
    }
}
