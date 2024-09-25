package Gestion_stock.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Panier extends AbstractEntity{ //étendre abstractEntity pour pour hérité ces attribut et fonctions comme l'id
    @Column // pour dire l'attribut est une colonne de la table a la db
    private Long total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "panier")
    private List<DetailPanier> listDetailPanier;
}
