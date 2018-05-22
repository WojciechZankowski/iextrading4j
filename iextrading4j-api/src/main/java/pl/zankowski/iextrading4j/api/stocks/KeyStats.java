package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class KeyStats implements Serializable {

    private final String companyName;
    private final BigDecimal marketcap;
    private final BigDecimal beta;
    private final BigDecimal week52high;
    private final BigDecimal week52low;
    private final BigDecimal week52change;
    private final BigDecimal shortInterest;
    private final LocalDate shortDate;
    private final BigDecimal dividendRate;
    private final BigDecimal dividendYield;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
    private final LocalDateTime exDividendDate;
    private final BigDecimal latestEPS;
    private final LocalDate latestEPSDate;
    private final BigDecimal sharesOutstanding;
    private final BigDecimal Float;
    private final BigDecimal returnOnEquity;
    private final BigDecimal consensusEPS;
    private final BigDecimal numberOfEstimates;
    private final BigDecimal EPSSurpriseDollar;
    private final BigDecimal EPSSurprisePercent;
    private final String symbol;
    private final BigDecimal EBITDA;
    private final BigDecimal revenue;
    private final BigDecimal grossProfit;
    private final BigDecimal cash;
    private final BigDecimal debt;
    private final BigDecimal ttmEPS;
    private final BigDecimal revenuePerShare;
    private final BigDecimal revenuePerEmployee;
    private final BigDecimal peRatioHigh;
    private final BigDecimal peRatioLow;
    private final BigDecimal returnOnAssets;
    private final BigDecimal returnOnCapital;
    private final BigDecimal profitMargin;
    private final BigDecimal priceToSales;
    private final BigDecimal priceToBook;
    private final BigDecimal day200MovingAvg;
    private final BigDecimal day50MovingAvg;
    private final BigDecimal institutionPercent;
    private final BigDecimal insiderPercent;
    private final BigDecimal shortRatio;
    private final BigDecimal year5ChangePercent;
    private final BigDecimal year2ChangePercent;
    private final BigDecimal year1ChangePercent;
    private final BigDecimal ytdChangePercent;
    private final BigDecimal month6ChangePercent;
    private final BigDecimal month3ChangePercent;
    private final BigDecimal month1ChangePercent;
    private final BigDecimal day5ChangePercent;
    private final BigDecimal day30ChangePercent;

    @JsonCreator
    public KeyStats(
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("marketcap") final BigDecimal marketcap,
            @JsonProperty("beta") final BigDecimal beta,
            @JsonProperty("week52high") final BigDecimal week52high,
            @JsonProperty("week52low") final BigDecimal week52low,
            @JsonProperty("week52change") final BigDecimal week52change,
            @JsonProperty("shortInterest") final BigDecimal shortInterest,
            @JsonProperty("shortDate") final LocalDate shortDate,
            @JsonProperty("dividendRate") final BigDecimal dividendRate,
            @JsonProperty("dividendYield") final BigDecimal dividendYield,
            @JsonProperty("exDividendDate") final LocalDateTime exDividendDate,
            @JsonProperty("latestEPS") final BigDecimal latestEPS,
            @JsonProperty("latestEPSDate") final LocalDate latestEPSDate,
            @JsonProperty("sharesOutstanding") final BigDecimal sharesOutstanding,
            @JsonProperty("float") final BigDecimal aFloat,
            @JsonProperty("returnOnEquity") final BigDecimal returnOnEquity,
            @JsonProperty("consensusEPS") final BigDecimal consensusEPS,
            @JsonProperty("numberOfEstimates") final BigDecimal numberOfEstimates,
            @JsonProperty("EPSSurpriseDollar") final BigDecimal EPSSurpriseDollar,
            @JsonProperty("EPSSurprisePercent") final BigDecimal EPSSurprisePercent,
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("EBITDA") final BigDecimal EBITDA,
            @JsonProperty("revenue") final BigDecimal revenue,
            @JsonProperty("grossProfit") final BigDecimal grossProfit,
            @JsonProperty("cash") final BigDecimal cash,
            @JsonProperty("debt") final BigDecimal debt,
            @JsonProperty("ttmEPS") final BigDecimal ttmEPS,
            @JsonProperty("revenuePerShare") final BigDecimal revenuePerShare,
            @JsonProperty("revenuePerEmployee") final BigDecimal revenuePerEmployee,
            @JsonProperty("peRatioHigh") final BigDecimal peRatioHigh,
            @JsonProperty("peRatioLow") final BigDecimal peRatioLow,
            @JsonProperty("returnOnAssets") final BigDecimal returnOnAssets,
            @JsonProperty("returnOnCapital") final BigDecimal returnOnCapital,
            @JsonProperty("profitMargin") final BigDecimal profitMargin,
            @JsonProperty("priceToSales") final BigDecimal priceToSales,
            @JsonProperty("priceToBook") final BigDecimal priceToBook,
            @JsonProperty("day200MovingAvg") final BigDecimal day200MovingAvg,
            @JsonProperty("day50MovingAvg") final BigDecimal day50MovingAvg,
            @JsonProperty("institutionPercent") final BigDecimal institutionPercent,
            @JsonProperty("insiderPercent") final BigDecimal insiderPercent,
            @JsonProperty("shortRatio") final BigDecimal shortRatio,
            @JsonProperty("year5ChangePercent") final BigDecimal year5ChangePercent,
            @JsonProperty("year2ChangePercent") final BigDecimal year2ChangePercent,
            @JsonProperty("year1ChangePercent") final BigDecimal year1ChangePercent,
            @JsonProperty("ytdChangePercent") final BigDecimal ytdChangePercent,
            @JsonProperty("month6ChangePercent") final BigDecimal month6ChangePercent,
            @JsonProperty("month3ChangePercent") final BigDecimal month3ChangePercent,
            @JsonProperty("month1ChangePercent") final BigDecimal month1ChangePercent,
            @JsonProperty("day5ChangePercent") final BigDecimal day5ChangePercent,
            @JsonProperty("day30ChangePercent") final BigDecimal day30ChangePercent) {
        this.companyName = companyName;
        this.marketcap = marketcap;
        this.beta = beta;
        this.week52high = week52high;
        this.week52low = week52low;
        this.week52change = week52change;
        this.shortInterest = shortInterest;
        this.shortDate = shortDate;
        this.dividendRate = dividendRate;
        this.dividendYield = dividendYield;
        this.exDividendDate = exDividendDate;
        this.latestEPS = latestEPS;
        this.latestEPSDate = latestEPSDate;
        this.sharesOutstanding = sharesOutstanding;
        this.Float = aFloat;
        this.returnOnEquity = returnOnEquity;
        this.consensusEPS = consensusEPS;
        this.numberOfEstimates = numberOfEstimates;
        this.symbol = symbol;
        this.EBITDA = EBITDA;
        this.revenue = revenue;
        this.grossProfit = grossProfit;
        this.cash = cash;
        this.debt = debt;
        this.ttmEPS = ttmEPS;
        this.revenuePerShare = revenuePerShare;
        this.revenuePerEmployee = revenuePerEmployee;
        this.peRatioHigh = peRatioHigh;
        this.peRatioLow = peRatioLow;
        this.EPSSurpriseDollar = EPSSurpriseDollar;
        this.EPSSurprisePercent = EPSSurprisePercent;
        this.returnOnAssets = returnOnAssets;
        this.returnOnCapital = returnOnCapital;
        this.profitMargin = profitMargin;
        this.priceToSales = priceToSales;
        this.priceToBook = priceToBook;
        this.day200MovingAvg = day200MovingAvg;
        this.day50MovingAvg = day50MovingAvg;
        this.institutionPercent = institutionPercent;
        this.insiderPercent = insiderPercent;
        this.shortRatio = shortRatio;
        this.year5ChangePercent = year5ChangePercent;
        this.year2ChangePercent = year2ChangePercent;
        this.year1ChangePercent = year1ChangePercent;
        this.ytdChangePercent = ytdChangePercent;
        this.month6ChangePercent = month6ChangePercent;
        this.month3ChangePercent = month3ChangePercent;
        this.month1ChangePercent = month1ChangePercent;
        this.day5ChangePercent = day5ChangePercent;
        this.day30ChangePercent = day30ChangePercent;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BigDecimal getMarketcap() {
        return marketcap;
    }

    public BigDecimal getBeta() {
        return beta;
    }

    public BigDecimal getWeek52high() {
        return week52high;
    }

    public BigDecimal getWeek52low() {
        return week52low;
    }

    public BigDecimal getWeek52change() {
        return week52change;
    }

    public BigDecimal getShortInterest() {
        return shortInterest;
    }

    public LocalDate getShortDate() {
        return shortDate;
    }

    public BigDecimal getDividendRate() {
        return dividendRate;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public LocalDateTime getExDividendDate() {
        return exDividendDate;
    }

    public BigDecimal getLatestEPS() {
        return latestEPS;
    }

    public LocalDate getLatestEPSDate() {
        return latestEPSDate;
    }

    public BigDecimal getSharesOutstanding() {
        return sharesOutstanding;
    }

    public BigDecimal getFloat() {
        return Float;
    }

    public BigDecimal getReturnOnEquity() {
        return returnOnEquity;
    }

    public BigDecimal getConsensusEPS() {
        return consensusEPS;
    }

    public BigDecimal getNumberOfEstimates() {
        return numberOfEstimates;
    }

    public BigDecimal getEPSSurpriseDollar() {
        return EPSSurpriseDollar;
    }

    public BigDecimal getEPSSurprisePercent() {
        return EPSSurprisePercent;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getEBITDA() {
        return EBITDA;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public BigDecimal getTtmEPS() {
        return ttmEPS;
    }

    public BigDecimal getRevenuePerShare() {
        return revenuePerShare;
    }

    public BigDecimal getRevenuePerEmployee() {
        return revenuePerEmployee;
    }

    public BigDecimal getPeRatioHigh() {
        return peRatioHigh;
    }

    public BigDecimal getPeRatioLow() {
        return peRatioLow;
    }

    public BigDecimal getReturnOnAssets() {
        return returnOnAssets;
    }

    public BigDecimal getReturnOnCapital() {
        return returnOnCapital;
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public BigDecimal getPriceToSales() {
        return priceToSales;
    }

    public BigDecimal getPriceToBook() {
        return priceToBook;
    }

    public BigDecimal getDay200MovingAvg() {
        return day200MovingAvg;
    }

    public BigDecimal getDay50MovingAvg() {
        return day50MovingAvg;
    }

    public BigDecimal getInstitutionPercent() {
        return institutionPercent;
    }

    public BigDecimal getInsiderPercent() {
        return insiderPercent;
    }

    public BigDecimal getShortRatio() {
        return shortRatio;
    }

    public BigDecimal getYear5ChangePercent() {
        return year5ChangePercent;
    }

    public BigDecimal getYear2ChangePercent() {
        return year2ChangePercent;
    }

    public BigDecimal getYear1ChangePercent() {
        return year1ChangePercent;
    }

    public BigDecimal getYtdChangePercent() {
        return ytdChangePercent;
    }

    public BigDecimal getMonth6ChangePercent() {
        return month6ChangePercent;
    }

    public BigDecimal getMonth3ChangePercent() {
        return month3ChangePercent;
    }

    public BigDecimal getMonth1ChangePercent() {
        return month1ChangePercent;
    }

    public BigDecimal getDay5ChangePercent() {
        return day5ChangePercent;
    }

    public BigDecimal getDay30ChangePercent() {
        return day30ChangePercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyStats keyStats = (KeyStats) o;
        return Objects.equal(companyName, keyStats.companyName) &&
                Objects.equal(marketcap, keyStats.marketcap) &&
                Objects.equal(beta, keyStats.beta) &&
                Objects.equal(week52high, keyStats.week52high) &&
                Objects.equal(week52low, keyStats.week52low) &&
                Objects.equal(week52change, keyStats.week52change) &&
                Objects.equal(shortInterest, keyStats.shortInterest) &&
                Objects.equal(shortDate, keyStats.shortDate) &&
                Objects.equal(dividendRate, keyStats.dividendRate) &&
                Objects.equal(dividendYield, keyStats.dividendYield) &&
                Objects.equal(exDividendDate, keyStats.exDividendDate) &&
                Objects.equal(latestEPS, keyStats.latestEPS) &&
                Objects.equal(latestEPSDate, keyStats.latestEPSDate) &&
                Objects.equal(sharesOutstanding, keyStats.sharesOutstanding) &&
                Objects.equal(Float, keyStats.Float) &&
                Objects.equal(returnOnEquity, keyStats.returnOnEquity) &&
                Objects.equal(consensusEPS, keyStats.consensusEPS) &&
                Objects.equal(numberOfEstimates, keyStats.numberOfEstimates) &&
                Objects.equal(EPSSurpriseDollar, keyStats.EPSSurpriseDollar) &&
                Objects.equal(EPSSurprisePercent, keyStats.EPSSurprisePercent) &&
                Objects.equal(symbol, keyStats.symbol) &&
                Objects.equal(EBITDA, keyStats.EBITDA) &&
                Objects.equal(revenue, keyStats.revenue) &&
                Objects.equal(grossProfit, keyStats.grossProfit) &&
                Objects.equal(cash, keyStats.cash) &&
                Objects.equal(debt, keyStats.debt) &&
                Objects.equal(ttmEPS, keyStats.ttmEPS) &&
                Objects.equal(revenuePerShare, keyStats.revenuePerShare) &&
                Objects.equal(revenuePerEmployee, keyStats.revenuePerEmployee) &&
                Objects.equal(peRatioHigh, keyStats.peRatioHigh) &&
                Objects.equal(peRatioLow, keyStats.peRatioLow) &&
                Objects.equal(returnOnAssets, keyStats.returnOnAssets) &&
                Objects.equal(returnOnCapital, keyStats.returnOnCapital) &&
                Objects.equal(profitMargin, keyStats.profitMargin) &&
                Objects.equal(priceToSales, keyStats.priceToSales) &&
                Objects.equal(priceToBook, keyStats.priceToBook) &&
                Objects.equal(day200MovingAvg, keyStats.day200MovingAvg) &&
                Objects.equal(day50MovingAvg, keyStats.day50MovingAvg) &&
                Objects.equal(institutionPercent, keyStats.institutionPercent) &&
                Objects.equal(insiderPercent, keyStats.insiderPercent) &&
                Objects.equal(shortRatio, keyStats.shortRatio) &&
                Objects.equal(year5ChangePercent, keyStats.year5ChangePercent) &&
                Objects.equal(year2ChangePercent, keyStats.year2ChangePercent) &&
                Objects.equal(year1ChangePercent, keyStats.year1ChangePercent) &&
                Objects.equal(ytdChangePercent, keyStats.ytdChangePercent) &&
                Objects.equal(month6ChangePercent, keyStats.month6ChangePercent) &&
                Objects.equal(month3ChangePercent, keyStats.month3ChangePercent) &&
                Objects.equal(month1ChangePercent, keyStats.month1ChangePercent) &&
                Objects.equal(day5ChangePercent, keyStats.day5ChangePercent) &&
                Objects.equal(day30ChangePercent, keyStats.day30ChangePercent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(companyName, marketcap, beta, week52high, week52low, week52change,
                shortInterest, shortDate, dividendRate, dividendYield, exDividendDate, latestEPS,
                latestEPSDate, sharesOutstanding, Float, returnOnEquity, consensusEPS, numberOfEstimates,
                EPSSurpriseDollar, EPSSurprisePercent, symbol, EBITDA, revenue, grossProfit, cash, debt,
                ttmEPS, revenuePerShare, revenuePerEmployee, peRatioHigh, peRatioLow, returnOnAssets,
                returnOnCapital, profitMargin, priceToSales, priceToBook, day200MovingAvg, day50MovingAvg,
                institutionPercent, insiderPercent, shortRatio, year5ChangePercent, year2ChangePercent,
                year1ChangePercent, ytdChangePercent, month6ChangePercent, month3ChangePercent,
                month1ChangePercent, day5ChangePercent, day30ChangePercent);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("companyName", companyName)
                .add("marketcap", marketcap)
                .add("beta", beta)
                .add("week52high", week52high)
                .add("week52low", week52low)
                .add("week52change", week52change)
                .add("shortInterest", shortInterest)
                .add("shortDate", shortDate)
                .add("dividendRate", dividendRate)
                .add("dividendYield", dividendYield)
                .add("exDividendDate", exDividendDate)
                .add("latestEPS", latestEPS)
                .add("latestEPSDate", latestEPSDate)
                .add("sharesOutstanding", sharesOutstanding)
                .add("Float", Float)
                .add("returnOnEquity", returnOnEquity)
                .add("consensusEPS", consensusEPS)
                .add("numberOfEstimates", numberOfEstimates)
                .add("EPSSurpriseDollar", EPSSurpriseDollar)
                .add("EPSSurprisePercent", EPSSurprisePercent)
                .add("symbol", symbol)
                .add("EBITDA", EBITDA)
                .add("revenue", revenue)
                .add("grossProfit", grossProfit)
                .add("cash", cash)
                .add("debt", debt)
                .add("ttmEPS", ttmEPS)
                .add("revenuePerShare", revenuePerShare)
                .add("revenuePerEmployee", revenuePerEmployee)
                .add("peRatioHigh", peRatioHigh)
                .add("peRatioLow", peRatioLow)
                .add("returnOnAssets", returnOnAssets)
                .add("returnOnCapital", returnOnCapital)
                .add("profitMargin", profitMargin)
                .add("priceToSales", priceToSales)
                .add("priceToBook", priceToBook)
                .add("day200MovingAvg", day200MovingAvg)
                .add("day50MovingAvg", day50MovingAvg)
                .add("institutionPercent", institutionPercent)
                .add("insiderPercent", insiderPercent)
                .add("shortRatio", shortRatio)
                .add("year5ChangePercent", year5ChangePercent)
                .add("year2ChangePercent", year2ChangePercent)
                .add("year1ChangePercent", year1ChangePercent)
                .add("ytdChangePercent", ytdChangePercent)
                .add("month6ChangePercent", month6ChangePercent)
                .add("month3ChangePercent", month3ChangePercent)
                .add("month1ChangePercent", month1ChangePercent)
                .add("day5ChangePercent", day5ChangePercent)
                .add("day30ChangePercent", day30ChangePercent)
                .toString();
    }
}
