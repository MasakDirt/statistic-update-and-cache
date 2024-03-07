package org.techtask.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.techtask.entity.addition.salesandtraffic.byasin.SalesAndTrafficByAsin;
import org.techtask.entity.addition.salesandtraffic.bydate.SalesAndTrafficByDate;
import org.techtask.service.SellerRetailReportsService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportsController {

    private final SellerRetailReportsService sellerRetailReportsService;

    @GetMapping("/byDate")
    public ResponseEntity<List<SalesAndTrafficByDate>> getSalesAndTrafficByDate(
            Authentication authentication, @RequestParam("dates") List<String> dates) {
        var salesAndTrafficByDatesResponse = sellerRetailReportsService
                .readSalesAndTrafficByDate(dates);
        log.info("GET-SALES_AND_TRAFFIC_BY_DATE === user - {}, dates - {}",
                authentication.getName(), dates);

        return ResponseEntity.ok(salesAndTrafficByDatesResponse);
    }

    @GetMapping("/byAsin")
    public ResponseEntity<List<SalesAndTrafficByAsin>> getSalesAndTrafficByAsin(
            Authentication authentication, @RequestParam("asins") List<String> asins) {
        var salesAndTrafficByAsinsResponse = sellerRetailReportsService
                .readSalesAndTrafficByAsin(asins);
        log.info("GET-SALES_AND_TRAFFIC_BY_ASIN === user - {}, asins - {}",
                authentication.getName(), asins);

        return ResponseEntity.ok(salesAndTrafficByAsinsResponse);
    }

    @GetMapping("/total/dates")
    public ResponseEntity<List<SalesAndTrafficByDate>> getTotalDateStatistic(
            Authentication authentication) {
        var salesAndTrafficTotalDates = sellerRetailReportsService
                .getTotalStatisticByDates();
        log.info("GET-TOTAL-SALES_AND_TRAFFIC_BY_DATE === user - {}",
                authentication.getName());

        return ResponseEntity.ok(salesAndTrafficTotalDates);
    }

    @GetMapping("/total/asins")
    public ResponseEntity<List<SalesAndTrafficByAsin>> getTotalAsinStatistic(
            Authentication authentication) {
        var salesAndTrafficTotalAsins = sellerRetailReportsService
                .getTotalStatisticByAsins();
        log.info("GET-TOTAL-SALES_AND_TRAFFIC_BY_ASIN === user - {}",
                authentication.getName());

        return ResponseEntity.ok(salesAndTrafficTotalAsins);
    }

}
