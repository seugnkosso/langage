package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Client;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class ClientFixture {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    public void run(){
        for (int i = 1; i < 20; i++) {
            Client c = new Client();
            c.setNomComplet("client" + i);
            c.setPassword(passwordEncoder.encode("passer"));
            c.setEmail("client" + i + "@gmail.com");
            c.setUsername("client" + i);
            c.setTelephone("77233495"+i);
            clientRepository.save(c);
            securityService.addRoleToUser(c.getUsername(), "Client");
        }
    }
}
