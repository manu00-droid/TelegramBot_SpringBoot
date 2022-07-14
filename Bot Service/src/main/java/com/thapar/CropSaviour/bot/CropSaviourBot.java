package com.thapar.CropSaviour.bot;

import com.thapar.CropSaviour.Service.*;
import com.thapar.CropSaviour.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

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
    private final String IMAGE_DOWNLOAD_PATH = "/home/manav/Work/IdeaProjects/TelegramBot_SpringBoot/Bot Service/src/main/java/com/thapar/CropSaviour/DownloadedImages/";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                messageHandler(update);
            } catch (TelegramApiException e) {
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


    private void messageHandler(Update update) throws TelegramApiException {
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
                    String remedy;
                    if (cropType.equalsIgnoreCase("rice")) {
                        remedy = remedyService.riceDiseaseRemedy(disease, chatId);
                    } else {
                        remedy = remedyService.wheatDiseaseRemedy(disease, chatId);
                    }
                    response.setText(disease + "\n" + remedy);
                    execute(response);

//                    MultipartBodyBuilder builder = new MultipartBodyBuilder();
//                    builder.part("file", multipartFile.getResource());
//
//                    String url = "https://api.telegram.org/5459955578:AAG-Dr0d8bWluBk9y4RAuKFiWTRkg6JGHpI/sendAudio";
//                    MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
//                    bodyValues.add("chat_id", chatId.toString());
//                    bodyValues.add("audio", "/home/manav/Work/IdeaProjects/TelegramBot_SpringBoot/Bot Service/src/main/java/com/thapar/CropSaviour/Bacterial Blight_rice_english.mp3");
//                    WebClient webClient = WebClient.create();
//                    Message message1 = webClient.post()
//                            .uri(url)
//                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                            .body(BodyInserters.fromFormData(bodyValues))
//                            .retrieve()
//                            .bodyToMono(Message.class).block();

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

