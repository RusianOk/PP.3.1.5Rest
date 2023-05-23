package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user) {
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<User> editUser (@RequestBody User user, @PathVariable Long id) {
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.delete(id);
    }
}
