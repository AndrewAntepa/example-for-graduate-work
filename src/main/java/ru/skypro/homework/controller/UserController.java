package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PatchMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public User getMe(){
        return new User();
    }

    @PatchMapping("/me")
    public ResponseEntity<?> updateMe(@RequestBody UpdateUser updateUser){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/me/image")
    public ResponseEntity<?> updateImage(@PathVariable String image){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
