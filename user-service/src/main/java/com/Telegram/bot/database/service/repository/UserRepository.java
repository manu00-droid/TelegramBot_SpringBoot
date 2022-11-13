package com.Telegram.bot.database.service.repository;

import com.Telegram.bot.database.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByChatId(Long chatId);

    @Query(value = "select language from user where chat_id=?1", nativeQuery = true)
    public String findLanguageByChatId(Long chatId);

    @Query(value = "select crop from user where chat_id=?1", nativeQuery = true)
    public String findCropByChatId(Long chatId);

    @Query(value = "select recent_image_path from user where chat_id=?1", nativeQuery = true)
    public String findRecentImagePathByChatId(Long chatId);

    @Modifying
    @Query(value = "update user set recent_image_path=?2 where chat_id=?1", nativeQuery = true)
    public void setRecentImagePath(Long chatId, String imagePath);

    @Modifying
    @Query(value = "update user set crop=NULL where chat_id=?1", nativeQuery = true)
    public void setCropNull(Long chatId);

    @Modifying
    @Query(value = "update user set recent_image_path=NULL where chat_id=?1", nativeQuery = true)
    public void setRecentImagePathNull(Long chatId);

}
