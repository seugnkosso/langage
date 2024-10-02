package Gestion_stock.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FaireVenteRequestDto {
    private String clientTelephone;
    private Long idVendeur;
    private Long total;
}

