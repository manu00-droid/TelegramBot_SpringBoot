package com.thapar.CropSaviour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeyboardService {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private TranslateService translateService;

    public SendMessage sendInlineKeyboardForLanguage(Long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("English");
        inlineKeyboardButton1.setCallbackData("englishButton");
        inlineKeyboardButton2.setText("Hindi");
        inlineKeyboardButton2.setCallbackData("hindiButton");
        inlineKeyboardButton3.setText("Punjabi");
        inlineKeyboardButton3.setCallbackData("punjabiButton");
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

    public SendMessage sendInlineKeyboardForCrop(Long chatId) {
        String language = userInfoService.getLanguageByChatId(chatId);
        String wheat = translateService.translateData("Wheat", language);
        String rice = translateService.translateData("Rice", language);
        String weed = translateService.translateData("Weed", language);
        String selectCrop = translateService.translateData("Please Select Crop", language);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText(wheat);
        inlineKeyboardButton1.setCallbackData("wheatButton");
        inlineKeyboardButton2.setText(rice);
        inlineKeyboardButton2.setCallbackData("riceButton");
        inlineKeyboardButton3.setText(weed);
        inlineKeyboardButton3.setCallbackData("weedButton");
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
        response.setText(selectCrop);
        response.setReplyMarkup(inlineKeyboardMarkup);
        return response;
    }
}
