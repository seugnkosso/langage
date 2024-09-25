package Gestion_stock.security.data.entities;

import Gestion_stock.data.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // permet l'instanciation de la classe plus facilement
@Inheritance(strategy = InheritanceType.JOINED) // dire la classe est a hérité et comment sont formé les table de la bd
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "user")
public class User extends AbstractEntity {

    @Column(unique = true, nullable = false)
    protected String nomComplet;

    @Column(unique = true, nullable = false)
    protected String email;

    @Column(unique = true, nullable = false)
    protected String telephone;

    @Column(unique = true, nullable = false)
    protected String username;

    @Column(nullable = false)
    protected String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns =@JoinColumn(name = "role_id")
    )
    protected List<Role> listrole = new ArrayList<>();

}
