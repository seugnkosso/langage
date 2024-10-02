package Gestion_stock.services;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.entities.Produit;
import Gestion_stock.web.dto.request.ProduitRequestDto;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service //la classe est un service
public interface ClientService {
   Client findByTel(String tel);

   Client create(ClientListeDto clientListeDto);
}
