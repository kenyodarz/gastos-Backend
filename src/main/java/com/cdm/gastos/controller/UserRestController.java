package com.cdm.gastos.controller;

import com.cdm.gastos.models.User;
import com.cdm.gastos.services.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    UserServiceAPI userServiceAPI;

    @GetMapping("/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<User> getAll(){
        return userServiceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public User find(@PathVariable Long id) {
        return userServiceAPI.get(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> save(@RequestBody User user) {
        User user1 = userServiceAPI.save(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User user = userServiceAPI.get(id);
        if (user != null) {
            userServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
