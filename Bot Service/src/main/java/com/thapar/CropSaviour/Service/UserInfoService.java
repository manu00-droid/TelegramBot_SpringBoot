package com.thapar.CropSaviour.Service;

import com.thapar.CropSaviour.VO.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Service
public class UserInfoService {
    private final String BASE_URI = "http://127.0.0.1:8081/users/";
    private final String GET_LANGUAGE = "getlanguage/{chatId}";
    private final String GET_CROP = "getcrop/{chatId}";
    private final String SET_CROP_NULL = "setcropnull/{chatId}";
    private WebClient webClient = WebClient.create(BASE_URI);


    //			MultiValueMap<String, Long> bodyValues = new LinkedMultiValueMap<>();
//			bodyValues.add("chatId", update.getMessage().getChatId());
//			String uri = "http://127.0.0.1:8081/users/" + update.getMessage().getChatId().toString();
//			Optional<User> userIsPresent = webClient.get()
//					.uri(uri)
//					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//					.retrieve()
//					.bodyToMono(Optional.class)
//					.block();
//
//			if (userIsPresent.isPresent()) {
//				System.out.println(userIsPresent.get());
//				isPresentUser = true;
//			}
//
    //			if (!isPresentUser) {
//				MultiValueMap<String, String> bodyValues2 = new LinkedMultiValueMap<>();
//				bodyValues2.add("firstName", message.getChat().getFirstName());
//				bodyValues2.add("lastName", message.getChat().getLastName());
//				bodyValues2.add("chatId", message.getChatId().toString());
//				bodyValues2.add("userName", message.getChat().getUserName());
//				bodyValues2.add("userId", message.getChat().getId().toString());
//				User user = webClient.post()
//						.uri("http://127.0.0.1:8081/users/")
//						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//						.body(BodyInserters.fromFormData(bodyValues2))
//						.retrieve()
//						.bodyToMono(User.class).block();
//			}
//
//			if (isPresentUser) {
//				Optional<String> language = webClient.get()
//						.uri("http://127.0.0.1:8081/users/getlanguage/{chatId}", message.getChatId())
//						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//						.retrieve()
//						.bodyToMono(Optional.class)
//						.block();
//
//				if (language.isPresent()) {
//					isPresentLanguage = true;
//					Optional<String> crop = webClient.get()
//							.uri("http://127.0.0.1:8081/users/getcrop/{chatId}", message.getChatId())
//							.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//							.retrieve()
//							.bodyToMono(Optional.class)
//							.block();
//
//					if (crop.isPresent()) {
//						isPresentCrop = true;
//					}
//				}
//			}
//
//			System.out.println(isPresentUser + " " + isPresentLanguage + " " + isPresentCrop);

    public User saveUser(Message message) {
        MultiValueMap<String, String> bodyValues2 = new LinkedMultiValueMap<>();
        bodyValues2.add("firstName", message.getChat().getFirstName());
        bodyValues2.add("lastName", message.getChat().getLastName());
        bodyValues2.add("userName", message.getChat().getUserName());
        bodyValues2.add("chatId", message.getChatId().toString());
        bodyValues2.add("userId", message.getChat().getId().toString());
        User user = webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues2))
                .retrieve()
                .bodyToMono(User.class).block();
        return user;
    }

    public boolean isPresentUser(Long chatId) {
        Optional<User> user = webClient.get()
                .uri(chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Optional.class)
                .block();

        if (user.isPresent()) {
            System.out.println(user.get());
            return true;
        }
        return false;
    }

    public boolean isPresentLanguage(Long chatId) {
        String language = webClient.get()
                .uri(GET_LANGUAGE, chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (!language.equals("null")) {
            System.out.println("Language present:- ");
            System.out.println(language);
            return true;
        }
        return false;
    }

    public User getUserByChatId(Long chatId) {
        Optional<User> user = webClient.get()
                .uri(chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Optional.class)
                .block();

        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


    public String getLanguageByChatId(Long chatId) {
        Optional<String> language = webClient.get()
                .uri(GET_LANGUAGE, chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Optional.class)
                .block();
        if (language.isPresent())
            return language.get();
        else {
            System.out.println("LANGUAGE NOT PRESENT");
            return null;
        }
    }

    public String getCropByChatId(Long chatId) {
        Optional<String> cropType = webClient.get()
                .uri(GET_CROP, chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Optional.class)
                .block();
        if (cropType.isPresent())
            return cropType.get();
        else {
            System.out.println("CROP NOT PRESENT");
            return null;
        }
    }

    public void setLanguageByChatId(String language, Long chatId) {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("language", language);
        User user;
        user = webClient.put()
                .uri(chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(User.class).block();
    }

    public void setCropByChatId(String cropType, Long chatId) {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("Crop", cropType);

        User user;
        user = webClient.put()
                .uri(chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(User.class).block();

    }

    public void setCropNull(Long chatId) {
        webClient.put()
                .uri(SET_CROP_NULL, chatId.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(User.class).block();
    }
}
