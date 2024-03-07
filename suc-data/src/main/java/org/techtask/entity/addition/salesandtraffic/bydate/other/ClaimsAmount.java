package org.techtask.entity.addition.salesandtraffic.bydate.other;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaimsAmount {

    private double amount;
    private String currencyCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimsAmount that = (ClaimsAmount) o;
        return Double.compare(amount, that.amount) == 0
                && Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return 43 * Objects.hash(amount, currencyCode);
    }

}
