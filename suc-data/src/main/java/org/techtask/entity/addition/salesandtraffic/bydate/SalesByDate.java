package org.techtask.entity.addition.salesandtraffic.bydate;

import lombok.*;
import org.techtask.entity.addition.salesandtraffic.bydate.other.ClaimsAmount;
import org.techtask.entity.addition.salesandtraffic.bydate.other.ShippedProductSales;
import org.techtask.entity.addition.salesandtraffic.bydate.average.sales.AverageSalesPerOrderItem;
import org.techtask.entity.addition.salesandtraffic.bydate.average.sales.AverageSalesPerOrderItemB2B;
import org.techtask.entity.addition.salesandtraffic.bydate.average.selling.AverageSellingPrice;
import org.techtask.entity.addition.salesandtraffic.bydate.average.selling.AverageSellingPriceB2B;
import org.techtask.entity.addition.salesandtraffic.orderedprod.OrderedProductSales;
import org.techtask.entity.addition.salesandtraffic.orderedprod.OrderedProductSalesB2B;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalesByDate {

    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private AverageSalesPerOrderItem averageSalesPerOrderItem;
    private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private AverageSellingPrice averageSellingPrice;
    private AverageSellingPriceB2B averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private ClaimsAmount claimsAmount;
    private ShippedProductSales shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesByDate that = (SalesByDate) o;
        return unitsOrdered == that.unitsOrdered
                && unitsOrderedB2B == that.unitsOrderedB2B
                && totalOrderItems == that.totalOrderItems
                && totalOrderItemsB2B == that.totalOrderItemsB2B
                && Double.compare(averageUnitsPerOrderItem, that.averageUnitsPerOrderItem) == 0
                && Double.compare(averageUnitsPerOrderItemB2B,
                that.averageUnitsPerOrderItemB2B) == 0
                && unitsRefunded == that.unitsRefunded
                && Double.compare(refundRate, that.refundRate) == 0
                && claimsGranted == that.claimsGranted
                && unitsShipped == that.unitsShipped
                && ordersShipped == that.ordersShipped
                && Objects.equals(orderedProductSales, that.orderedProductSales)
                && Objects.equals(orderedProductSalesB2B, that.orderedProductSalesB2B)
                && Objects.equals(averageSalesPerOrderItem, that.averageSalesPerOrderItem)
                && Objects.equals(averageSalesPerOrderItemB2B, that.averageSalesPerOrderItemB2B)
                && Objects.equals(averageSellingPrice, that.averageSellingPrice)
                && Objects.equals(averageSellingPriceB2B, that.averageSellingPriceB2B)
                && Objects.equals(claimsAmount, that.claimsAmount)
                && Objects.equals(shippedProductSales, that.shippedProductSales);
    }

    @Override
    public int hashCode() {
        return 9 * Objects.hash(orderedProductSales, orderedProductSalesB2B, unitsOrdered,
                unitsOrderedB2B, totalOrderItems, totalOrderItemsB2B,
                averageSalesPerOrderItem, averageSalesPerOrderItemB2B,
                averageUnitsPerOrderItem, averageUnitsPerOrderItemB2B, averageSellingPrice,
                averageSellingPriceB2B, unitsRefunded, refundRate, claimsGranted, claimsAmount,
                shippedProductSales, unitsShipped, ordersShipped);
    }

}
