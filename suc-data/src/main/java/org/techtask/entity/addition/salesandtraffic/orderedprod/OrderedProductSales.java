package org.techtask.entity.addition.salesandtraffic.orderedprod;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProductSales {

    private double amount;
    private String currencyCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProductSales that = (OrderedProductSales) o;
        return Double.compare(amount, that.amount) == 0
                && Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return 33 * Objects.hash(amount, currencyCode);
    }

}
