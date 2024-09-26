package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.web.controllers.AdminController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller //désigner que la classe est un controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.urlFront) // l'url du front qui peut accéder le back
public class AdminControllerImpl implements AdminController {
    private final AdminRepository adminRepository;
    @Override
    public ResponseEntity<?> Admin(int page, int size) {
        return null;
    }
}
