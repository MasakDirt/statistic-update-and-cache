package org.techtask.entity.addition.salesandtraffic.bydate;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndTrafficByDate {

    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesAndTrafficByDate that = (SalesAndTrafficByDate) o;
        return Objects.equals(date, that.date)
                && Objects.equals(salesByDate, that.salesByDate)
                && Objects.equals(trafficByDate, that.trafficByDate);
    }

    @Override
    public int hashCode() {
        return 12 * Objects.hash(date, salesByDate, trafficByDate);
    }
}
