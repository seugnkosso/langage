package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Panier;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.data.repositories.PanierRepository;
import Gestion_stock.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PanierFixture {
    private final PanierRepository panierRepository;
    private final ClientRepository clientRepository;

    public void run(){
        for (int i = 1; i < 20; i++) {
            Panier p = new Panier();
            p.setClient(clientRepository.findById((long)i+20).get());
            p.setTotal((long)i+20000);
            panierRepository.save(p);
        }
    }
}
