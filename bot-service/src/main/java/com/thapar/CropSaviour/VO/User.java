package com.thapar.CropSaviour.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private Long chatId;
    private Long userId;
    private String language;
    private String Crop;
}
