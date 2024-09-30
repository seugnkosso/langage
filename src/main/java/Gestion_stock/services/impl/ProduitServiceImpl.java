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

import java.util.Optional;

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

    @Override
    public Produit getProduitByLibelle(String libelle) {
        return produitRepository.findAllByLibelle(libelle);
    }

    @Override
    public Produit updateProduit(ProduitRequestDto produitRequestDto) {
        Optional<Produit> produit = produitRepository.findById(produitRequestDto.getId());
        if (produit.isPresent()) {
            Produit produit1 = produit.get();
            produit1.setQte(produitRequestDto.getQte());
            produit1.setLibelle(produitRequestDto.getLibelle());
            produit1.setPrixAchat(produitRequestDto.getPrixAchat());
            produit1.setPrixVente(produitRequestDto.getPrixVente());
            produit1.setPrixVenteMin(produitRequestDto.getPrixVenteMin());
            produit1.setReference(produitRequestDto.getReference());
            produit1.setPhoto(produitRequestDto.getPhoto());
            produit1.setCategorie(produitRequestDto.getCategorie());
            produit1.setMagasin(magasinRepository.findById(produitRequestDto.getMagasinId()).get());
            produitRepository.save(produit1);
            return produit1;
        }
        return null;
    }
}
