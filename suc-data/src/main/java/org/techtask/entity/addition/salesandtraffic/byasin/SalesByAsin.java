package org.techtask.entity.addition.salesandtraffic.byasin;

import lombok.*;
import org.techtask.entity.addition.salesandtraffic.orderedprod.OrderedProductSales;
import org.techtask.entity.addition.salesandtraffic.orderedprod.OrderedProductSalesB2B;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesByAsin {

    private int unitsOrdered;
    private int unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesByAsin that = (SalesByAsin) o;
        return unitsOrdered == that.unitsOrdered
                && unitsOrderedB2B == that.unitsOrderedB2B
                && totalOrderItems == that.totalOrderItems
                && totalOrderItemsB2B == that.totalOrderItemsB2B
                && Objects.equals(orderedProductSales, that.orderedProductSales)
                && Objects.equals(orderedProductSalesB2B, that.orderedProductSalesB2B);
    }

    @Override
    public int hashCode() {
        return 41 * Objects.hash(unitsOrdered, unitsOrderedB2B, orderedProductSales,
                orderedProductSalesB2B, totalOrderItems, totalOrderItemsB2B);
    }

}
