package com.thapar.CropSaviour.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dataset {
    private Long id;
    private Long chatId;
    private String crop_type;
    private String file_path;
    private double lat;
    private double lng;
    private String disease_type;
}
