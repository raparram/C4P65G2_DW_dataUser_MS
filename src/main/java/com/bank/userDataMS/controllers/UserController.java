/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.userDataMS.controllers;

import com.bank.userDataMS.models.User;
import com.bank.userDataMS.repositories.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor(onConstructor = @__(
        @Autowired))
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/new")
    User newUser(@RequestBody User user) {
        if (userRepository.existsById(user.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese username. Creación de usuario declinada.");
        }
        user.setState(true);
        user.setAccount(false);
        user.setForex(false);
        return userRepository.save(user);
    }

    @GetMapping("/{username}")
    User getUser(@PathVariable String username) {
        return userRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario con ese username."));
    }

    @GetMapping("/all")
    List<User> getAllUser() {
        return userRepository.findAll();
    }

    @PutMapping("/{username}")
    User updateUser(@PathVariable String username, @RequestBody User userUpdate) {
        if (userRepository.existsById(username) == false) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay un usuario asociado a " + username);
        }
        userRepository.save(userUpdate);
        return userUpdate;
    }

    @PutMapping("/disable/{username}")
    User disableUser(@PathVariable String username) {
        User userDisable = userRepository.findById(username).orElse(null);
        if (userDisable == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay un usuario asociado a " + username + ". Desactivación declinada.");
        }
        userDisable.setState(false);
        userRepository.save(userDisable);
        return userDisable;
    }

    @PutMapping("/activate/{username}")
    User activateUser(@PathVariable String username) {
        User userDisable = userRepository.findById(username).orElse(null);
        if (userDisable == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay un usuario asociado a " + username + ". Activación declinada.");
        }
        userDisable.setState(true);
        userRepository.save(userDisable);
        return userDisable;
    }

    @PutMapping("/udapte/states/{username}")
    User updateStatesUser(@PathVariable String username, @RequestBody User userUpdate) {
        User user = userRepository.findById(username).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay un usuario asociado a " + username + ". Activación declinada.");
        }
        user.setState(userUpdate.isState());
        user.setAccount(userUpdate.isAccount());
        user.setForex(userUpdate.isForex());
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/{username}")
    User deleteUsert(@PathVariable String username) {
        User userDelete = userRepository.findById(username).orElse(null);
        if (userDelete == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe el usuario " + username);
        }
        userRepository.delete(userDelete);
        return userDelete;
    }

}
