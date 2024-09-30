package Gestion_stock.data.repositories;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.data.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @Query("select p from Produit p " +
            "join p.magasin m " +
            "join m.listVendeur v " +
            "where (p.categorie like %:search% or p.libelle like %:search% or p.reference like %:search%)" +
            " and v.id = :idUser ")
    Page<Produit> FindAllBySearch(@Param("search") String search, @Param("idUser") int id, Pageable pageable);

    Produit findAllByLibelle(String libelle);
}
