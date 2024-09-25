package Gestion_stock.security.data.entities;

import Gestion_stock.data.entities.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String roleName;
}
