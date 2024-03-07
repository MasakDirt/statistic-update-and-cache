package org.techtask.entity.addition.salesandtraffic.byasin;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndTrafficByAsin {

    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesAndTrafficByAsin that = (SalesAndTrafficByAsin) o;
        return Objects.equals(parentAsin, that.parentAsin)
                && Objects.equals(salesByAsin, that.salesByAsin)
                && Objects.equals(trafficByAsin, that.trafficByAsin);
    }

    @Override
    public int hashCode() {
        return 56 * Objects.hash(parentAsin, salesByAsin, trafficByAsin);
    }

}
