package Gestion_stock.security.services;


import Gestion_stock.security.data.entities.Role;
import Gestion_stock.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUserName(String userName);

    AppUser saveUser(String username, String password);

    Role saveRole(String roleName);

    void addRoleToUser(String userName, String roleName);

    void removeRoleToUser(String userName, String roleName);
}
