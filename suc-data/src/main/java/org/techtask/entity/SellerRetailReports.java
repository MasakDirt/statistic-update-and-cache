package org.techtask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.techtask.entity.addition.ReportSpecification;
import org.techtask.entity.addition.salesandtraffic.byasin.SalesAndTrafficByAsin;
import org.techtask.entity.addition.salesandtraffic.bydate.SalesAndTrafficByDate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Document(collection = "sellerRetailReports")
public class SellerRetailReports {

    @JsonProperty("_id")
    private String id;
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;

    public SellerRetailReports() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerRetailReports that = (SellerRetailReports) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reportSpecification, that.reportSpecification)
                && Objects.equals(salesAndTrafficByDate, that.salesAndTrafficByDate)
                && Objects.equals(salesAndTrafficByAsin, that.salesAndTrafficByAsin);
    }

    @Override
    public int hashCode() {
        return 45 * Objects.hash(id, reportSpecification,
                salesAndTrafficByDate, salesAndTrafficByAsin);
    }

}
