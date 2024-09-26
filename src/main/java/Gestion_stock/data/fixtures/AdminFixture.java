package Gestion_stock.data.fixtures;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFixture {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    public void run(){
        for (int i = 1; i < 20; i++) {
            Admin a = new Admin();
            a.setNomComplet("admin" + i);
            a.setPassword(passwordEncoder.encode("passer"));
            a.setEmail("admin" + i + "@gmail.com");
            a.setUsername("admin" + i);
            a.setTelephone("77233494"+i);
            adminRepository.save(a);
            securityService.addRoleToUser(a.getUsername(), "Admin");
        }
    }
}
