package Gestion_stock.web.dto.response.vente;

import Gestion_stock.data.entities.Produit;
import Gestion_stock.data.entities.Vente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VenteSelectDto {
    private Long id;

    public static VenteSelectDto toDto(Vente vente) {
        return VenteSelectDto.builder()
                .id((long) vente.getId())
                .build();
    }
}
