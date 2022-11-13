package com.Telegram.bot.database.service.repository;

import com.Telegram.bot.database.service.entity.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface DatasetRepository extends JpaRepository<Dataset, Long> {
    @Query(value = "select * from dataset where crop_type=?1", nativeQuery = true)
    List<Dataset> findByCrop_type(String crop_type);

    @Query(value = "select * from dataset where file_path=?1", nativeQuery = true)
    Dataset findByFile_path(String file_path);

    @Query(value = "select * from dataset where disease_type=?1", nativeQuery = true)
    List<Dataset> findByDisease_type(String disease_type);

    @Query(value = "select file_path from dataset where crop_type=?1", nativeQuery = true)
    List<String> findFile_pathsByCrop_type(String crop_type);

    @Query(value = "select file_path from dataset where disease_type=?1", nativeQuery = true)
    List<String> findFile_pathsByDisease_type(String disease_type);

    @Query(value = "select lat,lng from dataset where disease_type=?1", nativeQuery = true)
    ArrayList<ArrayList<Double>> findLatLngByDisease_type(String disease_type);

    @Query(value = "select lat,lng from dataset where crop_type=?1", nativeQuery = true)
    ArrayList<ArrayList<Double>> findLatLngByCrop_type(String crop_type);

    @Query(value = "select lat,lng from dataset where crop_type=?1 and disease_type=?2", nativeQuery = true)
    ArrayList<ArrayList<Double>> findLatLngByCrop_typeAndAndDisease_type(String crop_type, String disease_type);

    @Modifying
    @Query(value = "update dataset set lat=?1, lng=?2 where file_path=?3", nativeQuery = true)
    void saveLatLngByFile_path(double lat, double lng, String file_path);

    @Query(value = "select exists(select * from dataset where file_path=?1)", nativeQuery = true)
    int isFilePresent(String decodedString);

//    @Query(value = "select * from dataset where disease_type=?1", nativeQuery = true)
//    Dataset findByDisease_type(String disease_type);
}
