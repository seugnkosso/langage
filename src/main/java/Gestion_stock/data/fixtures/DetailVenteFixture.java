package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.DetailPanier;
import Gestion_stock.data.entities.DetailVente;
import Gestion_stock.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class DetailVenteFixture {
    private final DetailVenteRepository detailVenteRepository;
    private final ProduitRepository produitRepository;
    private final VenteRepository venteRepository;

    public void run(){
        for (int i = 1; i < 20; i++) {
            DetailVente d = new DetailVente();
            d.setProduit(produitRepository.findById((long)i).get());
            d.setVente(venteRepository.findById((long)i).get());
            d.setTotal((long)i+20000);
            d.setQte((long)i+15);
            detailVenteRepository.save(d);
        }
    }
}
