package org.techtask.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.techtask.entity.SellerRetailReports;
import org.techtask.entity.addition.salesandtraffic.byasin.SalesAndTrafficByAsin;
import org.techtask.entity.addition.salesandtraffic.bydate.SalesAndTrafficByDate;
import org.techtask.repository.SellerRetailReportsRepository;
import org.techtask.service.SellerRetailReportsService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class SellerRetailReportsServiceImpl implements SellerRetailReportsService {

    private final SellerRetailReportsRepository sellerRetailReportsRepository;

    @Override
    @Cacheable("salesAndTrafficByDate")
    public List<SalesAndTrafficByDate> readSalesAndTrafficByDate(List<String> dates) {
        List<SellerRetailReports> reports = sellerRetailReportsRepository.
                findByDate(dates);
        List<SalesAndTrafficByDate> result = new ArrayList<>();

        for (SellerRetailReports report : reports) {
            List<SalesAndTrafficByDate> salesAndTrafficByDates =
                    report.getSalesAndTrafficByDate()
                            .stream()
                            .filter(salesAndTrafficByDate ->
                                    dates.contains(salesAndTrafficByDate.getDate()))
                            .toList();
            result.addAll(salesAndTrafficByDates);
        }

        return result;
    }

    @Override
    @Cacheable("salesAndTrafficByAsins")
    public List<SalesAndTrafficByAsin> readSalesAndTrafficByAsin(List<String> asins) {
        List<SellerRetailReports> reports = sellerRetailReportsRepository
                .findByAsin(asins);
        List<SalesAndTrafficByAsin> result = new ArrayList<>();

        for (SellerRetailReports report : reports) {
            List<SalesAndTrafficByAsin> salesAndTrafficByAsins =
                    report.getSalesAndTrafficByAsin()
                            .stream()
                            .filter(salesAndTrafficByDate ->
                                    asins.contains(salesAndTrafficByDate.getParentAsin()))
                            .toList();
            result.addAll(salesAndTrafficByAsins);
        }

        return result;
    }

    @Override
    @Cacheable("totalDatesStatistic")
    public List<SalesAndTrafficByDate> getTotalStatisticByDates() {
        List<SellerRetailReports> reports = sellerRetailReportsRepository
                .findTotalStatisticByDates();
        List<SalesAndTrafficByDate> result = new ArrayList<>();
        for (SellerRetailReports report : reports) {
            result.addAll(report.getSalesAndTrafficByDate());
        }

        return result;
    }

    @Override
    @Cacheable("totalAsinsStatistic")
    public List<SalesAndTrafficByAsin> getTotalStatisticByAsins() {
        List<SellerRetailReports> reports = sellerRetailReportsRepository
                .findTotalStatisticByAsins();
        List<SalesAndTrafficByAsin> result = new ArrayList<>();
        for (SellerRetailReports report : reports) {
            result.addAll(report.getSalesAndTrafficByAsin());
        }

        return result;
    }

    @Override
    public void updateDatabase(SellerRetailReports newData) {
        if (newData == null) {
            log.error("Data is null in 'updateDatabase' method!");
            throw new IllegalArgumentException("Sorry our mistake," +
                    "we are already working on it!");
        }

        sellerRetailReportsRepository.save(newData);
        log.info("data updated successfully!");
    }
}
