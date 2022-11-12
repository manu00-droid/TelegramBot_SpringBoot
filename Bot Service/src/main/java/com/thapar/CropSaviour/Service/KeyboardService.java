package com.thapar.CropSaviour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class KeyboardService {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private TranslateService translateService;

    public SendMessage sendInlineKeyboardForLanguage(Long chatId) {
        System.out.println("in Keyboard Service for language");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("English");
        inlineKeyboardButton1.setCallbackData("language englishButton");
        inlineKeyboardButton2.setText("Hindi");
        inlineKeyboardButton2.setCallbackData("language hindiButton");
        inlineKeyboardButton3.setText("Punjabi");
        inlineKeyboardButton3.setCallbackData("language punjabiButton");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        inlineKeyboardMarkup.setKeyboard(rowList);
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chatId));
        response.setText("Please Select Language\n" + "कृपया भाषा चुनें\n" + "ਕਿਰਪਾ ਕਰਕੇ ਭਾਸ਼ਾ ਚੁਣੋ\n");
        response.setReplyMarkup(inlineKeyboardMarkup);
        return response;
    }

    public SendMessage sendInlineKeyboardForCrop(Long chatId) throws IOException {
        System.out.println("in Keyboard Service for crop");
        String language = userInfoService.getLanguageByChatId(chatId);
        String wheat = translateService.translateData("Wheat", language);
        String rice = translateService.translateData("Rice", language);
        String weed = translateService.translateData("Weed detection", language);
        String mandiRate = translateService.translateData("Mandi Rate", language);
        String selectCrop = translateService.translateData("Please Select Crop", language);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText(rice);
        inlineKeyboardButton1.setCallbackData("crop riceButton");
        inlineKeyboardButton2.setText(wheat);
        inlineKeyboardButton2.setCallbackData("crop wheatButton");
        inlineKeyboardButton3.setText(weed);
        inlineKeyboardButton3.setCallbackData("crop weedButton");
        inlineKeyboardButton4.setText(mandiRate);
        inlineKeyboardButton4.setCallbackData("crop mandiButton");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        keyboardButtonsRow4.add(inlineKeyboardButton4);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        inlineKeyboardMarkup.setKeyboard(rowList);
        SendMessage response = new SendMessage();
        response.setChatId(String.valueOf(chatId));
        response.setText(selectCrop);
        response.setReplyMarkup(inlineKeyboardMarkup);
        return response;
    }

    public SendMessage sendKeyboardForLocation(Long chatId) {
        System.out.println("in Keyboard Service for location");
        String language = userInfoService.getLanguageByChatId(chatId);
        String locationRequest = translateService.translateData("Tap to send Location", language);
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setRequestLocation(true);
        keyboardButton.setText(locationRequest);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(keyboardButton);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        keyboardRowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        response.setText(translateService.translateData("Please send your location", language));
        response.setReplyMarkup(replyKeyboardMarkup);
        return response;
    }
}
