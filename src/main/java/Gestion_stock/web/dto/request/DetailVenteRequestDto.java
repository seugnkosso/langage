package Gestion_stock.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailVenteRequestDto {
    private Long venteId;
    private Long produitId;
    private Long prix;
    private Long qte;
    private Long total;
}

