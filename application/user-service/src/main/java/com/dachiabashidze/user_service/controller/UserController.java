package com.dachiabashidze.user_service.controller;

import com.dachiabashidze.user_service.entity.Order;
import com.dachiabashidze.user_service.entity.User;
import com.dachiabashidze.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

        //return all users
    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
        //return user by id
    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }
    @GetMapping("/{userId}/order")
    public Mono<Order> getUserOrder(@PathVariable Long userId){
        return userService.getUserOrder(userId);
    }
    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
