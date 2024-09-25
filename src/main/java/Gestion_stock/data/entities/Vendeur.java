package Gestion_stock.data.entities;

import Gestion_stock.security.data.entities.AppUser;
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
@DiscriminatorValue("vendeur") // sa valeur dans la table User
public class Vendeur extends AppUser { //étendre User pour qui hérite lui meme abstractEntity

    @ManyToOne
    private Magasin magasin;

    @OneToMany(mappedBy = "vendeur")
    private List<Vente> listVente;

}
