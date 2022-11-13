package com.Telegram.bot.database.service.controller;

import com.Telegram.bot.database.service.entity.User;
import com.Telegram.bot.database.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{chatId}")
    public Optional<User> getUserByChatId(@PathVariable("chatId") Long chatId) {
        Optional<User> user = Optional.ofNullable(userService.getUserByChatId(chatId));
        return user;
    }

    @GetMapping("/getlanguage/{chatId}")
    public Optional<String> getLanguageByChatId(@PathVariable("chatId") Long chatId) {
        Optional<String> language = Optional.ofNullable(userService.getLanguageByChatId(chatId));
        return language;
    }

    @GetMapping("/getcrop/{chatId}")
    public Optional<String> getCropByChatId(@PathVariable("chatId") Long chatId) {
        Optional<String> crop = Optional.ofNullable(userService.getCropByChatId(chatId));
        return crop;
    }

    @GetMapping("/getrecentimagepath/{chatId}")
    public Optional<String> getRecentImagePathByChatId(@PathVariable("chatId") Long chatId) {
        Optional<String> recentImagePath = Optional.ofNullable(userService.getRecentImagePath(chatId));
        return recentImagePath;
    }

    @PutMapping("/{chatId}")
    public User updateUser(@PathVariable("chatId") Long chatId, User user) {
        System.out.println(user);
        return userService.updateUser(chatId, user);
    }

    @PutMapping("setrecentimagepath/{chatId}/{recentImagePath}")
    public void setRecentImagePath(@PathVariable("chatId") Long chatId, @PathVariable("recentImagePath") String recentImagePath) {
        byte[] decodedBytes = Base64.getDecoder().decode(recentImagePath);
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString);
        userService.setRecentImagePath(chatId, decodedString);
    }

    @PutMapping("/setcropnull/{chatId}")
    public void setCropNull(@PathVariable("chatId") Long chatId) {
        userService.setCropNull(chatId);
    }

    @PutMapping("/setrecentimagepathnull/{chatId}")
    public void setRecentImagePathNull(@PathVariable("chatId") Long chatId) {
        userService.setRecentImagePathNull(chatId);
    }
}
