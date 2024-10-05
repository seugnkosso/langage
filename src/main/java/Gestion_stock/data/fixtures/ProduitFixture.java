package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Magasin;
import Gestion_stock.data.entities.Produit;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.data.repositories.MagasinRepository;
import Gestion_stock.data.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProduitFixture {
    private final ProduitRepository produitRepository;
    private final MagasinRepository magasinRepository;

    public void run(){
        for (int i = 1; i < 20; i++) {
            Produit p = new Produit();
            p.setMagasin(magasinRepository.findById((long)1).get());
            p.setQte((long)i+20);
            p.setLibelle("produit"+i);
            p.setCategorie("categorie1"+i);
            p.setPhoto("photo");
            p.setPrixAchat((long)i+20000);
            p.setPrixVente((long)i+30000);
            p.setPrixVenteMin((long)i+40000);
            p.setReference("reference"+i);
            produitRepository.save(p);
        }
    }
}
