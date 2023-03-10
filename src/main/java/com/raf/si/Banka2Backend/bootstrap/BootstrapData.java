package com.raf.si.Banka2Backend.bootstrap;

import com.raf.si.Banka2Backend.models.Permission;
import com.raf.si.Banka2Backend.models.PermissionName;
import com.raf.si.Banka2Backend.models.User;
import com.raf.si.Banka2Backend.repositories.PermissionRepository;
import com.raf.si.Banka2Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BootstrapData(UserRepository userRepository, PermissionRepository permissionRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception { // Run only once-first time, after that comment content of this method

        User admin = User.builder()
                .email("admin@gmail.com")
                .firstName("Admin")
                .lastName("Adminic")
                .password( this.passwordEncoder.encode("admin"))
                .jmbg("2902968000000")
                .phone("0657817522")
                .jobPosition("administrator")
                .active(true)
                .build();

        List<Permission> permissions = new ArrayList<>();
        Permission adminPermission = new Permission(PermissionName.ADMIN_USER);
        Permission readPermission = new Permission(PermissionName.READ_USERS);
        Permission createPermission = new Permission(PermissionName.CREATE_USERS);
        Permission updatePermission = new Permission(PermissionName.UPDATE_USERS);
        Permission deletePermission = new Permission(PermissionName.DELETE_USERS);
        permissions.add(adminPermission);
        this.permissionRepository.save(adminPermission);
        this.permissionRepository.save(readPermission);
        this.permissionRepository.save(createPermission);
        this.permissionRepository.save(updatePermission);
        this.permissionRepository.save(deletePermission);

        admin.setPermissions(permissions);
        this.userRepository.save(admin);
    }
}