package com.Telegram.bot.database.service.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    @Column(nullable = false)
    private Long chatId;
    private Long userId;
    private String language;
    private String crop;
    private String recentImagePath;
}
