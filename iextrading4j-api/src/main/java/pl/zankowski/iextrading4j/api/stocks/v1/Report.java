package pl.zankowski.iextrading4j.api.stocks.v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Report implements Serializable {

    private final LocalDate reportDate;
    private final LocalDate fiscalDate;
    private final String currency;

    public Report(final LocalDate reportDate, final LocalDate fiscalDate, final String currency) {
        this.reportDate = reportDate;
        this.fiscalDate = fiscalDate;
        this.currency = currency;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public LocalDate getFiscalDate() {
        return fiscalDate;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Report report = (Report) o;
        return Objects.equals(reportDate, report.reportDate) &&
                Objects.equals(fiscalDate, report.fiscalDate) &&
                Objects.equals(currency, report.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportDate, fiscalDate, currency);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Report.class.getSimpleName() + "[", "]")
                .add("reportDate=" + reportDate)
                .add("fiscalDate=" + fiscalDate)
                .add("currency='" + currency + "'")
                .toString();
    }
}
