package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.entities.Produit;
import Gestion_stock.services.ProduitService;
import Gestion_stock.services.impl.ProduitServiceImpl;
import Gestion_stock.web.controllers.ProduitController;
import Gestion_stock.web.dto.response.RestResponsDto;
import Gestion_stock.web.dto.response.produit.ProduitListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@Controller
@CrossOrigin(GlobalVariable.urlFront)
@RequiredArgsConstructor
public class ProduitControllerImpl implements ProduitController {
    private final ProduitService produitService;
    @Override
    public ResponseEntity<?> produit(int page, int size,int id, String search) {
        Page<Produit> produits = produitService.findAllServiceBySearch(search,id, PageRequest.of(page, size));

        Page<ProduitListeDto> produitListeDtos = produits.map(ProduitListeDto::toDto);

        Map<Object,Object> response = RestResponsDto.response(produitListeDtos.getContent(),
                produitListeDtos.getTotalElements(),
                produitListeDtos.getTotalPages(),
                (long) produitListeDtos.getContent().size(),
                new int[produitListeDtos.getTotalPages()],
                produitListeDtos.getTotalPages(),
                produitListeDtos.getNumber(),
                HttpStatus.OK
                );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
