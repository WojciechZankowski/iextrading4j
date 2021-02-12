package pl.zankowski.iextrading4j.api.corporate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class AdvancedBonus extends CorporateData {

    private final LocalDate exDate;
    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final BigDecimal fromFactor;
    private final BigDecimal toFactor;
    private final BigDecimal ratio;
    private final String description;
    private final String flag;
    private final String securityType;
    private final String resultSecurityType;
    private final String currency;
    private final String countryCode;
    private final BigDecimal lapsedPremium;

    @JsonCreator
    public AdvancedBonus(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("refid") final String refid,
            @JsonProperty("source") final String source,
            @JsonProperty("date") final Long date,
            @JsonProperty("created") final LocalDate created,
            @JsonProperty("lastUpdated") final LocalDate lastUpdated,
            @JsonProperty("notes") final String notes,
            @JsonProperty("figi") final String figi,
            @JsonProperty("parValue") final BigDecimal parValue,
            @JsonProperty("parValueCurrency") final String parValueCurrency,
            @JsonProperty("exDate") final LocalDate exDate,
            @JsonProperty("recordDate") final LocalDate recordDate,
            @JsonProperty("paymentDate") final LocalDate paymentDate,
            @JsonProperty("fromFactor") final BigDecimal fromFactor,
            @JsonProperty("toFactor") final BigDecimal toFactor,
            @JsonProperty("ratio") final BigDecimal ratio,
            @JsonProperty("description") final String description,
            @JsonProperty("flag") final String flag,
            @JsonProperty("securityType") final String securityType,
            @JsonProperty("resultSecurityType") final String resultSecurityType,
            @JsonProperty("currency") final String currency,
            @JsonProperty("countryCode") final String countryCode,
            @JsonProperty("lapsedPremium") final BigDecimal lapsedPremium) {
        super(symbol, id, key, subkey, updated, refid, source, date, created, lastUpdated, notes, figi, parValue,
                parValueCurrency);
        this.exDate = exDate;
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.fromFactor = fromFactor;
        this.toFactor = toFactor;
        this.ratio = ratio;
        this.description = description;
        this.flag = flag;
        this.securityType = securityType;
        this.resultSecurityType = resultSecurityType;
        this.currency = currency;
        this.countryCode = countryCode;
        this.lapsedPremium = lapsedPremium;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getFromFactor() {
        return fromFactor;
    }

    public BigDecimal getToFactor() {
        return toFactor;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public String getDescription() {
        return description;
    }

    public String getFlag() {
        return flag;
    }

    public String getSecurityType() {
        return securityType;
    }

    public String getResultSecurityType() {
        return resultSecurityType;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public BigDecimal getLapsedPremium() {
        return lapsedPremium;
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
        final AdvancedBonus that = (AdvancedBonus) o;
        return Objects.equals(exDate, that.exDate) && Objects.equals(recordDate, that.recordDate) &&
                Objects.equals(paymentDate, that.paymentDate) && Objects.equals(fromFactor, that.fromFactor) &&
                Objects.equals(toFactor, that.toFactor) && Objects.equals(ratio, that.ratio) &&
                Objects.equals(description, that.description) && Objects.equals(flag, that.flag) &&
                Objects.equals(securityType, that.securityType) &&
                Objects.equals(resultSecurityType, that.resultSecurityType) &&
                Objects.equals(currency, that.currency) && Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(lapsedPremium, that.lapsedPremium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), exDate, recordDate, paymentDate, fromFactor, toFactor, ratio, description,
                flag, securityType, resultSecurityType, currency, countryCode, lapsedPremium);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdvancedBonus.class.getSimpleName() + "[", "]")
                .add("exDate=" + exDate)
                .add("recordDate=" + recordDate)
                .add("paymentDate=" + paymentDate)
                .add("fromFactor=" + fromFactor)
                .add("toFactor=" + toFactor)
                .add("ratio=" + ratio)
                .add("description='" + description + "'")
                .add("flag='" + flag + "'")
                .add("securityType='" + securityType + "'")
                .add("resultSecurityType='" + resultSecurityType + "'")
                .add("currency='" + currency + "'")
                .add("countryCode='" + countryCode + "'")
                .add("lapsedPremium=" + lapsedPremium)
                .add("refid='" + getRefid() + "'")
                .add("source='" + getSource() + "'")
                .add("date=" + getDate())
                .add("created=" + getCreated())
                .add("lastUpdated=" + getLastUpdated())
                .add("notes='" + getNotes() + "'")
                .add("figi='" + getFigi() + "'")
                .add("parValue=" + getParValue())
                .add("parValueCurrency='" + getParValueCurrency() + "'")
                .add("symbol='" + getSymbol() + "'")
                .add("id='" + getId() + "'")
                .add("key='" + getKey() + "'")
                .add("subkey='" + getSubkey() + "'")
                .add("updated=" + getUpdated())
                .toString();
    }
}
