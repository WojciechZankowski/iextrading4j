package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"exDate", "paymentDate", "recordDate", "declaredDate",
        "amount", "flag", "type", "qualified", "indicated"})
public class Dividends implements Serializable {

    private final LocalDate exDate;
    private final LocalDate paymentDate;
    private final LocalDate recordDate;
    private final LocalDate declaredDate;
    private final BigDecimal amount;
    private final String flag;
    private final DividendType type;
    private final DividendQualification qualified;
    private final String indicated;

    @JsonCreator
    public Dividends(
            @JsonProperty("exDate") final LocalDate exDate,
            @JsonProperty("paymentDate") final LocalDate paymentDate,
            @JsonProperty("recordDate") final LocalDate recordDate,
            @JsonProperty("declaredDate") final LocalDate declaredDate,
            @JsonProperty("amount") final BigDecimal amount,
            @JsonProperty("flag") final String flag,
            @JsonProperty("type") final DividendType type,
            @JsonProperty("qualified") final DividendQualification qualified,
            @JsonProperty("indicated") final String indicated) {
        this.exDate = exDate;
        this.paymentDate = paymentDate;
        this.recordDate = recordDate;
        this.declaredDate = declaredDate;
        this.amount = amount;
        this.flag = flag;
        this.type = type;
        this.qualified = qualified;
        this.indicated = indicated;
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

    public DividendType getType() {
        return type;
    }

    public DividendQualification getQualified() {
        return qualified;
    }

    public String getIndicated() {
        return indicated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dividends dividends = (Dividends) o;
        return Objects.equal(exDate, dividends.exDate) &&
                Objects.equal(paymentDate, dividends.paymentDate) &&
                Objects.equal(recordDate, dividends.recordDate) &&
                Objects.equal(declaredDate, dividends.declaredDate) &&
                Objects.equal(amount, dividends.amount) &&
                Objects.equal(flag, dividends.flag) &&
                type == dividends.type &&
                qualified == dividends.qualified &&
                Objects.equal(indicated, dividends.indicated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(exDate, paymentDate, recordDate, declaredDate, amount,
                flag, type, qualified, indicated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("exDate", exDate)
                .add("paymentDate", paymentDate)
                .add("recordDate", recordDate)
                .add("declaredDate", declaredDate)
                .add("amount", amount)
                .add("flag", flag)
                .add("type", type)
                .add("qualified", qualified)
                .add("indicated", indicated)
                .toString();
    }
}
