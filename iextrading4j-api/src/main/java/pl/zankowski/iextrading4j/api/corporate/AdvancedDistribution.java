package pl.zankowski.iextrading4j.api.corporate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class AdvancedDistribution extends CorporateData {

    private static final long serialVersionUID = 3622240354483747567L;

    private final LocalDate recordDate;
    private final LocalDate paymentDate;
    private final LocalDate withdrawalFromDate;
    private final LocalDate withdrawalToDate;
    private final LocalDate electionDate;
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    private final BigDecimal hasWithdrawalRights;

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
                parValueCurrency, description, flag, securityType, fromFactor, toFactor, ratio, exDate, countryCode);
        this.recordDate = recordDate;
        this.paymentDate = paymentDate;
        this.withdrawalFromDate = withdrawalFromDate;
        this.withdrawalToDate = withdrawalToDate;
        this.electionDate = electionDate;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.hasWithdrawalRights = hasWithdrawalRights;
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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public BigDecimal getHasWithdrawalRights() {
        return hasWithdrawalRights;
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
        return Objects.equals(recordDate, that.recordDate) &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(withdrawalFromDate, that.withdrawalFromDate) &&
                Objects.equals(withdrawalToDate, that.withdrawalToDate) &&
                Objects.equals(electionDate, that.electionDate) &&
                Objects.equals(minPrice, that.minPrice) && Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(hasWithdrawalRights, that.hasWithdrawalRights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordDate, paymentDate, withdrawalFromDate, withdrawalToDate,
                electionDate, minPrice, maxPrice, hasWithdrawalRights);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdvancedDistribution.class.getSimpleName() + "[", "]")
                .add("recordDate=" + recordDate)
                .add("paymentDate=" + paymentDate)
                .add("withdrawalFromDate=" + withdrawalFromDate)
                .add("withdrawalToDate=" + withdrawalToDate)
                .add("electionDate=" + electionDate)
                .add("minPrice=" + minPrice)
                .add("maxPrice=" + maxPrice)
                .add("hasWithdrawalRights=" + hasWithdrawalRights)
                .add("countryCode='" + getCountryCode() + "'")
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
