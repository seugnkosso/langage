package Gestion_stock.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //génère le constructeur de tous les attribut
@NoArgsConstructor //génére le constructeur zero
@MappedSuperclass //mean c'est une superclasse et n'est associé a aucun table a la db
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Boolean isActive = true;
}
