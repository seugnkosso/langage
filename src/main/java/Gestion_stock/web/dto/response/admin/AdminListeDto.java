package Gestion_stock.web.dto.response.admin;

import Gestion_stock.data.entities.Admin;
import Gestion_stock.security.data.entities.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminListeDto {
    private Long id;

    private String nomComplet;

    private String email;

    private String telephone;

    private List<String> listRole = new ArrayList<>();

    public static AdminListeDto toDto(Admin admin) {
        return AdminListeDto.builder()
                .id(admin.getId())
                .email(admin.getEmail())
                .nomComplet(admin.getNomComplet())
                .telephone(admin.getTelephone())
                .listRole(admin.getListRole().stream().map(Role::getRoleName).toList())
                .build();
    }
}
