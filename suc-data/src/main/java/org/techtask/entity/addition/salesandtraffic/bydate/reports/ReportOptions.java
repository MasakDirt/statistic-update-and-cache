package org.techtask.entity.addition.salesandtraffic.bydate.reports;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportOptions {

    private String dateGranularity;
    private String asinGranularity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportOptions that = (ReportOptions) o;
        return Objects.equals(dateGranularity, that.dateGranularity)
                && Objects.equals(asinGranularity, that.asinGranularity);
    }

    @Override
    public int hashCode() {
        return 13 * Objects.hash(dateGranularity, asinGranularity);
    }
}
