package Gestion_stock.web.dto.request;

import Gestion_stock.data.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitRequestDto {
    private String libelle;

    private Long qte;

    private String categorie;

    private String reference;

    private String photo;

    private Long prixAchat;

    private Long prixVente;

    private Long prixVenteMin;

    private Long magasinId;
}
