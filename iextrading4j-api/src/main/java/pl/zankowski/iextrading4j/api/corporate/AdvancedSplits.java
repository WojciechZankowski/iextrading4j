package pl.zankowski.iextrading4j.api.corporate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class AdvancedSplits extends CorporateData {

    private static final long serialVersionUID = -959636960052328692L;

    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final BigDecimal oldParValue;
    private final String oldParValueCurrency;
    private final String splitType;

    public AdvancedSplits(
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
            @JsonProperty("fromFactor") final BigDecimal fromFactor,
            @JsonProperty("toFactor") final BigDecimal toFactor,
            @JsonProperty("ratio") final BigDecimal ratio,
            @JsonProperty("description") final String description,
            @JsonProperty("flag") final String flag,
            @JsonProperty("securityType") final String securityType,
            @JsonProperty("countryCode") final String countryCode,
            @JsonProperty("recordDate") final LocalDate recordDate,
            @JsonProperty("paymentDate") final LocalDate paymentDate,
            @JsonProperty("oldParValue") final BigDecimal oldParValue,
            @JsonProperty("oldParValueCurrency") final String oldParValueCurrency,
            @JsonProperty("splitType") final String splitType) {
        super(symbol, id, key, subkey, updated, refid, source, date, created, lastUpdated, notes, figi, parValue,
                parValueCurrency, description, flag, securityType, fromFactor, toFactor, ratio, exDate, countryCode);
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.oldParValue = oldParValue;
        this.oldParValueCurrency = oldParValueCurrency;
        this.splitType = splitType;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getOldParValue() {
        return oldParValue;
    }

    public String getOldParValueCurrency() {
        return oldParValueCurrency;
    }

    public String getSplitType() {
        return splitType;
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
        final AdvancedSplits that = (AdvancedSplits) o;
        return Objects.equals(recordDate, that.recordDate) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(oldParValue, that.oldParValue) &&
                Objects.equals(oldParValueCurrency, that.oldParValueCurrency) &&
                Objects.equals(splitType, that.splitType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordDate, paymentDate, oldParValue, oldParValueCurrency, splitType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdvancedSplits.class.getSimpleName() + "[", "]")
                .add("recordDate=" + recordDate)
                .add("paymentDate=" + paymentDate)
                .add("oldParValue=" + oldParValue)
                .add("oldParValueCurrency='" + oldParValueCurrency + "'")
                .add("splitType='" + splitType + "'")
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
                .add("countryCode='" + getCountryCode() + "'")
                .add("symbol='" + getSymbol() + "'")
                .add("id='" + getId() + "'")
                .add("key='" + getKey() + "'")
                .add("subkey='" + getSubkey() + "'")
                .add("updated=" + getUpdated())
                .toString();
    }
}
