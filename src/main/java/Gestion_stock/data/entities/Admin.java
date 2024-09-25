package Gestion_stock.data.entities;

import Gestion_stock.security.data.entities.AppUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
//@AllArgsConstructor
//@NoArgsConstructor
@Data
@DiscriminatorValue("admin") // sa valeur dans la table User
public class Admin extends AppUser { //étendre User pour qui hérite lui meme abstractEntity

}
