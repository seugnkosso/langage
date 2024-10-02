package Gestion_stock.web.dto.response.vente;

import Gestion_stock.data.entities.Vente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VenteListeDto {
    private Long VenteId;
    private String client;
    private String date;
    private Long total;


    public static VenteListeDto toDto(Vente vente) {
        return VenteListeDto.builder()
                .VenteId((long) vente.getId())
                .client(vente.getClient().getNomComplet()+" "+vente.getClient().getTelephone())
                .date(vente.getDateVente().toString())
                .total(vente.getTotal())
                .build();
    }
}
