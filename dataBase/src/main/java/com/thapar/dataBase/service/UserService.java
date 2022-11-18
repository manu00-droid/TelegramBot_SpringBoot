package com.thapar.dataBase.service;

import com.thapar.dataBase.entity.User;
import com.thapar.dataBase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByChatId(Long chatId) {
        return userRepository.findByChatId(chatId);
    }

    public String getLanguageByChatId(Long chatId) {
        return userRepository.findLanguageByChatId(chatId);
    }

    public String getCropByChatId(Long chatId) {
        return userRepository.findCropByChatId(chatId);
    }

    public User updateUser(Long chatId, User user) {
        User userDB = userRepository.findByChatId(chatId);
        if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
            userDB.setUserName(user.getUserName());
        }
        if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
            userDB.setFirstName(user.getFirstName());
        }
        if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
            userDB.setLastName(user.getLastName());
        }
        if (Objects.nonNull(user.getUserId())) {
            userDB.setUserId(user.getUserId());
        }
        if (Objects.nonNull(user.getCrop()) && !"".equalsIgnoreCase(user.getCrop())) {
            userDB.setCrop(user.getCrop());
        }
        if (Objects.nonNull(user.getLanguage()) && !"".equalsIgnoreCase(user.getLanguage())) {
            userDB.setLanguage(user.getLanguage());
        }
//        if (Objects.nonNull(user.getRecentImagePath()) && "".equalsIgnoreCase(user.getRecentFilePath())) {
//            userDB.setRecentFilePath(user.getRecentFilePath());
//        }

        return userRepository.save(userDB);
    }

    public void setCropNull(Long chatId) {
        userRepository.setCropNull(chatId);
    }


    public void setRecentImagePath(Long chatId, String imagePath) {
//        imagePath = "\"" + imagePath + "\"";
        System.out.println(imagePath);
        userRepository.setRecentImagePath(chatId, imagePath);
    }

    public String getRecentImagePath(Long chatId) {
        return userRepository.findRecentImagePathByChatId(chatId);
    }

    public void setRecentImagePathNull(Long chatId) {
        userRepository.setRecentImagePathNull(chatId);
    }
}
