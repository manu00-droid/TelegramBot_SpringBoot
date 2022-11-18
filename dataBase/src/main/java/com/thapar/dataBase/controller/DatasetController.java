package com.thapar.dataBase.controller;

import com.thapar.dataBase.entity.Dataset;
import com.thapar.dataBase.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/dataset")
public class DatasetController {
    @Autowired
    private DatasetService datasetService;

    @RequestMapping(value = "/")
    public Dataset saveFileData(Dataset dataset) {
        System.out.println(dataset);
        return datasetService.saveFileDataset(dataset);
    }

    @GetMapping("/isFilePresent/{encoded_file_path}")
    public boolean isFilePresent(@PathVariable("encoded_file_path") String encoded_file_path) {
        byte[] decodedBytes = Base64.getDecoder().decode(encoded_file_path);
        String decodedString = new String(decodedBytes);
        return datasetService.isFilePresent(decodedString);
    }

    @PutMapping(value = "/setLatLng/")
    public void setLatLngByFilePath(String file_path, double lat, double lng) {
        System.out.println(file_path + " " + lat + " " + lng);
        datasetService.setLatLng(lat, lng, file_path);
    }

    @PutMapping(value = "/update/")
    public void updateDataset(@RequestBody String file_path, @RequestBody String disease_type, @RequestBody double lat, @RequestBody double lng) {
        Dataset dataset = new Dataset();
        dataset.setLat(lat);
        dataset.setLng(lng);
        dataset.setFile_path(file_path);
        dataset.setDisease_type(disease_type);
        datasetService.updateFileData(file_path, dataset);
    }

    @GetMapping(value = "/")
    public List<Dataset> getAllData() {
        return datasetService.getAllDataset();
    }

    @GetMapping("/getDatasetByDiseaseType")
    public List<Dataset> getDatasetByDisease_type(@RequestParam(name = "disease_type") String disease_type) {
        return datasetService.getDatasetByDisease_type(disease_type);
    }

    @GetMapping("getDatasetByCropType")
    public List<Dataset> getDatasetByCrop_type(@RequestParam(name = "crop_type") String crop_type) {
        return datasetService.getDatasetByCrop_type(crop_type);
    }

    @GetMapping("/getFilePathsByCropType")
    public List<String> getFile_pathsByCrop_type(@RequestParam(name = "crop_type") String crop_type) {
        System.out.println(crop_type);
        return datasetService.getFile_pathByCrop_type(crop_type);
    }

    @GetMapping("/getFilePathsByDiseaseType")
    public List<String> getFile_pathsByDisease_type(@RequestParam(name = "disease_type") String disease_type) {
        System.out.println(disease_type);
        return datasetService.getFile_pathByDisease_type(disease_type);
    }

    @GetMapping("/getLatLngByDiseaseType")
    public ArrayList<ArrayList<Double>> getLatLngByDisease_type(@RequestParam(name = "disease_type") String disease_type) {
        return datasetService.getLatLngByDisease_type(disease_type);
    }

    @GetMapping("/getLatLngByCropType")
    public ArrayList<ArrayList<Double>> getLatLngByCrop_type(@RequestParam(name = "crop_type") String crop_type) {
        return datasetService.getLatLngByCrop_type(crop_type);
    }

    @GetMapping("getLatLngByCropTypeAndDiseaseType")
    public ArrayList<ArrayList<Double>> getLatLngByCropTypeAndDiseaseType(@RequestParam(name = "crop_type") String crop_type, @RequestParam(name = "disease_type") String disease_type) {
        return datasetService.getLatLngByCrop_typeAndDisease_type(crop_type, disease_type);
    }

}
