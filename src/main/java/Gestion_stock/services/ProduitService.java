package Gestion_stock.services;

import Gestion_stock.data.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service //la classe est un service
public interface ProduitService {
    Page<Produit> findAllServiceBySearch(String search,int id, Pageable pageable);
}
