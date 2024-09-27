package Gestion_stock.services;

import Gestion_stock.data.entities.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service //la classe est un service
public interface AdminService {
    Page<Admin> findAllAdmin(Pageable pageable);
}
