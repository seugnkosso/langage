package Gestion_stock.services.impl;

import Gestion_stock.data.entities.Produit;
import Gestion_stock.data.repositories.ProduitRepository;
import Gestion_stock.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    @Override
    public Page<Produit> findAllServiceBySearch(String search,int id, Pageable pageable) {
        return produitRepository.FindAllBySearch(search,id,pageable);
    }
}
