package com.thapar.CropSaviour.bot;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class CropSaviourBot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			Message message = update.getMessage();
			SendMessage response = new SendMessage();
			Long chatId = message.getChatId();
			response.setChatId(String.valueOf(chatId));
			if (update.getMessage().getText().equals("/start")) {
				response = sendInlineKeyboardForLanguage(chatId);
				try {
					execute(response);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if (message.hasText()) {
				String text = message.getText();
				response.setText(text);
			} else if (message.hasPhoto()) {
				final List<PhotoSize> photos = update.getMessage().getPhoto();
				final PhotoSize photoSize = photos.stream().max(Comparator.comparing(PhotoSize::getFileSize))
						.orElse(null);
				if (photoSize != null) {
					response.setText("Yeah, I got it!");
					String filePath = getFilePath(photoSize);
					try {
						String fileUrl = getFileUrl(filePath);
						downloadFile(fileUrl, "abc.jpeg");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					response.setText("Houston, we have a problem!");
				}
			} else if (update.hasCallbackQuery()) {
				String call_data = update.getCallbackQuery().getData();
				long message_id = update.getCallbackQuery().getMessage().getMessageId();
				long chat_id = update.getCallbackQuery().getMessage().getChatId();

				if (call_data.equals("englishButton")) {
					String answer = "English Selected";
					EditMessageText new_message = new EditMessageText();
					new_message.setChatId(chat_id);
					new_message.setMessageId((int) message_id);
					new_message.setText(answer);
					try {
						execute(new_message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private SendMessage sendInlineKeyboardForLanguage(Long chatId) {
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

	private String getFilePath(final PhotoSize photo) {
		final var filePath = photo.getFilePath();
		if (filePath != null && !filePath.isBlank()) {
			return filePath;
		}
		final GetFile getFileMethod = new GetFile();
		getFileMethod.setFileId(photo.getFileId());
		try {
			final org.telegram.telegrambots.meta.api.objects.File file = execute(getFileMethod);
			return file.getFilePath();
		} catch (final TelegramApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getFileUrl(final String filePath) throws MalformedURLException {
		return File.getFileUrl(getBotToken(), filePath);
	}

	private void downloadFile(String fileUrl, String fileName) throws Exception {
		URL url = new URL(fileUrl);
		try (InputStream in = url.openStream()) {
			Files.copy(in, Paths.get(fileName));
		}
	}

	public void givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {
		Process p = Runtime.getRuntime().exec("python yourapp.py");

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
