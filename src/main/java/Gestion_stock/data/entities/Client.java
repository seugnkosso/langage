package Gestion_stock.data.entities;

import Gestion_stock.security.data.entities.User;
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
@DiscriminatorValue("client") // sa valeur dans la table User
public class Client extends User{ //étendre User pour qui hérite lui meme abstractEntity

    @OneToMany(mappedBy = "client") // dit que cette un client peut etre concidèrer par plusieurs ventes - mappedBy = "client"(le nom de l'attribut dans vente)
    private List<Vente> listeVente;

    @OneToOne(mappedBy = "client")
    private Panier panier;

}
