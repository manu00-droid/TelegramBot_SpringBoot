package com.Telegram.bot.user.service.service;

import com.Telegram.bot.user.service.entity.User;
import com.Telegram.bot.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByChatId(Long chatId) {
        return userRepository.findByChatId(chatId);
    }
}
