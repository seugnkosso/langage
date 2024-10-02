package Gestion_stock.web.controllers.impl;

import Gestion_stock.config.GlobalVariable;
import Gestion_stock.data.entities.Client;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.services.ClientService;
import Gestion_stock.web.controllers.ClientController;
import Gestion_stock.web.dto.response.RestResponsDto;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@Controller
@CrossOrigin(GlobalVariable.urlFront)
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<?> create(ClientListeDto clientListeDto) {
        Client client = clientService.create(clientListeDto);
        ClientListeDto clientListeDto1 = ClientListeDto.toDto(client);
        Map<Object, Object> response = RestResponsDto.response(clientListeDto1, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> clientTelephone(String tel) {
        Client client = clientService.findByTel(tel);
        if (client != null) {
            ClientListeDto clientListeDto = ClientListeDto.toDto(client);
            Map<Object, Object> response = RestResponsDto.response(clientListeDto, HttpStatus.OK);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
