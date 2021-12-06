package com.tech1io.controller;

import com.tech1io.entity.ColorEnum;
import com.tech1io.entity.Users;
import com.tech1io.request.UserSaveRequest;
import com.tech1io.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/age")
    public List<Users> getByAgeAfter(@RequestParam int age) {
        return userService.getByAgeAfter(age);
    }

    @PostMapping("/color")
    public List<Users> getAllByColor(@RequestParam ColorEnum color) {
        return userService.getAllByColor(color);
    }

    @PostMapping("/save")
    public void save(@RequestBody UserSaveRequest request) {
        userService.save(request);
    }

    @GetMapping("/name")
    public List<String> getName(@RequestParam int count) {
        return userService.getName(count);
    }
}
