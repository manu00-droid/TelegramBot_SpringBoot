package com.thapar.CropSaviour.Service;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MandiService {
    private final String BASE_URI = "http://127.0.0.1:8083/mandiRate/";
    private WebClient webClient = WebClient.create(BASE_URI);


    public String sendMandiRate(String commodity, String state, Long chatId) {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("state", state);
        bodyValues.add("commodity", commodity);
        bodyValues.add("chat_id", String.valueOf(chatId));

        String rateList = webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return rateList;

    }

}
