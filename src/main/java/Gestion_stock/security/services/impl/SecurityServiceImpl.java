package Gestion_stock.security.services.impl;


import Gestion_stock.security.data.entities.Role;
import Gestion_stock.security.data.entities.AppUser;
import Gestion_stock.security.data.repositories.RoleRepository;
import Gestion_stock.security.data.repositories.UserRepository;
import Gestion_stock.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SecurityServiceImpl implements SecurityService, UserDetailsService {
    private final RoleRepository appRoleRepositories;
    private final UserRepository appUserRepositories;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Role saveRole(String roleName) {
        Role role = appRoleRepositories.findByRoleName(roleName);
        if (role != null) {
            throw new RuntimeException("role existe deja");
        }
        role = new Role(roleName, null);
        return appRoleRepositories.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        Role role = appRoleRepositories.findByRoleName(roleName);
        if (role == null) {
            throw new RuntimeException("role not found");
        }
        AppUser appUser = appUserRepositories.findByUsername(userName);
        if (appUser == null) {
            throw new RuntimeException("user not found");
        }
        appUser.getListRole().add(role);
        appUserRepositories.save(appUser);
    }

    @Override
    public void removeRoleToUser(String userName, String roleName) {
        Role role = appRoleRepositories.findByRoleName(roleName);
        if (role == null) {
            throw new RuntimeException("role not found");
        }
        AppUser appUser = appUserRepositories.findByUsername(userName);
        if (appUser == null) {
            throw new RuntimeException("user not found");
        }
        appUser.getListRole().remove(role);
        appUserRepositories.save(appUser);
    }

    @Override
    public AppUser getUserByUserName(String userName) {
        return appUserRepositories.findByUsername(userName);
    }

    @Override
    public AppUser saveUser(String username, String password) {
        AppUser appUser = appUserRepositories.findByUsername(username);
        if (appUser != null) {
            throw new RuntimeException("l'utilisateur existe deja");
        }
        appUser = new AppUser("user", "user", "user", username, passwordEncoder.encode(password), null);
        return appUserRepositories.save(appUser);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepositories.findByUsername(username);
        List<SimpleGrantedAuthority> authorize = appUser.getListRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).toList();
        return new User(appUser.getUsername(), appUser.getPassword(), authorize);
    }
}
