package Gestion_stock.services.impl;

import Gestion_stock.data.entities.Vente;
import Gestion_stock.data.repositories.VenteRepository;
import Gestion_stock.services.VenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VenteServiceImpl implements VenteService {
    private final VenteRepository venteRepository;
    @Override
    public Page<Vente> findAllVenteByClTelOrDate(String tel, String dateVente, Pageable pageable) {
        if(!Objects.equals(dateVente, "") && !Objects.equals(tel, "")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date = format.parse(dateVente);
            } catch (ParseException e) {
            }
            return venteRepository.findAllVenteByClientTelOrDateVente(tel, date, pageable);
        }

        if(!Objects.equals(dateVente, "")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date = format.parse(dateVente);
            } catch (ParseException e) {
            }
            return venteRepository.findAllVenteByDateVente(date, pageable);
        }

        if(!Objects.equals(tel, "")) {
             return venteRepository.findAllVenteByClientTel(tel,pageable);
        }

        return venteRepository.findAll(pageable);

    }

    @Override
    public Vente findByid(Long venteid) {
        return venteRepository.findById(venteid).get();
    }

    @Override
    public Long total(String tel, String dateVente) {
        if(!Objects.equals(dateVente, "") && !Objects.equals(tel, "")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date = format.parse(dateVente);
            } catch (ParseException e) {
            }
            return venteRepository.totalByClientTelOrDateVente(tel, date);
        }

        if(!Objects.equals(dateVente, "")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date = format.parse(dateVente);
            } catch (ParseException e) {
            }
            return venteRepository.totalByDateVente(date);
        }

        if(!Objects.equals(tel, "")) {
            return venteRepository.totalByClientTel(tel);
        }

        return venteRepository.total();
    }
}
