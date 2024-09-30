package Gestion_stock.services.impl;

import Gestion_stock.data.entities.Magasin;
import Gestion_stock.data.repositories.MagasinRepository;
import Gestion_stock.services.MagasinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MagasinServiceImpl implements MagasinService {
    private final MagasinRepository magasinRepository;
    @Override
    public Magasin findMagasinByVendeurId(int vendeurId) {
        return magasinRepository.findMagasinByVendeurId(vendeurId);
    }
}
