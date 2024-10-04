package Gestion_stock.web.dto.response.vente;

import Gestion_stock.data.entities.DetailVente;
import Gestion_stock.data.entities.Vente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailVenteListDto {
    private Long prix;
    private Long qte;
    private Long totalVente;
    private Long remise;
    private String libelle;


    public static DetailVenteListDto toDto(DetailVente detailVente) {
        return DetailVenteListDto.builder()
                .prix(detailVente.getPrix())
                .qte(detailVente.getQte())
                .totalVente(detailVente.getTotal())
                .remise(detailVente.getProduit().getPrixVente() - detailVente.getPrix())
                .libelle(detailVente.getProduit().getLibelle())
                .build();
    }
}
