package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class RunFixture implements CommandLineRunner {
    private final AdminFixture adminFixture;
    private final ClientFixture clientFixture;
    private final MagasinFixture magasinFixture;
    private final PanierFixture panierFixture;
    //private final ProduitFixture produitFixture;
    private final VendeurFixture vendeurFixture;
    private final VenteFixture venteFixture;
    private final DetailPanierFixture detailPanierFixture;
    private final DetailVenteFixture detailVenteFixture;

    @Override
    public void run(String... args) throws Exception {
        adminFixture.run();
        clientFixture.run();
        magasinFixture.run();
       // panierFixture.run();
        //produitFixture.run();
        vendeurFixture.run();
        //venteFixture.run();
        //detailPanierFixture.run();
        //detailVenteFixture.run();
    }
}
