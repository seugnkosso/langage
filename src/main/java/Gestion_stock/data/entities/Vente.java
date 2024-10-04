package Gestion_stock.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vente extends AbstractEntity{ //étendre abstractEntity pour pour hérité ces attribut et fonctions comme l'id
    @Column // pour dire l'attribut est une colonne de la table a la db
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateVente;

    @Column
    private Long total;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Vendeur vendeur;

    @OneToMany(mappedBy = "vente")
    private List<DetailVente> listDetailVente;
}
