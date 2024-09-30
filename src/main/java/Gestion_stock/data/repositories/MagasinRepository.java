package Gestion_stock.data.repositories;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Magasin;
import Gestion_stock.data.entities.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin,Long> {
    @Query("Select m from Magasin m join m.listVendeur v where v.id = :idUser")
    Magasin findMagasinByVendeurId(@Param("idUser") int id);
}
