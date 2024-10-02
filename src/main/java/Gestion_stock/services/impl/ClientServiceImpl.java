package Gestion_stock.services.impl;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.repositories.ClientRepository;
import Gestion_stock.security.data.entities.AppUser;
import Gestion_stock.services.ClientService;
import Gestion_stock.web.dto.response.client.ClientListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Client findByTel(String tel) {
        return clientRepository.findClientByTelephone(tel);
    }

    @Override
    public Client create(ClientListeDto clientListeDto) {
        Client client = new Client();
        client.setPassword(passwordEncoder.encode(clientListeDto.getTelephone()));
        client.setEmail(clientListeDto.getUsername()+clientRepository.count()+"1"+"@gmail.com");
        client.setTelephone(clientListeDto.getTelephone());
        client.setUsername(clientListeDto.getUsername()+clientRepository.count()+"1");
        client.setNomComplet(clientListeDto.getUsername());
        return clientRepository.save(client);
    }
}
