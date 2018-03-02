package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.time.LocalDate;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public abstract class AbstractDailyListRequestBuilder<R, B extends IRestRequestBuilder<R>> implements IRestRequestBuilder<R> {

    private boolean sample;
    private LocalDate date;

    String getPeriod() {
        return sample
                ? "sample"
                : date == null ? "" : IEX_DATE_FORMATTER.format(date);
    }

    public B withDate(final LocalDate date) {
        this.date = date;
        return (B) this;
    }

    public B withSample() {
        this.sample = true;
        return (B) this;
    }

}
