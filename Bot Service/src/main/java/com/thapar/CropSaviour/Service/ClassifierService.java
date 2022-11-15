package com.thapar.CropSaviour.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClassifierService {
    //base endpoint where we have to send requests
    private final String BASE_URI = "http://127.0.0.1:8083/prediction/";
    //creating webclient object
    private WebClient webClient = WebClient.create(BASE_URI);

    public String classifyDisease(String filePath, String cropType) {
        //Creating a map for sending form data to the classifier service
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("file_path", filePath);
        bodyValues.add("crop", cropType);

        //Sending a post request
        String disease = webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        //webclient adds extra double colon in the string
        //so removing the extra double colon
        disease = disease.substring(1, disease.length() - 1);
        return disease;
    }

}
