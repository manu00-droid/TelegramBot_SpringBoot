package com.Telegram.bot.user.service.controller;

import com.Telegram.bot.user.service.entity.User;
import com.Telegram.bot.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/chat-id/{chatId}")
    public User getUserByChatId(@PathVariable("Id") Long chatId){
        return userService.getUserByChatId(chatId);
    }

}
