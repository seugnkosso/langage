package Gestion_stock.web.controllers;

import Gestion_stock.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface AdminController {
    @GetMapping("/admins") //Get request
    ResponseEntity<?> Admin(
            @RequestParam(defaultValue = "0") int page, //paramettre d'Url
            @RequestParam(defaultValue = GlobalVariable.size) int size
    );
}
