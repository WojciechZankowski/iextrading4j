package pl.zankowski.iextrading4j.api.corporate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class AdvancedDistribution extends CorporateData {

    private final LocalDate exDate;
    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final LocalDate withdrawalFromDate;
    private final LocalDate withdrawalToDate;
    private final LocalDate electionDate;
    private final BigDecimal fromFactor;
    private final BigDecimal toFactor;
    private final BigDecimal ratio;
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    private final String description;
    private final String flag;
    private final String securityType;
    private final BigDecimal hasWithdrawalRights;
    private final String countryCode;

    @JsonCreator
    public AdvancedDistribution(
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
            @JsonProperty("withdrawalFromDate") final LocalDate withdrawalFromDate,
            @JsonProperty("withdrawalToDate") final LocalDate withdrawalToDate,
            @JsonProperty("electionDate") final LocalDate electionDate,
            @JsonProperty("fromFactor") final BigDecimal fromFactor,
            @JsonProperty("toFactor") final BigDecimal toFactor,
            @JsonProperty("ratio") final BigDecimal ratio,
            @JsonProperty("minPrice") final BigDecimal minPrice,
            @JsonProperty("maxPrice") final BigDecimal maxPrice,
            @JsonProperty("description") final String description,
            @JsonProperty("flag") final String flag,
            @JsonProperty("securityType") final String securityType,
            @JsonProperty("hasWithdrawalRights") final BigDecimal hasWithdrawalRights,
            @JsonProperty("countryCode") final String countryCode) {
        super(symbol, id, key, subkey, updated, refid, source, date, created, lastUpdated, notes, figi, parValue,
                parValueCurrency);
        this.exDate = exDate;
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.withdrawalFromDate = withdrawalFromDate;
        this.withdrawalToDate = withdrawalToDate;
        this.electionDate = electionDate;
        this.fromFactor = fromFactor;
        this.toFactor = toFactor;
        this.ratio = ratio;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.description = description;
        this.flag = flag;
        this.securityType = securityType;
        this.hasWithdrawalRights = hasWithdrawalRights;
        this.countryCode = countryCode;
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

    public LocalDate getWithdrawalFromDate() {
        return withdrawalFromDate;
    }

    public LocalDate getWithdrawalToDate() {
        return withdrawalToDate;
    }

    public LocalDate getElectionDate() {
        return electionDate;
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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
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

    public BigDecimal getHasWithdrawalRights() {
        return hasWithdrawalRights;
    }

    public String getCountryCode() {
        return countryCode;
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
        final AdvancedDistribution that = (AdvancedDistribution) o;
        return Objects.equals(exDate, that.exDate) && Objects.equals(recordDate, that.recordDate) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(withdrawalFromDate, that.withdrawalFromDate) &&
                Objects.equals(withdrawalToDate, that.withdrawalToDate) &&
                Objects.equals(electionDate, that.electionDate) &&
                Objects.equals(fromFactor, that.fromFactor) &&
                Objects.equals(toFactor, that.toFactor) && Objects.equals(ratio, that.ratio) &&
                Objects.equals(minPrice, that.minPrice) && Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(description, that.description) && Objects.equals(flag, that.flag) &&
                Objects.equals(securityType, that.securityType) &&
                Objects.equals(hasWithdrawalRights, that.hasWithdrawalRights) &&
                Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), exDate, recordDate, paymentDate, withdrawalFromDate, withdrawalToDate,
                electionDate, fromFactor, toFactor, ratio, minPrice, maxPrice, description, flag, securityType,
                hasWithdrawalRights, countryCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdvancedDistribution.class.getSimpleName() + "[", "]")
                .add("exDate=" + exDate)
                .add("recordDate=" + recordDate)
                .add("paymentDate=" + paymentDate)
                .add("withdrawalFromDate=" + withdrawalFromDate)
                .add("withdrawalToDate=" + withdrawalToDate)
                .add("electionDate=" + electionDate)
                .add("fromFactor=" + fromFactor)
                .add("toFactor=" + toFactor)
                .add("ratio=" + ratio)
                .add("minPrice=" + minPrice)
                .add("maxPrice=" + maxPrice)
                .add("description='" + description + "'")
                .add("flag='" + flag + "'")
                .add("securityType='" + securityType + "'")
                .add("hasWithdrawalRights=" + hasWithdrawalRights)
                .add("countryCode='" + countryCode + "'")
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
