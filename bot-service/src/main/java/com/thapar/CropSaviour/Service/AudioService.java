package com.thapar.CropSaviour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

@Service
public class AudioService {

    @Autowired
    private UserInfoService userInfoService;
    private final String AUDIO_FILES_PATH = "/home/manav/Documents/Work/TelegramBot_SpringBoot/bot-service/src/main/java/com/thapar/CropSaviour/AudioFiles/";

    public SendAudio sendAudio(Long chatId, String disease) {
        if (disease.equalsIgnoreCase("seedlings")) {
            return null;
        }

        String language = userInfoService.getLanguageByChatId(chatId).toLowerCase();
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(chatId);
        InputFile inputFile = new InputFile();

        if (disease.equalsIgnoreCase("leaf rust") || disease.equalsIgnoreCase("yellow rust") || disease.equalsIgnoreCase("stem rust")) {
            String fname = AUDIO_FILES_PATH + "Rust" + "_" + language;
            java.io.File f = new File(fname);
            inputFile.setMedia(f);
            sendAudio.setAudio(inputFile);
            return sendAudio;
        }

        if (disease.equalsIgnoreCase("Blast") || disease.equalsIgnoreCase("Leaf Blast")) {
            String fname = AUDIO_FILES_PATH + "Leaf Blast" + "_" + language;
            java.io.File f = new File(fname);
            inputFile.setMedia(f);
            sendAudio.setAudio(inputFile);
            return sendAudio;
        }

        boolean check = ifPresent(language, disease);
        if (check) {
            String fname = AUDIO_FILES_PATH + disease + "_" + language;
            java.io.File f = new File(fname);
            inputFile.setMedia(f);
            sendAudio.setAudio(inputFile);
            return sendAudio;
        } else {
            return null;
        }
    }

    private boolean ifPresent(String language, String disease) {

        if (disease.equalsIgnoreCase("healthy")) {
            return true;
        }
        File directory = new File(AUDIO_FILES_PATH);
        String[] flist = directory.list();
        if (flist == null) {
            System.out.println("Empty directory.");
            return false;
        } else {
            for (String filename : flist) {
                if (filename.equalsIgnoreCase(disease + "_" + language)) {
                    System.out.println(filename + " found");
                    return true;
                }
            }
        }
        return false;
    }
}

