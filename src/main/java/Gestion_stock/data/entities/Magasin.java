package Gestion_stock.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Magasin extends AbstractEntity{ //étendre abstractEntity pour pour hérité ces attribut et fonctions comme l'id
    @Column // pour dire l'attribut est une colonne de la table a la db
    private String libelle;

    @Column
    private String telephone;

    @Column
    private String adress;

    @OneToMany(mappedBy = "magasin")
    private List<Produit> listProduit;

    @OneToMany(mappedBy = "magasin")
    private List<Vendeur> listVendeur;


}
