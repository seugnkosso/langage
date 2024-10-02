package Gestion_stock.web.dto.response.client;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientListeDto {
    private String telephone;
    private String username;

    public static ClientListeDto toDto(Client client) {
        return ClientListeDto.builder()
                .telephone(client.getTelephone())
                .username(client.getUsername())
                .build();
    }
}
