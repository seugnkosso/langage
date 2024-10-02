package Gestion_stock.data.repositories;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Vente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Long> {
    @Query("select v from Vente v join v.client cl where cl.telephone like %:tel% and v.dateVente = :date")
    Page<Vente> findAllVenteByClientTelOrDateVente(@Param("tel") String tel, @Param("date") Date dateVente, Pageable pageable);

    @Query("select v from Vente v where v.dateVente = :date")
    Page<Vente> findAllVenteByDateVente(@Param("date") Date dateVente, Pageable pageable);

    @Query("select v from Vente v join v.client cl where cl.telephone like %:tel%")
    Page<Vente> findAllVenteByClientTel(@Param("tel") String tel,Pageable pageable);

    Page<Vente> findAll(Pageable pageable);


    @Query("select sum(v.total) from Vente v join v.client cl where cl.telephone like %:tel% and v.dateVente = :date")
    Long totalByClientTelOrDateVente(@Param("tel") String tel, @Param("date") Date dateVente);

    @Query("select sum(v.total) from Vente v where v.dateVente = :date")
    Long totalByDateVente(@Param("date") Date dateVente);

    @Query("select sum(v.total) from Vente v join v.client cl where cl.telephone like %:tel%")
    Long totalByClientTel(@Param("tel") String tel);

    @Query("select sum(v.total) from Vente v")
    Long total();
}
