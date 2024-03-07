package org.techtask.entity.addition.salesandtraffic.byasin;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrafficByAsin {

    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private double browserSessionPercentage;
    private double browserSessionPercentageB2B;
    private double mobileAppSessionPercentage;
    private double mobileAppSessionPercentageB2B;
    private double sessionPercentage;
    private double sessionPercentageB2B;
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private double browserPageViewsPercentage;
    private double browserPageViewsPercentageB2B;
    private double mobileAppPageViewsPercentage;
    private double mobileAppPageViewsPercentageB2B;
    private double pageViewsPercentage;
    private double pageViewsPercentageB2B;
    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private double unitSessionPercentage;
    private double unitSessionPercentageB2B;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficByAsin that = (TrafficByAsin) o;
        return browserSessions == that.browserSessions
                && browserSessionsB2B == that.browserSessionsB2B
                && mobileAppSessions == that.mobileAppSessions
                && mobileAppSessionsB2B == that.mobileAppSessionsB2B
                && sessions == that.sessions && sessionsB2B == that.sessionsB2B
                && Double.compare(browserSessionPercentage,
                that.browserSessionPercentage) == 0
                && Double.compare(browserSessionPercentageB2B,
                that.browserSessionPercentageB2B) == 0
                && Double.compare(mobileAppSessionPercentage,
                that.mobileAppSessionPercentage) == 0
                && Double.compare(mobileAppSessionPercentageB2B,
                that.mobileAppSessionPercentageB2B) == 0
                && Double.compare(sessionPercentage,
                that.sessionPercentage) == 0
                && Double.compare(sessionPercentageB2B,
                that.sessionPercentageB2B) == 0
                && browserPageViews == that.browserPageViews
                && browserPageViewsB2B == that.browserPageViewsB2B
                && mobileAppPageViews == that.mobileAppPageViews
                && mobileAppPageViewsB2B == that.mobileAppPageViewsB2B
                && pageViews == that.pageViews
                && pageViewsB2B == that.pageViewsB2B
                && Double.compare(browserPageViewsPercentage,
                that.browserPageViewsPercentage) == 0
                && Double.compare(browserPageViewsPercentageB2B,
                that.browserPageViewsPercentageB2B) == 0
                && Double.compare(mobileAppPageViewsPercentage,
                that.mobileAppPageViewsPercentage) == 0
                && Double.compare(mobileAppPageViewsPercentageB2B,
                that.mobileAppPageViewsPercentageB2B) == 0
                && Double.compare(pageViewsPercentage,
                that.pageViewsPercentage) == 0
                && Double.compare(pageViewsPercentageB2B,
                that.pageViewsPercentageB2B) == 0
                && Double.compare(buyBoxPercentage,
                that.buyBoxPercentage) == 0
                && Double.compare(buyBoxPercentageB2B,
                that.buyBoxPercentageB2B) == 0
                && Double.compare(unitSessionPercentage,
                that.unitSessionPercentage) == 0
                && Double.compare(unitSessionPercentageB2B,
                that.unitSessionPercentageB2B) == 0;
    }

    @Override
    public int hashCode() {
        return 11 * Objects.hash(browserSessions, browserSessionsB2B,
                mobileAppSessions, mobileAppSessionsB2B, sessions,
                sessionsB2B, browserSessionPercentage, browserSessionPercentageB2B,
                mobileAppSessionPercentage, mobileAppSessionPercentageB2B,
                sessionPercentage, sessionPercentageB2B, browserPageViews,
                browserPageViewsB2B, mobileAppPageViews, mobileAppPageViewsB2B,
                pageViews, pageViewsB2B, browserPageViewsPercentage,
                browserPageViewsPercentageB2B, mobileAppPageViewsPercentage,
                mobileAppPageViewsPercentageB2B, pageViewsPercentage, pageViewsPercentageB2B,
                buyBoxPercentage, buyBoxPercentageB2B,
                unitSessionPercentage, unitSessionPercentageB2B);
    }
}
