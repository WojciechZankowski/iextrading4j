package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Dividends extends BaseData {

    private static final long serialVersionUID = -8671643610377057386L;

    private final Long refid;
    private final LocalDate exDate;
    private final LocalDate paymentDate;
    private final LocalDate recordDate;
    private final LocalDate declaredDate;
    private final BigDecimal amount;
    private final String flag;
    private final String currency;
    private final String description;
    private final String frequency;
    private final Long date;

    @JsonCreator
    public Dividends(
            @JsonProperty("refid") final Long refid,
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("exDate") final LocalDate exDate,
            @JsonProperty("paymentDate") final LocalDate paymentDate,
            @JsonProperty("recordDate") final LocalDate recordDate,
            @JsonProperty("declaredDate") final LocalDate declaredDate,
            @JsonProperty("amount") final BigDecimal amount,
            @JsonProperty("flag") final String flag,
            @JsonProperty("currency") final String currency,
            @JsonProperty("description") final String description,
            @JsonProperty("frequency") final String frequency,
            @JsonProperty("date") final Long date) {
        super(symbol, id, key, subkey, updated);
        this.refid = refid;
        this.exDate = exDate;
        this.paymentDate = paymentDate;
        this.recordDate = recordDate;
        this.declaredDate = declaredDate;
        this.amount = amount;
        this.flag = flag;
        this.currency = currency;
        this.description = description;
        this.frequency = frequency;
        this.date = date;
    }

    public Long getRefid() {
        return refid;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public LocalDate getDeclaredDate() {
        return declaredDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getFlag() {
        return flag;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getFrequency() {
        return frequency;
    }

    public Long getDate() {
        return date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final Dividends dividends = (Dividends) o;
        return Objects.equals(refid, dividends.refid) &&
                Objects.equals(exDate, dividends.exDate) &&
                Objects.equals(paymentDate, dividends.paymentDate) &&
                Objects.equals(recordDate, dividends.recordDate) &&
                Objects.equals(declaredDate, dividends.declaredDate) &&
                Objects.equals(amount, dividends.amount) &&
                Objects.equals(flag, dividends.flag) &&
                Objects.equals(currency, dividends.currency) &&
                Objects.equals(description, dividends.description) &&
                Objects.equals(frequency, dividends.frequency) &&
                Objects.equals(date, dividends.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refid, exDate, paymentDate, recordDate, declaredDate,
                amount, flag, currency, description, frequency, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dividends.class.getSimpleName() + "[", "]")
                .add("refid=" + refid)
                .add("exDate=" + exDate)
                .add("paymentDate=" + paymentDate)
                .add("recordDate=" + recordDate)
                .add("declaredDate=" + declaredDate)
                .add("amount=" + amount)
                .add("flag='" + flag + "'")
                .add("currency='" + currency + "'")
                .add("description='" + description + "'")
                .add("frequency='" + frequency + "'")
                .add("date=" + date)
                .toString();
    }
}
