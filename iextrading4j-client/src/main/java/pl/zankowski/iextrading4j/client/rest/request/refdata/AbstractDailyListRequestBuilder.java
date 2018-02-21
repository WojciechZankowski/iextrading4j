package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractDailyListRequestBuilder<R, B extends IRestRequestBuilder<R>> implements IRestRequestBuilder<R> {

    private static final DateTimeFormatter DATE_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    private boolean sample;
    private LocalDate date;

    public String getPeriod() {
        return sample ? "sample" : DATE_PARAM_FORMATTER.format(date);
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
