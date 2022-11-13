package com.thapar.CropSaviour.bot;

import com.thapar.CropSaviour.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
public class CropSaviourBot extends TelegramLongPollingBot {

    @Autowired
    private KeyboardService keyboardService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private DatasetInfoService datasetInfoService;
    @Autowired
    private ClassifierService classifierService;
    @Autowired
    private TranslateService translateService;
    @Autowired
    private RemedyService remedyService;
    @Autowired
    private AudioService audioService;

    //    @Autowired
//    private MandiService mandiService;
    private final String IMAGE_DOWNLOAD_PATH = "/home/manav/Workspaces/TelegramBot_SpringBoot/Bot Service/src/main/java/com/thapar/CropSaviour/DownloadedImages/";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                messageHandler(update);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (update.hasCallbackQuery()) {
            try {
                callBackQueryHandler(update);
            } catch (TelegramApiException | IOException e) {
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
            textHandler(message, chatId, response);
        } else if (message.hasLocation()) {
            locationHandler(message);
        } else if (message.hasPhoto()) {
            photoHandler(message, chatId, response);
        } else {
            response.setText("INTERNAL PROBLEM OCCURRED!");
            execute(response);
        }
    }

    private void callBackQueryHandler(Update update) throws TelegramApiException, IOException {
        System.out.println("in callBackQuery");
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        String data = update.getCallbackQuery().getData();
        System.out.println(data);
//        String text = update.getCallbackQuery().getMessage().getText();
        String[] split = data.split("\\s+");
        List<String> splitList = Arrays.asList(split);
        System.out.println(Arrays.toString(splitList.toArray()));
        if (splitList.contains("language")) {
            handleLanguageKeyboard(chatId, data);
        } else if (splitList.contains("crop")) {
            handleCropKeyboard(chatId, data);
        }
    }

    private void textHandler(Message message, Long chatId, SendMessage response) throws IOException, TelegramApiException {
        System.out.println("in textHandler");
        System.out.println(message.getText());
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
        } else if (message.getText().equalsIgnoreCase("/help")) {
            if (userInfoService.isPresentLanguage(chatId)) {
                String language = userInfoService.getLanguageByChatId(chatId);
                String text = translateService.translateData("\uD83C\uDF3E\uD83C\uDF3EThis bot helps to find diseases in your crop\uD83C\uDF3E\uD83C\uDF3E", language) + "\n" + translateService.translateData("Check the menu below or type", language) + "/start";
                response.setText(text);
                execute(response);
            } else {
                String text = "\uD83E\uDEB4\uD83E\uDEB4Hello, Welcome to Crop Saviour Bot.\uD83E\uDEB4\uD83E\uDEB4\nCheck the menu below or type /start";
                response.setText(text);
                execute(response);
            }
        } else {
            if (userInfoService.isPresentLanguage(chatId)) {
                String language = userInfoService.getLanguageByChatId(chatId);
                String text = translateService.translateData("Hello, Welcome to Crop Saviour Bot. Please type ", language) + "/start";
                response.setText(text);
                execute(response);
            } else {
                String text = "Hello, Welcome to Crop Saviour Bot.\nPlease type /start";
                response.setText(text);
                execute(response);
            }
        }
    }

    private void locationHandler(Message message) throws TelegramApiException, IOException {
        System.out.println("in locationHandler");
        SendMessage response = new SendMessage();
        Long chatId = message.getChatId();
        response.setChatId(chatId);
        String language = userInfoService.getLanguageByChatId(chatId);
        String recentImagePath = userInfoService.getRecentImagePathByChatId(chatId);
        String location = "Your location: -\nLatitude: " + message.getLocation().getLatitude() + " Longitude: " + message.getLocation().getLongitude();
        response.setText(location);
        execute(response);
        if (recentImagePath == null) {
            if (userInfoService.isPresentLanguage(chatId)) {
                String text = translateService.translateData("Please send a image first then send location!", language);
                response.setText(text);
                execute(response);
            } else {
                String text = "Please type /start before sending location and follow the instructions";
                response.setText(text);
                execute(response);
            }
        } else {
            if (datasetInfoService.isFilePresent(recentImagePath)) {
                datasetInfoService.setLatLngByFilePath(recentImagePath, message.getLocation().getLatitude(), message.getLocation().getLongitude());
                userInfoService.setRecentImagePathNullByChatId(chatId);
            } else {
                if (userInfoService.isPresentLanguage(chatId)) {
                    String cropType = userInfoService.getCropByChatId(chatId);
                    if (cropType == null) {
                        response = keyboardService.sendInlineKeyboardForCrop(chatId);
                        execute(response);
                    }
//                    Case not possible!
//                    else{
//                    }
//                Case not possible!
//                }else{
//                }
                }
            }
        }

    }

    private void photoHandler(Message message, Long chatId, SendMessage response) throws TelegramApiException, IOException {
        System.out.println("in photoHandler");
        String file = downloadPhoto(message);
        userInfoService.setRecentImagePathByChatId(chatId, IMAGE_DOWNLOAD_PATH + file);
        System.out.println(file);
        if (!userInfoService.isPresentLanguage(chatId)) {
            response = keyboardService.sendInlineKeyboardForLanguage(chatId);
            execute(response);
        } else {
            String cropType = userInfoService.getCropByChatId(chatId);
            if (cropType != null) {
                predictDisease(chatId, IMAGE_DOWNLOAD_PATH + file, cropType);
            } else {
                response = keyboardService.sendInlineKeyboardForCrop(chatId);
                execute(response);
            }
        }
    }

    private void handleLanguageKeyboard(Long chatId, String data) throws TelegramApiException, IOException {
        System.out.println("in handleLanguageKeyboard");
        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        String[] split = data.split("\\s+");
        List<String> splitList = Arrays.asList(split);
        if (splitList.contains("englishButton")) {
            data = "english";
        } else if (splitList.contains("hindiButton")) {
            data = "hindi";
        } else {
            data = "punjabi";
        }
        userInfoService.setLanguageByChatId(data, chatId);
        System.out.println(userInfoService.getLanguageByChatId(chatId));
        response = keyboardService.sendInlineKeyboardForCrop(chatId);
        execute(response);
    }

    private void handleCropKeyboard(Long chatId, String data) throws TelegramApiException, FileNotFoundException {
        System.out.println("in handleCropKeyboard");
        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        String language = userInfoService.getLanguageByChatId(chatId);
        String[] split = data.split("\\s+");
        List<String> splitList = Arrays.asList(split);
        String recentImagePath = userInfoService.getRecentImagePathByChatId(chatId);
        System.out.println("existing imagePath== " + recentImagePath);
        if (recentImagePath != null) {
            if (splitList.contains("wheatButton")) {
                userInfoService.setCropByChatId("wheat", chatId);
                predictDisease(chatId, recentImagePath, "wheat");
            } else if (splitList.contains("riceButton")) {
                userInfoService.setCropByChatId("rice", chatId);
                predictDisease(chatId, recentImagePath, "rice");
            } else if (splitList.contains("weedButton")) {
                userInfoService.setCropByChatId("weed", chatId);
                predictDisease(chatId, recentImagePath, "weed");
            } else {
                userInfoService.setCropByChatId("mandi", chatId);
                mandiHandler();
            }
        } else {
            if (splitList.contains("wheatButton")) {
                data = "wheat";
            } else if (splitList.contains("riceButton")) {
                data = "rice";
            } else if (splitList.contains("weedButton")) {
                data = "weed";
            } else {
                data = "mandi";
            }
            userInfoService.setCropByChatId(data, chatId);
            String uploadImage = translateService.translateData("Please Upload Image", language);
            response.setText(uploadImage);
            execute(response);
        }
//        response = keyboardService.sendKeyboardForLocation(chatId);
//        execute(response);
    }

    private void mandiHandler() {

    }

    private void predictDisease(Long chatId, String filePath, String cropType) throws TelegramApiException, FileNotFoundException {
        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        String disease = classifierService.classifyDisease(filePath, cropType);
        //fix things for weed!
        disease = disease.substring(1, disease.length() - 1);
        System.out.println(disease);
        response.setText(disease);
        execute(response);
        response = remedyService.getRemedy(cropType, disease, chatId);
        execute(response);
        if (!disease.equalsIgnoreCase("no disease found")) {
            SendAudio audio = audioService.sendAudio(chatId, disease);
            if (audio != null) {
                execute(audio);
            }
        }
        //Modifying dataset database
        if (!datasetInfoService.isFilePresent(filePath)) {
            datasetInfoService.saveFile(chatId, cropType, disease, filePath, 0, 0);
        } else {
            System.out.println("File path already exists cannot modify dataset database!");
        }

        response = keyboardService.sendKeyboardForLocation(chatId);
        execute(response);
        userInfoService.setCropNull(chatId);
//        userInfoService.setRecentImagePathNullByChatId(chatId);
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

