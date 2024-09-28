package Gestion_stock.services.impl;

import Gestion_stock.data.entities.Produit;
import Gestion_stock.data.repositories.MagasinRepository;
import Gestion_stock.data.repositories.ProduitRepository;
import Gestion_stock.services.ProduitService;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
    private final MagasinRepository magasinRepository;
    @Override
    public Page<Produit> findAllServiceBySearch(String search,int id, Pageable pageable) {
        return produitRepository.FindAllBySearch(search,id,pageable);
    }

    @Override
    public Produit createProduit(ProduitRequestDto produitRequestDto) {
        produitRepository.save(Produit.builder()
                        .photo(produitRequestDto.getPhoto())
                        .qte(produitRequestDto.getQte())
                        .libelle(produitRequestDto.getLibelle())
                        .prixAchat(produitRequestDto.getPrixAchat())
                        .prixVente(produitRequestDto.getPrixVente())
                        .prixVenteMin(produitRequestDto.getPrixVenteMin())
                        .reference(produitRequestDto.getReference())
                        .magasin(magasinRepository.findById(produitRequestDto.getMagasinId()).get())
                        .categorie(produitRequestDto.getCategorie())
                        .build());
        return null;
    }
}
