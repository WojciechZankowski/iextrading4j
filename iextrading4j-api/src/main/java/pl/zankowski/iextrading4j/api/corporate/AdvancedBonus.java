package pl.zankowski.iextrading4j.api.corporate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class AdvancedBonus extends CorporateData {

    private static final long serialVersionUID = -6477438186877377186L;

    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final String resultSecurityType;
    private final String currency;
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
                parValueCurrency, description, flag, securityType, fromFactor, toFactor, ratio, exDate, countryCode);
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.resultSecurityType = resultSecurityType;
        this.currency = currency;
        this.lapsedPremium = lapsedPremium;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getResultSecurityType() {
        return resultSecurityType;
    }

    public String getCurrency() {
        return currency;
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
        return Objects.equals(recordDate, that.recordDate) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(resultSecurityType, that.resultSecurityType) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(lapsedPremium, that.lapsedPremium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordDate, paymentDate, resultSecurityType, currency, lapsedPremium);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdvancedBonus.class.getSimpleName() + "[", "]")
                .add("recordDate=" + recordDate)
                .add("paymentDate=" + paymentDate)
                .add("resultSecurityType='" + resultSecurityType + "'")
                .add("currency='" + currency + "'")
                .add("countryCode='" + getCountryCode() + "'")
                .add("lapsedPremium=" + lapsedPremium)
                .add("refid='" + getRefid() + "'")
                .add("source='" + getSource() + "'")
                .add("date=" + getDate())
                .add("created=" + getCreated())
                .add("lastUpdated=" + getLastUpdated())
                .add("notes='" + getNotes() + "'")
                .add("figi='" + getFigi() + "'")
                .add("description='" + getDescription() + "'")
                .add("flag='" + getFlag() + "'")
                .add("securityType='" + getSecurityType() + "'")
                .add("fromFactor=" + getFromFactor())
                .add("toFactor=" + getToFactor())
                .add("ratio=" + getRatio())
                .add("parValue=" + getParValue())
                .add("parValueCurrency='" + getParValueCurrency() + "'")
                .add("exDate=" + getExDate())
                .add("symbol='" + getSymbol() + "'")
                .add("id='" + getId() + "'")
                .add("key='" + getKey() + "'")
                .add("subkey='" + getSubkey() + "'")
                .add("updated=" + getUpdated())
                .toString();
    }
}
