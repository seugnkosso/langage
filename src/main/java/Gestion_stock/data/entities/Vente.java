package Gestion_stock.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity //dire que la classe est une entité
@Table //dire la classe est une table a la db
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vente extends AbstractEntity{ //étendre abstractEntity pour pour hérité ces attribut et fonctions comme l'id
    @Column // pour dire l'attribut est une colonne de la table a la db
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "EEEE, yyyy-MMMMM-dd HH:mm:ss")
    private Date dateVente;

    @Column
    private Long total;
}
