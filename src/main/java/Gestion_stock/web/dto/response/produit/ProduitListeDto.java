package Gestion_stock.web.dto.response.produit;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Produit;
import Gestion_stock.security.data.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitListeDto {
    private Long id;

    private String libelle;

    private Long qte;

    private String categorie;

    private String reference;

    private String photo;

    private Long prixAchat;

    private Long prixVente;

    private Long prixVenteMin;

    public static ProduitListeDto toDto(Produit produit) {
        return ProduitListeDto.builder()
                .id((long) produit.getId())
                .libelle(produit.getLibelle())
                .qte(produit.getQte())
                .categorie(produit.getCategorie())
                .reference(produit.getReference())
                .photo(produit.getPhoto())
                .prixAchat(produit.getPrixAchat())
                .prixVente(produit.getPrixVente())
                .prixVenteMin(produit.getPrixVenteMin())
                .build();
    }
}
