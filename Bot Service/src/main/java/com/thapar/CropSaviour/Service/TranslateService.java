package com.thapar.CropSaviour.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class TranslateService {
    private final String BASE_URI = "http://127.0.0.1:8083/translate/";
    private WebClient webClient = WebClient.create(BASE_URI);

    public String translateData(String text, String language) {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("text", text);
        bodyValues.add("language", language);

        String translatedData = webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        translatedData = translatedData.substring(1, translatedData.length() - 1);
        return translatedData;
    }

//    public static String translateData(String langFrom, String langTo, String text) throws IOException {
//
//        // INSERT YOU URL HERE
//        String urlStr = "https://script.google.com/macros/s/AKfycbxPBHB3WbnYOkdyuV4kxvSTG536a5kAvslVIkgR4Pn7_zsYiGDrJsMcS7bTm54eHFVLtQ/exec" +
//                "?q=" + URLEncoder.encode(text, "UTF-8") +
//                "&target=" + langTo +
//                "&source=" + langFrom;
//        URL url = new URL(urlStr);
//        StringBuilder response = new StringBuilder();
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestProperty("User-Agent", "Mozilla/5.0");
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        System.out.println(response.toString());
//        return response.toString();
//    }

}
