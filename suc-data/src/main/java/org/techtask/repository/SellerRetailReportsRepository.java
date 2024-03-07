package org.techtask.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.techtask.entity.SellerRetailReports;

import java.util.List;

public interface SellerRetailReportsRepository
        extends MongoRepository<SellerRetailReports, String> {

    @Query(value = "{ 'salesAndTrafficByDate.date' : { $in : ?0 } }",
            fields = "{ 'salesAndTrafficByDate' : 1 }")
    List<SellerRetailReports> findByDate(List<String> dates);

    @Query(value = "{ 'salesAndTrafficByAsin.parentAsin' : { $in : ?0 } }",
            fields = "{ 'salesAndTrafficByAsin' : 1 }")
    List<SellerRetailReports> findByAsin(List<String> asins);

    @Query(value = "{}", fields = "{ 'salesAndTrafficByDate' : 1 }")
    List<SellerRetailReports> findTotalStatisticByDates();

    @Query(value = "{}", fields = "{ 'salesAndTrafficByAsin' : 1 }")
    List<SellerRetailReports> findTotalStatisticByAsins();

}
