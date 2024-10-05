package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Vendeur;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.data.repositories.MagasinRepository;
import Gestion_stock.data.repositories.VendeurRepository;
import Gestion_stock.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class VendeurFixture {
    private final VendeurRepository vendeurRepository;
    private final MagasinRepository magasinRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    public void run(){
        for (int i = 1; i < 20; i++) {
            Vendeur v = new Vendeur();
            v.setNomComplet("vendeur" + i);
            v.setPassword(passwordEncoder.encode("passer"));
            v.setEmail("vendeur" + i + "@gmail.com");
            v.setUsername("vendeur" + i);
            v.setTelephone("77233496"+i);
            v.setMagasin(magasinRepository.findById((long)1).get());
            vendeurRepository.save(v);
            securityService.addRoleToUser(v.getUsername(), "Vendeur");
        }
    }
}
