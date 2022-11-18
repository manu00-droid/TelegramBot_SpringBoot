package com.thapar.dataBase.service;

import com.thapar.dataBase.entity.Dataset;
import com.thapar.dataBase.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DatasetService {
    @Autowired
    private DatasetRepository datasetRepository;

    public Dataset saveFileDataset(Dataset dataset) {
        return datasetRepository.save(dataset);
    }

    public List<Dataset> getAllDataset() {
        return datasetRepository.findAll();
    }

    public List<Dataset> getDatasetByCrop_type(String crop_type) {
        return datasetRepository.findByCrop_type(crop_type);
    }

    public List<Dataset> getDatasetByDisease_type(String disease_type) {
        return datasetRepository.findByDisease_type(disease_type);
    }

    public List<String> getFile_pathByDisease_type(String disease_type) {
        return datasetRepository.findFile_pathsByDisease_type(disease_type);
    }

    public List<String> getFile_pathByCrop_type(String crop_type) {
        return datasetRepository.findFile_pathsByCrop_type(crop_type);
    }

    public ArrayList<ArrayList<Double>> getLatLngByDisease_type(String disease_type) {
        return datasetRepository.findLatLngByDisease_type(disease_type);
    }

    public ArrayList<ArrayList<Double>> getLatLngByCrop_type(String crop_type) {
        return datasetRepository.findLatLngByCrop_type(crop_type);
    }

    public ArrayList<ArrayList<Double>> getLatLngByCrop_typeAndDisease_type(String crop_type, String disease_type) {
        return datasetRepository.findLatLngByCrop_typeAndAndDisease_type(crop_type, disease_type);
    }

    public Dataset updateFileData(String file_path, Dataset dataset) {
        Dataset datasetdb = datasetRepository.findByFile_path(file_path);
        if (Objects.nonNull(dataset.getLat())) {
            datasetdb.setLat(dataset.getLat());
        }
        if (Objects.nonNull(dataset.getLng())) {
            datasetdb.setLng(dataset.getLng());
        }
        if (Objects.nonNull(dataset.getDisease_type()) && !"".equalsIgnoreCase(dataset.getDisease_type())) {
            datasetdb.setDisease_type(dataset.getDisease_type());
        }
        if (Objects.nonNull(dataset.getCrop_type()) && !"".equalsIgnoreCase(dataset.getCrop_type())) {
            datasetdb.setCrop_type(dataset.getCrop_type());
        }
        return datasetRepository.save(datasetdb);
    }

    public void setLatLng(double lat, double lng, String file_path) {
        datasetRepository.saveLatLngByFile_path(lat, lng, file_path);
    }

    public boolean isFilePresent(String decodedString) {
        if (datasetRepository.isFilePresent(decodedString) == 1) {
            return true;
        }
        return false;
    }
}

