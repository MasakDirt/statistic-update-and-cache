package org.techtask.entity.addition;

import lombok.*;
import org.techtask.entity.addition.salesandtraffic.bydate.reports.ReportOptions;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportSpecification {

    private String reportType;
    private ReportOptions reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private List<String> marketplaceIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportSpecification that = (ReportSpecification) o;
        return Objects.equals(reportType, that.reportType)
                && Objects.equals(reportOptions, that.reportOptions)
                && Objects.equals(dataStartTime, that.dataStartTime)
                && Objects.equals(dataEndTime, that.dataEndTime)
                && Objects.equals(marketplaceIds, that.marketplaceIds);
    }

    @Override
    public int hashCode() {
        return 11 * Objects.hash(reportType, reportOptions,
                dataStartTime, dataEndTime, marketplaceIds);
    }
}
