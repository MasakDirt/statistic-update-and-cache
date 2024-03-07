package org.techtask.entity.addition.salesandtraffic.orderedprod;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedProductSalesB2B {

    private double amount;
    private String currencyCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProductSalesB2B that = (OrderedProductSalesB2B) o;
        return Double.compare(amount, that.amount) == 0
                && Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return 11 * Objects.hash(amount, currencyCode);
    }

}
