package pl.zankowski.iextrading4j.api.stocks.v1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Report extends BaseData {

    private final LocalDate reportDate;
    private final String filingType;
    private final LocalDate fiscalDate;
    private final BigDecimal fiscalQuarter;
    private final BigDecimal fiscalYear;
    private final String currency;

    public Report(final String symbol, final String id, final String key, final String subkey, final Long updated,
                  final LocalDate reportDate, final String filingType, final LocalDate fiscalDate,
                  final BigDecimal fiscalQuarter, final BigDecimal fiscalYear, final String currency) {
        super(symbol, id, key, subkey, updated);
        this.reportDate = reportDate;
        this.filingType = filingType;
        this.fiscalDate = fiscalDate;
        this.fiscalQuarter = fiscalQuarter;
        this.fiscalYear = fiscalYear;
        this.currency = currency;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public String getFilingType() {
        return filingType;
    }

    public LocalDate getFiscalDate() {
        return fiscalDate;
    }

    public BigDecimal getFiscalQuarter() {
        return fiscalQuarter;
    }

    public BigDecimal getFiscalYear() {
        return fiscalYear;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Report report = (Report) o;
        return Objects.equals(reportDate, report.reportDate) &&
                Objects.equals(filingType, report.filingType) &&
                Objects.equals(fiscalDate, report.fiscalDate) &&
                Objects.equals(fiscalQuarter, report.fiscalQuarter) &&
                Objects.equals(fiscalYear, report.fiscalYear) &&
                Objects.equals(currency, report.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reportDate, filingType, fiscalDate, fiscalQuarter, fiscalYear, currency);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Report.class.getSimpleName() + "[", "]")
                .add("reportDate=" + reportDate)
                .add("filingType='" + filingType + "'")
                .add("fiscalDate=" + fiscalDate)
                .add("fiscalQuarter=" + fiscalQuarter)
                .add("fiscalYear=" + fiscalYear)
                .add("currency='" + currency + "'")
                .toString();
    }
}
