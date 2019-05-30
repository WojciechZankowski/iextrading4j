package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AdvancedStats extends KeyStats {

    private static final long serialVersionUID = -5723273184868475823L;

    private final BigDecimal totalCash;
    private final BigDecimal currentDebt;
    private final BigDecimal revenue;
    private final BigDecimal grossProfit;
    private final BigDecimal totalRevenue;
    private final BigDecimal ebitda;
    private final BigDecimal revenuePerShare;
    private final BigDecimal revenuePerEmployee;
    private final BigDecimal debtToEquity;
    private final BigDecimal profitMargin;
    private final BigDecimal enterpriseValue;
    private final BigDecimal enterpriseValueToRevenue;
    private final BigDecimal priceToSales;
    private final BigDecimal priceToBook;
    private final BigDecimal forwardPERatio;
    private final BigDecimal pegRatio;

    @JsonCreator
    public AdvancedStats(
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("marketcap") final BigDecimal marketcap,
            @JsonProperty("week52high") final BigDecimal week52high,
            @JsonProperty("week52low") final BigDecimal week52low,
            @JsonProperty("week52change") final BigDecimal week52change,
            @JsonProperty("sharesOutstanding") final BigDecimal sharesOutstanding,
            @JsonProperty("float") final BigDecimal aFloat,
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("avg10Volume") final BigDecimal avg10Volume,
            @JsonProperty("avg30Volume") final BigDecimal avg30Volume,
            @JsonProperty("day200MovingAvg") final BigDecimal day200MovingAvg,
            @JsonProperty("day50MovingAvg") final BigDecimal day50MovingAvg,
            @JsonProperty("employees") final BigDecimal employees,
            @JsonProperty("ttmEPS") final BigDecimal ttmEPS,
            @JsonProperty("ttmDividendRate") final BigDecimal ttmDividendRate,
            @JsonProperty("dividendYield") final BigDecimal dividendYield,
            @JsonProperty("nextDividendDate") final LocalDate nextDividendDate,
            @JsonProperty("exDividendDate") final LocalDate exDividendDate,
            @JsonProperty("nextEarningsDate") final LocalDate nextEarningsDate,
            @JsonProperty("peRatio") final BigDecimal peRatio,
            @JsonProperty("maxChangePercent") final BigDecimal maxChangePercent,
            @JsonProperty("year5ChangePercent") final BigDecimal year5ChangePercent,
            @JsonProperty("year2ChangePercent") final BigDecimal year2ChangePercent,
            @JsonProperty("year1ChangePercent") final BigDecimal year1ChangePercent,
            @JsonProperty("ytdChangePercent") final BigDecimal ytdChangePercent,
            @JsonProperty("month6ChangePercent") final BigDecimal month6ChangePercent,
            @JsonProperty("month3ChangePercent") final BigDecimal month3ChangePercent,
            @JsonProperty("month1ChangePercent") final BigDecimal month1ChangePercent,
            @JsonProperty("day5ChangePercent") final BigDecimal day5ChangePercent,
            @JsonProperty("day30ChangePercent") final BigDecimal day30ChangePercent,
            @JsonProperty("totalCash") final BigDecimal totalCash,
            @JsonProperty("currentDebt") final BigDecimal currentDebt,
            @JsonProperty("revenue") final BigDecimal revenue,
            @JsonProperty("grossProfit") final BigDecimal grossProfit,
            @JsonProperty("totalRevenue") final BigDecimal totalRevenue,
            @JsonProperty("EBITDA") final BigDecimal ebitda,
            @JsonProperty("revenuePerShare") final BigDecimal revenuePerShare,
            @JsonProperty("revenuePerEmployee") final BigDecimal revenuePerEmployee,
            @JsonProperty("debtToEquity") final BigDecimal debtToEquity,
            @JsonProperty("profitMargin") final BigDecimal profitMargin,
            @JsonProperty("enterpriseValue") final BigDecimal enterpriseValue,
            @JsonProperty("enterpriseValueToRevenue") final BigDecimal enterpriseValueToRevenue,
            @JsonProperty("priceToSales") final BigDecimal priceToSales,
            @JsonProperty("priceToBook") final BigDecimal priceToBook,
            @JsonProperty("forwardPERatio") final BigDecimal forwardPERatio,
            @JsonProperty("pegRatio") final BigDecimal pegRatio,
            @JsonProperty("beta") final BigDecimal beta) {
        super(companyName, marketcap, week52high, week52low, week52change, sharesOutstanding, aFloat, symbol,
                avg10Volume, avg30Volume, day200MovingAvg, day50MovingAvg, employees, ttmEPS, ttmDividendRate,
                dividendYield, nextDividendDate, exDividendDate, nextEarningsDate, peRatio, maxChangePercent,
                year5ChangePercent, year2ChangePercent, year1ChangePercent, ytdChangePercent, month6ChangePercent,
                month3ChangePercent, month1ChangePercent, day5ChangePercent, day30ChangePercent, beta);
        this.totalCash = totalCash;
        this.currentDebt = currentDebt;
        this.revenue = revenue;
        this.grossProfit = grossProfit;
        this.totalRevenue = totalRevenue;
        this.ebitda = ebitda;
        this.revenuePerShare = revenuePerShare;
        this.revenuePerEmployee = revenuePerEmployee;
        this.debtToEquity = debtToEquity;
        this.profitMargin = profitMargin;
        this.enterpriseValue = enterpriseValue;
        this.enterpriseValueToRevenue = enterpriseValueToRevenue;
        this.priceToSales = priceToSales;
        this.priceToBook = priceToBook;
        this.forwardPERatio = forwardPERatio;
        this.pegRatio = pegRatio;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public BigDecimal getCurrentDebt() {
        return currentDebt;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public BigDecimal getEbitda() {
        return ebitda;
    }

    public BigDecimal getRevenuePerShare() {
        return revenuePerShare;
    }

    public BigDecimal getRevenuePerEmployee() {
        return revenuePerEmployee;
    }

    public BigDecimal getDebtToEquity() {
        return debtToEquity;
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public BigDecimal getEnterpriseValue() {
        return enterpriseValue;
    }

    public BigDecimal getEnterpriseValueToRevenue() {
        return enterpriseValueToRevenue;
    }

    public BigDecimal getPriceToSales() {
        return priceToSales;
    }

    public BigDecimal getPriceToBook() {
        return priceToBook;
    }

    public BigDecimal getForwardPERatio() {
        return forwardPERatio;
    }

    public BigDecimal getPegRatio() {
        return pegRatio;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvancedStats)) return false;
        if (!super.equals(o)) return false;
        final AdvancedStats that = (AdvancedStats) o;
        return Objects.equal(totalCash, that.totalCash) &&
                Objects.equal(currentDebt, that.currentDebt) &&
                Objects.equal(revenue, that.revenue) &&
                Objects.equal(grossProfit, that.grossProfit) &&
                Objects.equal(totalRevenue, that.totalRevenue) &&
                Objects.equal(ebitda, that.ebitda) &&
                Objects.equal(revenuePerShare, that.revenuePerShare) &&
                Objects.equal(revenuePerEmployee, that.revenuePerEmployee) &&
                Objects.equal(debtToEquity, that.debtToEquity) &&
                Objects.equal(profitMargin, that.profitMargin) &&
                Objects.equal(enterpriseValue, that.enterpriseValue) &&
                Objects.equal(enterpriseValueToRevenue, that.enterpriseValueToRevenue) &&
                Objects.equal(priceToSales, that.priceToSales) &&
                Objects.equal(priceToBook, that.priceToBook) &&
                Objects.equal(forwardPERatio, that.forwardPERatio) &&
                Objects.equal(pegRatio, that.pegRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), totalCash, currentDebt, revenue, grossProfit,
                totalRevenue, ebitda, revenuePerShare, revenuePerEmployee, debtToEquity,
                profitMargin, enterpriseValue, enterpriseValueToRevenue, priceToSales,
                priceToBook, forwardPERatio, pegRatio);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("totalCash", totalCash)
                .add("currentDebt", currentDebt)
                .add("revenue", revenue)
                .add("grossProfit", grossProfit)
                .add("totalRevenue", totalRevenue)
                .add("ebitda", ebitda)
                .add("revenuePerShare", revenuePerShare)
                .add("revenuePerEmployee", revenuePerEmployee)
                .add("debtToEquity", debtToEquity)
                .add("profitMargin", profitMargin)
                .add("enterpriseValue", enterpriseValue)
                .add("enterpriseValueToRevenue", enterpriseValueToRevenue)
                .add("priceToSales", priceToSales)
                .add("priceToBook", priceToBook)
                .add("forwardPERatio", forwardPERatio)
                .add("pegRatio", pegRatio)
                .toString();
    }

}
