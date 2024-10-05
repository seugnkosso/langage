package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Magasin;
import Gestion_stock.data.entities.Panier;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.data.repositories.MagasinRepository;
import Gestion_stock.data.repositories.PanierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MagasinFixture {
    private final MagasinRepository magasinRepository;
    private final ClientRepository clientRepository;

    public void run(){
            Magasin m = new Magasin();
            m.setTelephone("+221 33 867 74 48 / +221 76 666 66 38");
            m.setAdress("Sébikotane, en face PAMECAS");
            m.setLibelle("LE VIRAGE ELECTRONIQUE");
            magasinRepository.save(m);
    }
}
