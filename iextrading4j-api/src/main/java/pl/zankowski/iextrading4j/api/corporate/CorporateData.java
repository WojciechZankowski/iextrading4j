package pl.zankowski.iextrading4j.api.corporate;

import pl.zankowski.iextrading4j.api.stocks.v1.BaseData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class CorporateData extends BaseData {

    private final String refid;
    private final String source;
    private final Long date;
    private final LocalDate created;
    private final LocalDate lastUpdated;
    private final String notes;
    private final String figi;
    private final BigDecimal parValue;
    private final String parValueCurrency;

    public CorporateData(final String symbol, final String id, final String key, final String subkey,
                         final Long updated, final String refid, final String source, final Long date,
                         final LocalDate created, final LocalDate lastUpdated, final String notes, final String figi,
                         final BigDecimal parValue, final String parValueCurrency) {
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

    public BigDecimal getParValue() {
        return parValue;
    }

    public String getParValueCurrency() {
        return parValueCurrency;
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
        return Objects.equals(refid, that.refid) &&
                Objects.equals(source, that.source) &&
                Objects.equals(date, that.date) &&
                Objects.equals(created, that.created) &&
                Objects.equals(lastUpdated, that.lastUpdated) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(figi, that.figi) &&
                Objects.equals(parValue, that.parValue) &&
                Objects.equals(parValueCurrency, that.parValueCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refid, source, date, created, lastUpdated, notes, figi,
                parValue, parValueCurrency);
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
                .add("parValue=" + parValue)
                .add("parValueCurrency='" + parValueCurrency + "'")
                .add("symbol='" + getSymbol() + "'")
                .add("id='" + getId() + "'")
                .add("key='" + getKey() + "'")
                .add("subkey='" + getSubkey() + "'")
                .add("updated=" + getUpdated())
                .toString();
    }
}
