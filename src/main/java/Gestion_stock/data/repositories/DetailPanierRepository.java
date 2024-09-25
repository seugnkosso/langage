package Gestion_stock.data.repositories;

import Gestion_stock.data.entities.Client;
import Gestion_stock.data.entities.DetailPanier;
import Gestion_stock.data.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailPanierRepository extends JpaRepository<DetailPanier,Long> {
}
