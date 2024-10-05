package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.DetailPanier;
import Gestion_stock.data.entities.Vente;
import Gestion_stock.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VenteFixture {
    private final VenteRepository venteRepository;
    private final ClientRepository clientRepository;
    private final VendeurRepository vendeurRepository;

    public void run(){
        for (int i = 1; i < 20; i++) {
            Vente v = new Vente();
            v.setClient(clientRepository.findById((long)i+20).get());
            v.setVendeur(vendeurRepository.findById((long)i+39).get());
            v.setTotal((long)i+20000000);
            v.setDateVente(new Date());
            venteRepository.save(v);
        }
    }
}
