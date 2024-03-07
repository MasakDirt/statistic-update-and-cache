package org.techtask.entity.addition.salesandtraffic.bydate;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrafficByDate {

    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private double orderItemSessionPercentage;
    private double orderItemSessionPercentageB2B;
    private double unitSessionPercentage;
    private double unitSessionPercentageB2B;
    private int averageOfferCount;
    private int averageParentItems;
    private int feedbackReceived;
    private int negativeFeedbackReceived;
    private double receivedNegativeFeedbackRate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficByDate that = (TrafficByDate) o;
        return browserPageViews == that.browserPageViews
                && browserPageViewsB2B == that.browserPageViewsB2B
                && mobileAppPageViews == that.mobileAppPageViews
                && mobileAppPageViewsB2B == that.mobileAppPageViewsB2B
                && pageViews == that.pageViews
                && pageViewsB2B == that.pageViewsB2B
                && browserSessions == that.browserSessions
                && browserSessionsB2B == that.browserSessionsB2B
                && mobileAppSessions == that.mobileAppSessions
                && mobileAppSessionsB2B == that.mobileAppSessionsB2B
                && sessions == that.sessions
                && sessionsB2B == that.sessionsB2B
                && Double.compare(buyBoxPercentage, that.buyBoxPercentage) == 0
                && Double.compare(buyBoxPercentageB2B, that.buyBoxPercentageB2B) == 0
                && Double.compare(orderItemSessionPercentage,
                that.orderItemSessionPercentage) == 0
                && Double.compare(orderItemSessionPercentageB2B,
                that.orderItemSessionPercentageB2B) == 0
                && Double.compare(unitSessionPercentage,
                that.unitSessionPercentage) == 0
                && Double.compare(unitSessionPercentageB2B,
                that.unitSessionPercentageB2B) == 0
                && averageOfferCount == that.averageOfferCount
                && averageParentItems == that.averageParentItems
                && feedbackReceived == that.feedbackReceived
                && negativeFeedbackReceived == that.negativeFeedbackReceived
                && Double.compare(receivedNegativeFeedbackRate,
                that.receivedNegativeFeedbackRate) == 0;
    }

    @Override
    public int hashCode() {
        return 23 * Objects.hash(browserPageViews, browserPageViewsB2B, mobileAppPageViews,
                mobileAppPageViewsB2B, pageViews, pageViewsB2B, browserSessions,
                browserSessionsB2B, mobileAppSessions, mobileAppSessionsB2B, sessions,
                sessionsB2B, buyBoxPercentage, buyBoxPercentageB2B, orderItemSessionPercentage,
                orderItemSessionPercentageB2B, unitSessionPercentage, unitSessionPercentageB2B,
                averageOfferCount, averageParentItems, feedbackReceived,
                negativeFeedbackReceived, receivedNegativeFeedbackRate);
    }

}
