package Gestion_stock.services.impl;

import Gestion_stock.data.repositories.AdminRepository;
import Gestion_stock.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
}
