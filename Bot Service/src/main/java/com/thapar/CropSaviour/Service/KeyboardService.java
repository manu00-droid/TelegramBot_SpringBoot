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
        inlineKeyboardButton2.setText("हिन्दी");
        inlineKeyboardButton2.setCallbackData("language hindiButton");
        inlineKeyboardButton3.setText("ਪੰਜਾਬੀ");
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
        if (userInfoService.isPresentUser(chatId)) {
            response.setText("Please Select Language\n" + "         कृपया भाषा चुनें\n" + "     ਕਿਰਪਾ ਕਰਕੇ ਭਾਸ਼ਾ ਚੁਣੋ\n");
        } else {
            response.setText("\uD83E\uDEB4\uD83E\uDEB4\uD83E\uDEB4Welcome\uD83E\uDEB4\uD83E\uDEB4\uD83E\uDEB4\nPlease Select Language\n" + "         कृपया भाषा चुनें\n" + "     ਕਿਰਪਾ ਕਰਕੇ ਭਾਸ਼ਾ ਚੁਣੋ\n");
        }
        response.setReplyMarkup(inlineKeyboardMarkup);
        return response;
    }

    public SendMessage sendInlineKeyboardForCrop(Long chatId) throws IOException {
        System.out.println("in Keyboard Service for crop");
        String language = userInfoService.getLanguageByChatId(chatId);
        String wheat = "\uD83C\uDF3E" + translateService.translateData("Wheat", language) + "\uD83C\uDF3E";
        String rice = translateService.translateData("\uD83C\uDF5ARice\uD83C\uDF5A", language);
        String weed = translateService.translateData("\uD83C\uDF3FWeed detection\uD83C\uDF3F", language);
        String mandiRate = translateService.translateData("\uD83D\uDCB0Mandi Rate\uD83D\uDCB0", language);
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
        String locationRequest = translateService.translateData("Tap to send Location", language) + "\uD83D\uDCCD";
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
        response.setText(translateService.translateData("Please send your location", language) + "\uD83D\uDCCD");
        response.setReplyMarkup(replyKeyboardMarkup);
        return response;
    }
}
