package com.technology.adminitsration;

import com.technology.registration.dto.display.DisplayUserDto;
import com.technology.registration.services.role.RoleService;
import com.technology.registration.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministrationController {
    //TODO check if user to delete is not a current user
    private final RoleService roleService;
    private final UserService userService;
    @Autowired
    public AdministrationController(RoleService roleService,UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/admin/all-users")
    public List<DisplayUserDto> getUsers(){
        return userService.getAllUsers();
    }

    @PatchMapping("/admin/add-manager")
    public ResponseEntity<String> addManager(@RequestBody String username){
        roleService.addRoleManager(username);
        return ResponseEntity.ok("User role was changed to manager");
    }

    @PatchMapping("/admin/add-admin")
    public ResponseEntity<String> makeAdmin(@RequestBody String username){
        roleService.addRoleAdmin(username);
        return ResponseEntity.ok("User role was changed to admin");
    }

    @DeleteMapping("/admin/delete-manager")
    public ResponseEntity<String> deleteManager(@RequestBody String username){
        roleService.deleteRoleManager(username);
        return ResponseEntity.ok("User has no management authorities");
    }
}
