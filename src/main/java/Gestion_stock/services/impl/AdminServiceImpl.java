package Gestion_stock.services.impl;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public Page<Admin> findAllAdmin(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }
}
