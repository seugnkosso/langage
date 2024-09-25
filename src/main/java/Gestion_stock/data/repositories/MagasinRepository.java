package Gestion_stock.data.repositories;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin,Long> {
}
