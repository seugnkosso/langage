package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.DetailPanier;
import Gestion_stock.data.entities.Panier;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.data.repositories.DetailPanierRepository;
import Gestion_stock.data.repositories.PanierRepository;
import Gestion_stock.data.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class DetailPanierFixture {
    private final DetailPanierRepository detailPanierRepository;
    private final ProduitRepository produitRepository;
    private final PanierRepository panierRepository;

    public void run(){
        for (int i = 1; i < 20; i++) {
            DetailPanier d = new DetailPanier();
            d.setPanier(panierRepository.findById((long)i).get());
            d.setProduit(produitRepository.findById((long)i).get());
            d.setQte((long)i+20);
            d.setTotal((long)i+2000);
            detailPanierRepository.save(d);
        }
    }
}
