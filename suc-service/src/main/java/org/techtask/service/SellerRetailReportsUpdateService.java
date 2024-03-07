package org.techtask.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.techtask.entity.SellerRetailReports;
import org.techtask.exception.FileReadingException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
@Service
@EnableScheduling
@AllArgsConstructor
public class SellerRetailReportsUpdateService {

    private final SellerRetailReportsService sellerRetailReportsService;

    @Scheduled(fixedRate = 300000)
    public void updateStatisticsFromFile() {
        SellerRetailReports newData = readDataFromFile();
        log.info("start updating data");
        sellerRetailReportsService.updateDatabase(newData);
    }

    private SellerRetailReports readDataFromFile() {
        log.info("Start reading file!");
        SellerRetailReports newData = getSellerRetailReportsFromJsonFile(
                "suc-service/json/test_report.json");
        log.info("File reading ended successfully!");
        return newData;
    }

    private SellerRetailReports getSellerRetailReportsFromJsonFile(String pathname) {
        try {
            return new ObjectMapper().readValue(
                    new File(pathname),
                    getTypeReferenceForSellerRetailReports());
        } catch (IOException exc) {
            log.error("Exception was throwing while reading file!");
            throw new FileReadingException("Sorry it`s our mistake, " +
                    "we are already working on it!");
        }
    }

    private TypeReference<SellerRetailReports> getTypeReferenceForSellerRetailReports() {
        return new TypeReference<>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

}
