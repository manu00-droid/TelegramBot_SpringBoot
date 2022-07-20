package com.Telegram.bot.user.service.repository;

import com.Telegram.bot.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByChatId(Long chatId);
    @Query(value="select language from user where chat_id=?1",nativeQuery=true)
    public String findLanguageByChatId(Long chatId);
    @Query(value = "select crop from user where chat_id=?1",nativeQuery = true)
    public String findCropByChatId(Long chatId);
    @Modifying
    @Query(value = "update user set Crop=NULL where chat_id=?1",nativeQuery = true)
    public void setCropNull(Long chatId);
}
