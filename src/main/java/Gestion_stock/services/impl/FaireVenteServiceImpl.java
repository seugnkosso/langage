package Gestion_stock.services.impl;

import Gestion_stock.data.entities.DetailVente;
import Gestion_stock.data.entities.Produit;
import Gestion_stock.data.entities.Vente;
import Gestion_stock.data.repositories.*;
import Gestion_stock.services.FaireVenteService;
import Gestion_stock.web.dto.request.DetailVenteRequestDto;
import Gestion_stock.web.dto.request.FaireVenteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class FaireVenteServiceImpl implements FaireVenteService {
    private  final VenteRepository venteRepository;
    private  final ProduitRepository produitRepository;
    private  final ClientRepository clientRepository;
    private  final VendeurRepository vendeurRepository;
    private  final DetailVenteRepository detailVenteRepository;

    @Override
    public Vente FaireVente(FaireVenteRequestDto faireVenteRequestDto) {
        return venteRepository.save(
                Vente.builder()
                        .total(faireVenteRequestDto.getTotal())
                        .client(clientRepository.findClientByTelephone(faireVenteRequestDto.getClientTelephone()))
                        .vendeur(vendeurRepository.findById(faireVenteRequestDto.getIdVendeur()).get())
                        .dateVente(new Date())
                        .build()
        );
    }

    @Override
    public Vente detailvente(DetailVenteRequestDto detailVenteRequestDto) {
        Produit produit = produitRepository.findById(detailVenteRequestDto.getProduitId()).get();
        detailVenteRepository.save(
            DetailVente.builder()
                    .vente(venteRepository.findById(detailVenteRequestDto.getVenteId()).get())
                    .prix(detailVenteRequestDto.getPrix())
                    .qte(detailVenteRequestDto.getQte())
                    .produit(produit)
                    .total(detailVenteRequestDto.getTotal())
                    .build()
        );

        produit.setQte(produit.getQte() - detailVenteRequestDto.getQte());
        produitRepository.save(produit);
        return null;
    }
}
