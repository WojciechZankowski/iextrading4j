package pl.zankowski.iextrading4j.api.corporate;

import pl.zankowski.iextrading4j.api.stocks.v1.BaseData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class CorporateData extends BaseData {

    private static final long serialVersionUID = -1484007127414346002L;

    private final String refid;
    private final String source;
    private final Long date;
    private final LocalDate created;
    private final LocalDate lastUpdated;
    private final String notes;
    private final String figi;
    private final String description;
    private final String flag;
    private final String securityType;
    private final BigDecimal fromFactor;
    private final BigDecimal toFactor;
    private final BigDecimal ratio;
    private final BigDecimal parValue;
    private final String parValueCurrency;
    private final LocalDate exDate;
    private final String countryCode;

    public CorporateData(final String symbol,
                         final String id,
                         final String key,
                         final String subkey,
                         final Long updated,
                         final String refid,
                         final String source,
                         final Long date,
                         final LocalDate created,
                         final LocalDate lastUpdated,
                         final String notes,
                         final String figi,
                         final BigDecimal parValue,
                         final String parValueCurrency,
                         final String description,
                         final String flag,
                         final String securityType,
                         final BigDecimal fromFactor,
                         final BigDecimal toFactor,
                         final BigDecimal ratio,
                         final LocalDate exDate,
                         final String countryCode) {
        super(symbol, id, key, subkey, updated);
        this.refid = refid;
        this.source = source;
        this.date = date;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.notes = notes;
        this.figi = figi;
        this.parValue = parValue;
        this.parValueCurrency = parValueCurrency;
        this.description = description;
        this.flag = flag;
        this.securityType = securityType;
        this.fromFactor = fromFactor;
        this.toFactor = toFactor;
        this.ratio = ratio;
        this.exDate = exDate;
        this.countryCode = countryCode;
    }

    public String getRefid() {
        return refid;
    }

    public String getSource() {
        return source;
    }

    public Long getDate() {
        return date;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public String getNotes() {
        return notes;
    }

    public String getFigi() {
        return figi;
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

    public BigDecimal getFromFactor() {
        return fromFactor;
    }

    public BigDecimal getToFactor() {
        return toFactor;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public BigDecimal getParValue() {
        return parValue;
    }

    public String getParValueCurrency() {
        return parValueCurrency;
    }

    public LocalDate getExDate() {
        return exDate;
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
        final CorporateData that = (CorporateData) o;
        return Objects.equals(refid, that.refid) && Objects.equals(source, that.source) &&
                Objects.equals(date, that.date) && Objects.equals(created, that.created) &&
                Objects.equals(lastUpdated, that.lastUpdated) && Objects.equals(notes, that.notes) &&
                Objects.equals(figi, that.figi) && Objects.equals(description, that.description) &&
                Objects.equals(flag, that.flag) && Objects.equals(securityType, that.securityType) &&
                Objects.equals(fromFactor, that.fromFactor) &&
                Objects.equals(toFactor, that.toFactor) && Objects.equals(ratio, that.ratio) &&
                Objects.equals(parValue, that.parValue) &&
                Objects.equals(parValueCurrency, that.parValueCurrency) &&
                Objects.equals(exDate, that.exDate) && Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refid, source, date, created, lastUpdated, notes, figi, description, flag,
                securityType, fromFactor, toFactor, ratio, parValue, parValueCurrency, exDate, countryCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CorporateData.class.getSimpleName() + "[", "]")
                .add("refid='" + refid + "'")
                .add("source='" + source + "'")
                .add("date=" + date)
                .add("created=" + created)
                .add("lastUpdated=" + lastUpdated)
                .add("notes='" + notes + "'")
                .add("figi='" + figi + "'")
                .add("description='" + description + "'")
                .add("flag='" + flag + "'")
                .add("securityType='" + securityType + "'")
                .add("fromFactor=" + fromFactor)
                .add("toFactor=" + toFactor)
                .add("ratio=" + ratio)
                .add("parValue=" + parValue)
                .add("parValueCurrency='" + parValueCurrency + "'")
                .add("exDate=" + exDate)
                .add("countryCode='" + countryCode + "'")
                .add("symbol='" + getSymbol() + "'")
                .add("id='" + getId() + "'")
                .add("key='" + getKey() + "'")
                .add("subkey='" + getSubkey() + "'")
                .add("updated=" + getUpdated())
                .toString();
    }
}
