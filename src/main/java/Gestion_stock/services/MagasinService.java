package Gestion_stock.services;

import Gestion_stock.data.entities.Magasin;
import Gestion_stock.data.entities.Produit;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service //la classe est un service
public interface MagasinService {
    Magasin findMagasinByVendeurId(int vendeurId);
}
