package Gestion_stock.web.dto.response.magasin;

import Gestion_stock.data.entities.Magasin;
import Gestion_stock.data.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MagasinSelectDto {
    private Long id;

    private String libelle;


    public static MagasinSelectDto toDto(Magasin magasin) {
        return MagasinSelectDto.builder()
                .id((long) magasin.getId())
                .libelle(magasin.getLibelle())
                .build();
    }
}
