package Gestion_stock.services;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.entities.Vente;
import Gestion_stock.web.dto.request.DetailVenteRequestDto;
import Gestion_stock.web.dto.request.FaireVenteRequestDto;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import org.springframework.stereotype.Service;

@Service //la classe est un service
public interface FaireVenteService {
   Vente FaireVente(FaireVenteRequestDto faireVenteRequestDto);
   Vente detailvente(DetailVenteRequestDto detailVenteRequestDto);
}
