package Gestion_stock.services;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.entities.Vente;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service //la classe est un service
public interface VenteService {
   Page<Vente> findAllVenteByClTelOrDate(String tel, String dateVente, Pageable pageable);
   Long total(String tel, String dateVente);
}
