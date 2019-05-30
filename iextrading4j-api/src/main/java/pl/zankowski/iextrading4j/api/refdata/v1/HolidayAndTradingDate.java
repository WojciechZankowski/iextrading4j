package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.time.LocalDate;

@JsonPropertyOrder({"date", "settlementDate"})
public class HolidayAndTradingDate implements Serializable {

    private static final long serialVersionUID = -1638495815132092382L;

    private final LocalDate date;
    private final LocalDate settlementDate;

    @JsonCreator
    public HolidayAndTradingDate(
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("settlementDate") final LocalDate settlementDate) {
        this.date = date;
        this.settlementDate = settlementDate;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final HolidayAndTradingDate that = (HolidayAndTradingDate) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(settlementDate, that.settlementDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, settlementDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("settlementDate", settlementDate)
                .toString();
    }

}
