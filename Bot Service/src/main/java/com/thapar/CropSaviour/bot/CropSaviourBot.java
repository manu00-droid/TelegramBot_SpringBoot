package com.thapar.CropSaviour.bot;

import com.thapar.CropSaviour.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Comparator;
import java.util.List;

@Component
public class CropSaviourBot extends TelegramLongPollingBot {

    @Autowired
    private KeyboardService keyboardService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ClassifierService classifierService;
    @Autowired
    private TranslateService translateService;
    @Autowired
    private RemedyService remedyService;
    @Autowired
    private AudioService audioService;
    private final String IMAGE_DOWNLOAD_PATH = "/home/manav/Work/IdeaProjects/TelegramBot_SpringBoot/Bot Service/src/main/java/com/thapar/CropSaviour/DownloadedImages/";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                messageHandler(update);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (update.hasCallbackQuery()) {
            try {
                callBackQueryHandler(update);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void messageHandler(Update update) throws Exception {
        SendMessage response = new SendMessage();
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        response.setChatId(chatId);
        if (!userInfoService.isPresentUser(chatId)) {
            userInfoService.saveUser(message);
        }

        if (message.getText() != null) {
            if (message.getText().equalsIgnoreCase("/start")) {
                if (!userInfoService.isPresentLanguage(chatId)) {
                    response = keyboardService.sendInlineKeyboardForLanguage(chatId);
                    execute(response);
                } else {
                    response = keyboardService.sendInlineKeyboardForCrop(chatId);
                    execute(response);
                }
            } else if (message.getText().equalsIgnoreCase("/changeLanguage")) {
                response = keyboardService.sendInlineKeyboardForLanguage(chatId);
                execute(response);
            } else {
                String text = "Hello, Welcome to Crop Saviour Bot.\nPlease type /start";
                response.setText(text);
                execute(response);
            }
        } else if (message.hasPhoto()) {
            if (!userInfoService.isPresentLanguage(chatId)) {
                response = keyboardService.sendInlineKeyboardForLanguage(chatId);
                execute(response);
            } else {
                String file = downloadPhoto(message);
                String cropType = userInfoService.getCropByChatId(chatId);
                if (cropType != null) {
                    String disease = classifierService.classifyDisease(IMAGE_DOWNLOAD_PATH + file, cropType);
                    disease = disease.substring(1, disease.length() - 1);
                    System.out.println(disease);
                    response.setText(disease);
                    execute(response);
                    if (cropType.equalsIgnoreCase("rice")) {
                        response = remedyService.riceDiseaseRemedy(disease, chatId);
                    } else {
                        response = remedyService.wheatDiseaseRemedy(disease, chatId);
                    }
                    execute(response);
                    if (!disease.equalsIgnoreCase("no disease found")) {
                        execute(audioService.sendAudio(chatId, disease));
                    }
                } else {
                    response = keyboardService.sendInlineKeyboardForCrop(chatId);
                    execute(response);
                }
            }
        } else {
            response.setText("INTERNAL PROBLEM OCCURRED!");
            execute(response);
        }

    }

    private void callBackQueryHandler(Update update) throws TelegramApiException {
        SendMessage response = new SendMessage();
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        response.setChatId(chatId);
        String data = update.getCallbackQuery().getData();
        String text = update.getCallbackQuery().getMessage().getText();
        text = text.substring(14, 15);
        System.out.println(data.substring(0, 1));
        if (text.equalsIgnoreCase("L")) {
            if (data.substring(0, 1).equalsIgnoreCase("e")) {
                data = "english";
            } else if (data.substring(0, 1).equalsIgnoreCase("h")) {
                data = "hindi";
            } else {
                data = "punjabi";
            }
            userInfoService.setLanguageByChatId(data, chatId);
            response = keyboardService.sendInlineKeyboardForCrop(chatId);
            execute(response);
        } else {
            if (data.substring(0, 1).equalsIgnoreCase("w")) {
                data = "wheat";
            } else {
                data = "rice";
            }
            userInfoService.setCropByChatId(data, chatId);
            String language = userInfoService.getLanguageByChatId(chatId);
            String uploadImage = translateService.translateData("Please Upload Image", language);
            response.setText(uploadImage);
            execute(response);
        }
    }

    private String downloadPhoto(Message message) throws TelegramApiException {
        final List<PhotoSize> photos = message.getPhoto();
        final PhotoSize photoSize = photos.stream().max(Comparator.comparing(PhotoSize::getFileSize))
                .orElse(null);
        if (photoSize != null) {

            GetFile getFile = new GetFile();
            getFile.setFileId(photoSize.getFileId());
            String filePath = execute(getFile).getFilePath();
            String file_name = filePath.substring(7);
            java.io.File outputFile = new java.io.File(IMAGE_DOWNLOAD_PATH + file_name);
            java.io.File file = downloadFile(filePath, outputFile);
            return file_name;
        } else {
            return "PhotoSize object can't be null";
        }
    }

    @Override
    public String getBotUsername() {
        return "manav_testbot";
    }

    @Override
    public String getBotToken() {
        return "5459955578:AAG-Dr0d8bWluBk9y4RAuKFiWTRkg6JGHpI";
    }

}

