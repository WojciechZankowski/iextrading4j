package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class CeoCompensation implements Serializable {

    private final String symbol;
    private final String name;
    private final String companyName;
    private final String location;
    private final BigDecimal salary;
    private final BigDecimal bonus;
    private final BigDecimal stockAwards;
    private final BigDecimal optionAwards;
    private final BigDecimal nonEquityIncentives;
    private final BigDecimal pensionAndDeferred;
    private final BigDecimal otherComp;
    private final BigDecimal total;
    private final String year;

    @JsonCreator
    public CeoCompensation(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("name") final String name,
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("location") final String location,
            @JsonProperty("salary") final BigDecimal salary,
            @JsonProperty("bonus") final BigDecimal bonus,
            @JsonProperty("stockAwards") final BigDecimal stockAwards,
            @JsonProperty("optionAwards") final BigDecimal optionAwards,
            @JsonProperty("nonEquityIncentives") final BigDecimal nonEquityIncentives,
            @JsonProperty("pensionAndDeferred") final BigDecimal pensionAndDeferred,
            @JsonProperty("otherComp") final BigDecimal otherComp,
            @JsonProperty("total") final BigDecimal total,
            @JsonProperty("year") final String year) {
        this.symbol = symbol;
        this.name = name;
        this.companyName = companyName;
        this.location = location;
        this.salary = salary;
        this.bonus = bonus;
        this.stockAwards = stockAwards;
        this.optionAwards = optionAwards;
        this.nonEquityIncentives = nonEquityIncentives;
        this.pensionAndDeferred = pensionAndDeferred;
        this.otherComp = otherComp;
        this.total = total;
        this.year = year;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public BigDecimal getStockAwards() {
        return stockAwards;
    }

    public BigDecimal getOptionAwards() {
        return optionAwards;
    }

    public BigDecimal getNonEquityIncentives() {
        return nonEquityIncentives;
    }

    public BigDecimal getPensionAndDeferred() {
        return pensionAndDeferred;
    }

    public BigDecimal getOtherComp() {
        return otherComp;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getYear() {
        return year;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CeoCompensation)) return false;
        final CeoCompensation that = (CeoCompensation) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(name, that.name) &&
                Objects.equal(companyName, that.companyName) &&
                Objects.equal(location, that.location) &&
                Objects.equal(salary, that.salary) &&
                Objects.equal(bonus, that.bonus) &&
                Objects.equal(stockAwards, that.stockAwards) &&
                Objects.equal(optionAwards, that.optionAwards) &&
                Objects.equal(nonEquityIncentives, that.nonEquityIncentives) &&
                Objects.equal(pensionAndDeferred, that.pensionAndDeferred) &&
                Objects.equal(otherComp, that.otherComp) &&
                Objects.equal(total, that.total) &&
                Objects.equal(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, name, companyName, location, salary, bonus,
                stockAwards, optionAwards, nonEquityIncentives, pensionAndDeferred,
                otherComp, total, year);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("name", name)
                .add("companyName", companyName)
                .add("location", location)
                .add("salary", salary)
                .add("bonus", bonus)
                .add("stockAwards", stockAwards)
                .add("optionAwards", optionAwards)
                .add("nonEquityIncentives", nonEquityIncentives)
                .add("pensionAndDeferred", pensionAndDeferred)
                .add("otherComp", otherComp)
                .add("total", total)
                .add("year", year)
                .toString();
    }

}
