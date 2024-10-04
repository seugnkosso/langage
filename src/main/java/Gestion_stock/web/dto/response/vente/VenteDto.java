package Gestion_stock.web.dto.response.vente;

import Gestion_stock.data.entities.DetailVente;
import Gestion_stock.data.entities.Vente;
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
public class VenteDto {
    private Long VenteId;
    private String client;
    private String date;
    private Long total;
    private String magasin;
    private String address;
    private String tel;
    private List<DetailVenteListDto> detailVenteListDtos = new ArrayList<>();

    public static VenteDto toDto(Vente vente) {
        return VenteDto.builder()
                .VenteId((long) vente.getId())
                .client(vente.getClient().getNomComplet()+" "+vente.getClient().getTelephone())
                .date(vente.getDateVente().toString())
                .total(vente.getTotal())
                .tel(vente.getVendeur().getMagasin().getTelephone())
                .magasin(vente.getVendeur().getMagasin().getLibelle())
                .address(vente.getVendeur().getMagasin().getAdress())
                .detailVenteListDtos(vente.getListDetailVente().stream().map(DetailVenteListDto::toDto).toList())
                .build();
    }
}


