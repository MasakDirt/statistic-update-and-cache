package org.techtask.service;

import org.springframework.stereotype.Service;
import org.techtask.entity.SellerRetailReports;
import org.techtask.entity.addition.salesandtraffic.byasin.SalesAndTrafficByAsin;
import org.techtask.entity.addition.salesandtraffic.bydate.SalesAndTrafficByDate;

import java.util.List;

@Service
public interface SellerRetailReportsService {

    List<SalesAndTrafficByDate> readSalesAndTrafficByDate(List<String> dates);

    List<SalesAndTrafficByAsin> readSalesAndTrafficByAsin(List<String> asins);

    List<SalesAndTrafficByDate> getTotalStatisticByDates();

    List<SalesAndTrafficByAsin> getTotalStatisticByAsins();

    void updateDatabase(SellerRetailReports newData);

}
