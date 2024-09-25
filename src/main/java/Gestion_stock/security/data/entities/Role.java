package Gestion_stock.security.data.entities;

import Gestion_stock.data.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listRole")
    private List<User> users;
}
