package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

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
    private final BigDecimal peHigh;
    private final BigDecimal peLow;
    private final LocalDate week52highDate;
    private final LocalDate week52lowDate;
    private final BigDecimal putCallRatio;
    private final LocalDate week52highDateSplitAdjustOnly;
    private final LocalDate week52lowDateSplitAdjustOnly;

    @JsonCreator
    public AdvancedStats(
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("marketcap") final BigDecimal marketcap,
            @JsonProperty("week52high") final BigDecimal week52high,
            @JsonProperty("week52low") final BigDecimal week52low,
            @JsonProperty("week52highSplitAdjustOnly") final BigDecimal week52highSplitAdjustOnly,
            @JsonProperty("week52highDateSplitAdjustOnly") final LocalDate week52highDateSplitAdjustOnly,
            @JsonProperty("week52lowSplitAdjustOnly") final BigDecimal week52lowSplitAdjustOnly,
            @JsonProperty("week52lowDateSplitAdjustOnly") final LocalDate week52lowDateSplitAdjustOnly,
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
            @JsonProperty("beta") final BigDecimal beta,
            @JsonProperty("peHigh") final BigDecimal peHigh,
            @JsonProperty("peLow") final BigDecimal peLow,
            @JsonProperty("week52highDate") final LocalDate week52highDate,
            @JsonProperty("week52lowDate") final LocalDate week52lowDate,
            @JsonProperty("putCallRatio") final BigDecimal putCallRatio) {
        super(companyName, marketcap, week52high, week52low, week52highSplitAdjustOnly, week52lowSplitAdjustOnly,
                week52change, sharesOutstanding, aFloat, symbol, avg10Volume, avg30Volume, day200MovingAvg,
                day50MovingAvg, employees, ttmEPS, ttmDividendRate, dividendYield, nextDividendDate, exDividendDate,
                nextEarningsDate, peRatio, maxChangePercent, year5ChangePercent, year2ChangePercent, year1ChangePercent,
                ytdChangePercent, month6ChangePercent, month3ChangePercent, month1ChangePercent, day5ChangePercent,
                day30ChangePercent, beta);
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
        this.peHigh = peHigh;
        this.peLow = peLow;
        this.week52highDate = week52highDate;
        this.week52lowDate = week52lowDate;
        this.putCallRatio = putCallRatio;
        this.week52highDateSplitAdjustOnly = week52highDateSplitAdjustOnly;
        this.week52lowDateSplitAdjustOnly = week52lowDateSplitAdjustOnly;
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

    public BigDecimal getPeHigh() {
        return peHigh;
    }

    public BigDecimal getPeLow() {
        return peLow;
    }

    public LocalDate getWeek52highDate() {
        return week52highDate;
    }

    public LocalDate getWeek52lowDate() {
        return week52lowDate;
    }

    public BigDecimal getPutCallRatio() {
        return putCallRatio;
    }

    public LocalDate getWeek52highDateSplitAdjustOnly() {
        return week52highDateSplitAdjustOnly;
    }

    public LocalDate getWeek52lowDateSplitAdjustOnly() {
        return week52lowDateSplitAdjustOnly;
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
        final AdvancedStats that = (AdvancedStats) o;
        return Objects.equals(totalCash, that.totalCash) &&
                Objects.equals(currentDebt, that.currentDebt) &&
                Objects.equals(revenue, that.revenue) &&
                Objects.equals(grossProfit, that.grossProfit) &&
                Objects.equals(totalRevenue, that.totalRevenue) &&
                Objects.equals(ebitda, that.ebitda) &&
                Objects.equals(revenuePerShare, that.revenuePerShare) &&
                Objects.equals(revenuePerEmployee, that.revenuePerEmployee) &&
                Objects.equals(debtToEquity, that.debtToEquity) &&
                Objects.equals(profitMargin, that.profitMargin) &&
                Objects.equals(enterpriseValue, that.enterpriseValue) &&
                Objects.equals(enterpriseValueToRevenue, that.enterpriseValueToRevenue) &&
                Objects.equals(priceToSales, that.priceToSales) &&
                Objects.equals(priceToBook, that.priceToBook) &&
                Objects.equals(forwardPERatio, that.forwardPERatio) &&
                Objects.equals(pegRatio, that.pegRatio) && Objects.equals(peHigh, that.peHigh) &&
                Objects.equals(peLow, that.peLow) &&
                Objects.equals(week52highDate, that.week52highDate) &&
                Objects.equals(week52lowDate, that.week52lowDate) &&
                Objects.equals(putCallRatio, that.putCallRatio) &&
                Objects.equals(week52highDateSplitAdjustOnly, that.week52highDateSplitAdjustOnly) &&
                Objects.equals(week52lowDateSplitAdjustOnly, that.week52lowDateSplitAdjustOnly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalCash, currentDebt, revenue, grossProfit, totalRevenue, ebitda,
                revenuePerShare, revenuePerEmployee, debtToEquity, profitMargin, enterpriseValue,
                enterpriseValueToRevenue, priceToSales, priceToBook, forwardPERatio, pegRatio, peHigh, peLow,
                week52highDate, week52lowDate, putCallRatio, week52highDateSplitAdjustOnly,
                week52lowDateSplitAdjustOnly);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdvancedStats.class.getSimpleName() + "[", "]")
                .add("totalCash=" + totalCash)
                .add("currentDebt=" + currentDebt)
                .add("revenue=" + revenue)
                .add("grossProfit=" + grossProfit)
                .add("totalRevenue=" + totalRevenue)
                .add("ebitda=" + ebitda)
                .add("revenuePerShare=" + revenuePerShare)
                .add("revenuePerEmployee=" + revenuePerEmployee)
                .add("debtToEquity=" + debtToEquity)
                .add("profitMargin=" + profitMargin)
                .add("enterpriseValue=" + enterpriseValue)
                .add("enterpriseValueToRevenue=" + enterpriseValueToRevenue)
                .add("priceToSales=" + priceToSales)
                .add("priceToBook=" + priceToBook)
                .add("forwardPERatio=" + forwardPERatio)
                .add("pegRatio=" + pegRatio)
                .add("peHigh=" + peHigh)
                .add("peLow=" + peLow)
                .add("week52highDate=" + week52highDate)
                .add("week52lowDate=" + week52lowDate)
                .add("putCallRatio=" + putCallRatio)
                .add("week52highDateSplitAdjustOnly=" + week52highDateSplitAdjustOnly)
                .add("week52lowDateSplitAdjustOnly=" + week52lowDateSplitAdjustOnly)
                .add("companyName='" + getCompanyName() + "'")
                .add("marketcap=" + getMarketcap())
                .add("week52high=" + getWeek52high())
                .add("week52low=" + getWeek52low())
                .add("week52highSplitAdjustOnly=" + getWeek52highSplitAdjustOnly())
                .add("week52lowSplitAdjustOnly=" + getWeek52lowSplitAdjustOnly())
                .add("week52change=" + getWeek52change())
                .add("sharesOutstanding=" + getSharesOutstanding())
                .add("float=" + getFloat())
                .add("symbol='" + getSymbol() + "'")
                .add("avg10Volume=" + getAvg10Volume())
                .add("avg30Volume=" + getAvg30Volume())
                .add("day200MovingAvg=" + getDay200MovingAvg())
                .add("day50MovingAvg=" + getDay50MovingAvg())
                .add("employees=" + getEmployees())
                .add("ttmEPS=" + getTtmEPS())
                .add("ttmDividendRate=" + getTtmDividendRate())
                .add("dividendYield=" + getDividendYield())
                .add("nextDividendDate=" + getNextDividendDate())
                .add("exDividendDate=" + getExDividendDate())
                .add("nextEarningsDate=" + getNextEarningsDate())
                .add("peRatio=" + getPeRatio())
                .add("maxChangePercent=" + getMaxChangePercent())
                .add("year5ChangePercent=" + getYear5ChangePercent())
                .add("year2ChangePercent=" + getYear2ChangePercent())
                .add("year1ChangePercent=" + getYear1ChangePercent())
                .add("ytdChangePercent=" + getYtdChangePercent())
                .add("month6ChangePercent=" + getMonth6ChangePercent())
                .add("month3ChangePercent=" + getMonth3ChangePercent())
                .add("month1ChangePercent=" + getMonth1ChangePercent())
                .add("day5ChangePercent=" + getDay5ChangePercent())
                .add("day30ChangePercent=" + getDay30ChangePercent())
                .add("beta=" + getBeta())
                .toString();
    }
}
