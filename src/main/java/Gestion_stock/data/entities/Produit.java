package Gestion_stock.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produit extends AbstractEntity{ //étendre abstractEntity pour pour hérité ces attribut et fonctions comme l'id
    @Column // pour dire l'attribut est une colonne de la table a la db
    private String libelle;
    @Column
    private Long total;
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
}
