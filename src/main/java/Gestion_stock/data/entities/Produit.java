package Gestion_stock.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Produit extends AbstractEntity{ //étendre abstractEntity pour pour hérité ces attribut et fonctions comme l'id
    @Column // pour dire l'attribut est une colonne de la table a la db
    private String libelle;
    @Column
    private Long qte;
    @Column
    private String categorie;
    @Column
    private String reference;
    @Column
    private String photo;
    @Column
    private Long prixAchat;
    @Column
    private Long prixVente;
    @Column
    private Long prixVenteMin;

    @OneToMany(mappedBy = "produit")
    private List<DetailPanier> listDetailPanier;

    @OneToMany(mappedBy = "produit")
    private List<DetailVente> listDetailVente;

    @ManyToOne
    private Magasin magasin;
}
