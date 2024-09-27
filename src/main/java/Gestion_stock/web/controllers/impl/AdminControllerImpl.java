package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.services.AdminService;
import Gestion_stock.web.controllers.AdminController;
import Gestion_stock.web.dto.response.RestResponsDto;
import Gestion_stock.web.dto.response.admin.AdminListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@Controller //désigner que la classe est un controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.urlFront) // l'url du front qui peut accéder le back
public class AdminControllerImpl implements AdminController {
    private final AdminService adminService;

    @Override
    public ResponseEntity<?> Admin(int page, int size) {
        Page<Admin> admins = adminService.findAllAdmin(PageRequest.of(page, size)); //récupération des admins par page au nombre de size
        Page<AdminListeDto> adminListeDtos = admins.map(AdminListeDto::toDto); //mappage des entité Admin en AdminListeDto

        Map<Object, Object> response = RestResponsDto.response(adminListeDtos.getContent(),
                adminListeDtos.getTotalElements(),
                adminListeDtos.getTotalPages(),
                (long) adminListeDtos.getContent().size(),
                new int[adminListeDtos.getTotalPages()],
                adminListeDtos.getTotalPages(),
                adminListeDtos.getNumber(),
                HttpStatus.OK); //creer un mappe pour les donnée fournis par la classe 1Page

        return new  ResponseEntity<>(response, HttpStatus.OK); //return un response entity
    }
}
