package com.thapar.CropSaviour.Service;

import com.thapar.CropSaviour.VO.Dataset;
import com.thapar.CropSaviour.VO.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Base64;
import java.util.Optional;

@Service
public class DatasetInfoService {
    private static final String BASE_URI = "http://127.0.0.1:8081/dataset/";

    private static final String SET_LAT_LNG_BY_FILE_PATH = "setlatlng/";
    private static final String IS_FILE_PRESENT = "isfilepresent/{encoded_file_path}";
    private final WebClient webClient = WebClient.create(BASE_URI);


    public Dataset saveFile(Long chatId, String crop_type, String disease_type, String file_path, double lat, double lng) {
        MultiValueMap<String, String> bodyValues2 = new LinkedMultiValueMap<>();
        bodyValues2.add("chatId", chatId.toString());
        bodyValues2.add("crop_type", crop_type);
        bodyValues2.add("file_path", file_path);
        bodyValues2.add("lat", String.valueOf(lat));
        bodyValues2.add("lng", String.valueOf(lng));
        bodyValues2.add("disease_type", disease_type);
        Dataset dataset = webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues2))
                .retrieve()
                .bodyToMono(Dataset.class).block();
        return dataset;
    }

    public void setLatLngByFilePath(String file_path, double lat, double lng) {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("file_path", file_path);
        bodyValues.add("lat", String.valueOf(lat));
        bodyValues.add("lng", String.valueOf(lng));
        webClient.put()
                .uri(SET_LAT_LNG_BY_FILE_PATH)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(User.class).block();
    }

    public boolean isFilePresent(String file_path) {
        String encodedString = Base64.getEncoder().encodeToString(file_path.getBytes());
        boolean isPresent = webClient.get()
                .uri(IS_FILE_PRESENT, encodedString)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToMono(boolean.class)
                .block();
        return isPresent;
    }
}
