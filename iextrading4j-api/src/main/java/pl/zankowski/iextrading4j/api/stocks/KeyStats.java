package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class KeyStats {

    private final String companyName;
    private final double marketcap;
    private final double beta;
    private final double week52high;
    private final double week52low;
    private final double week52change;
    private final double shortInterest;
    private final String shortDate;
    private final double dividendRate;
    private final double dividendYield;
    private final String exDividendDate;
    private final double latestEPS;
    private final String latestEPSDate;
    private final double sharesOutstanding;
    private final double Float;
    private final double returnOnEquity;
    private final double consensusEPS;
    private final int numberOfEstimates;
    private final String symbol;
    private final double EBITDA;
    private final double revenue;
    private final double grossProfit;
    private final double cash;
    private final double debt;
    private final double ttmEPS;
    private final double revenuePerShare;
    private final double revenuePerEmployee;
    private final double peRatioHigh;
    private final double peRatioLow;
    private final double EPSSurpriseDollar;
    private final double EPSSurprisePercent;
    private final double returnOnAssets;
    private final double returnOnCapital;
    private final double profitMargin;
    private final double priceToSales;
    private final double priceToBook;
    private final double day200MovingAvg;
    private final double day50MovingAvg;
    private final double institutionPercent;
    private final double insiderPercent;
    private final double shortRatio;

    @JsonCreator
    public KeyStats(@JsonProperty("companyName") String companyName,
                    @JsonProperty("marketcap") double marketcap,
                    @JsonProperty("beta") double beta,
                    @JsonProperty("week52high") double week52high,
                    @JsonProperty("week52low") double week52low,
                    @JsonProperty("week52change") double week52change,
                    @JsonProperty("shortInterest") double shortInterest,
                    @JsonProperty("shortDate") String shortDate,
                    @JsonProperty("dividendRate") double dividendRate,
                    @JsonProperty("dividendYield") double dividendYield,
                    @JsonProperty("exDividendDate") String exDividendDate,
                    @JsonProperty("latestEPS") double latestEPS,
                    @JsonProperty("latestEPSDate") String latestEPSDate,
                    @JsonProperty("sharesOutstanding") double sharesOutstanding,
                    @JsonProperty("float") double aFloat,
                    @JsonProperty("returnOnEquity") double returnOnEquity,
                    @JsonProperty("consensusEPS") double consensusEPS,
                    @JsonProperty("numberOfEstimates") int numberOfEstimates,
                    @JsonProperty("symbol") String symbol,
                    @JsonProperty("EBITDA") double EBITDA,
                    @JsonProperty("revenue") double revenue,
                    @JsonProperty("grossProfit") double grossProfit,
                    @JsonProperty("cash") double cash,
                    @JsonProperty("debt") double debt,
                    @JsonProperty("ttmEPS") double ttmEPS,
                    @JsonProperty("revenuePerShare") double revenuePerShare,
                    @JsonProperty("revenuePerEmployee") double revenuePerEmployee,
                    @JsonProperty("peRatioHigh") double peRatioHigh,
                    @JsonProperty("peRatioLow") double peRatioLow,
                    @JsonProperty("EPSSurpriseDollar") double EPSSurpriseDollar,
                    @JsonProperty("EPSSurprisePercent") double EPSSurprisePercent,
                    @JsonProperty("returnOnAssets") double returnOnAssets,
                    @JsonProperty("returnOnCapital") double returnOnCapital,
                    @JsonProperty("profitMargin") double profitMargin,
                    @JsonProperty("priceToSales") double priceToSales,
                    @JsonProperty("priceToBook") double priceToBook,
                    @JsonProperty("day200MovingAvg") double day200MovingAvg,
                    @JsonProperty("day50MovingAvg") double day50MovingAvg,
                    @JsonProperty("institutionPercent") double institutionPercent,
                    @JsonProperty("insiderPercent") double insiderPercent,
                    @JsonProperty("shortRatio") double shortRatio) {
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
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getMarketcap() {
        return marketcap;
    }

    public double getBeta() {
        return beta;
    }

    public double getWeek52high() {
        return week52high;
    }

    public double getWeek52low() {
        return week52low;
    }

    public double getWeek52change() {
        return week52change;
    }

    public double getShortInterest() {
        return shortInterest;
    }

    public String getShortDate() {
        return shortDate;
    }

    public double getDividendRate() {
        return dividendRate;
    }

    public double getDividendYield() {
        return dividendYield;
    }

    public String getExDividendDate() {
        return exDividendDate;
    }

    public double getLatestEPS() {
        return latestEPS;
    }

    public String getLatestEPSDate() {
        return latestEPSDate;
    }

    public double getSharesOutstanding() {
        return sharesOutstanding;
    }

    public double getFloat() {
        return Float;
    }

    public double getReturnOnEquity() {
        return returnOnEquity;
    }

    public double getConsensusEPS() {
        return consensusEPS;
    }

    public int getNumberOfEstimates() {
        return numberOfEstimates;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getEBITDA() {
        return EBITDA;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getGrossProfit() {
        return grossProfit;
    }

    public double getCash() {
        return cash;
    }

    public double getDebt() {
        return debt;
    }

    public double getTtmEPS() {
        return ttmEPS;
    }

    public double getRevenuePerShare() {
        return revenuePerShare;
    }

    public double getRevenuePerEmployee() {
        return revenuePerEmployee;
    }

    public double getPeRatioHigh() {
        return peRatioHigh;
    }

    public double getPeRatioLow() {
        return peRatioLow;
    }

    public double getEPSSurpriseDollar() {
        return EPSSurpriseDollar;
    }

    public double getEPSSurprisePercent() {
        return EPSSurprisePercent;
    }

    public double getReturnOnAssets() {
        return returnOnAssets;
    }

    public double getReturnOnCapital() {
        return returnOnCapital;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public double getPriceToSales() {
        return priceToSales;
    }

    public double getPriceToBook() {
        return priceToBook;
    }

    public double getDay200MovingAvg() {
        return day200MovingAvg;
    }

    public double getDay50MovingAvg() {
        return day50MovingAvg;
    }

    public double getInstitutionPercent() {
        return institutionPercent;
    }

    public double getInsiderPercent() {
        return insiderPercent;
    }

    public double getShortRatio() {
        return shortRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyStats keyStats = (KeyStats) o;

        if (Double.compare(keyStats.marketcap, marketcap) != 0) return false;
        if (Double.compare(keyStats.beta, beta) != 0) return false;
        if (Double.compare(keyStats.week52high, week52high) != 0) return false;
        if (Double.compare(keyStats.week52low, week52low) != 0) return false;
        if (Double.compare(keyStats.week52change, week52change) != 0) return false;
        if (Double.compare(keyStats.shortInterest, shortInterest) != 0) return false;
        if (Double.compare(keyStats.dividendRate, dividendRate) != 0) return false;
        if (Double.compare(keyStats.dividendYield, dividendYield) != 0) return false;
        if (Double.compare(keyStats.latestEPS, latestEPS) != 0) return false;
        if (Double.compare(keyStats.sharesOutstanding, sharesOutstanding) != 0) return false;
        if (Double.compare(keyStats.Float, Float) != 0) return false;
        if (Double.compare(keyStats.returnOnEquity, returnOnEquity) != 0) return false;
        if (Double.compare(keyStats.consensusEPS, consensusEPS) != 0) return false;
        if (numberOfEstimates != keyStats.numberOfEstimates) return false;
        if (Double.compare(keyStats.EBITDA, EBITDA) != 0) return false;
        if (Double.compare(keyStats.revenue, revenue) != 0) return false;
        if (Double.compare(keyStats.grossProfit, grossProfit) != 0) return false;
        if (Double.compare(keyStats.cash, cash) != 0) return false;
        if (Double.compare(keyStats.debt, debt) != 0) return false;
        if (Double.compare(keyStats.ttmEPS, ttmEPS) != 0) return false;
        if (Double.compare(keyStats.revenuePerShare, revenuePerShare) != 0) return false;
        if (Double.compare(keyStats.revenuePerEmployee, revenuePerEmployee) != 0) return false;
        if (Double.compare(keyStats.peRatioHigh, peRatioHigh) != 0) return false;
        if (Double.compare(keyStats.peRatioLow, peRatioLow) != 0) return false;
        if (Double.compare(keyStats.EPSSurpriseDollar, EPSSurpriseDollar) != 0) return false;
        if (Double.compare(keyStats.EPSSurprisePercent, EPSSurprisePercent) != 0) return false;
        if (Double.compare(keyStats.returnOnAssets, returnOnAssets) != 0) return false;
        if (Double.compare(keyStats.returnOnCapital, returnOnCapital) != 0) return false;
        if (Double.compare(keyStats.profitMargin, profitMargin) != 0) return false;
        if (Double.compare(keyStats.priceToSales, priceToSales) != 0) return false;
        if (Double.compare(keyStats.priceToBook, priceToBook) != 0) return false;
        if (Double.compare(keyStats.day200MovingAvg, day200MovingAvg) != 0) return false;
        if (Double.compare(keyStats.day50MovingAvg, day50MovingAvg) != 0) return false;
        if (Double.compare(keyStats.institutionPercent, institutionPercent) != 0) return false;
        if (Double.compare(keyStats.insiderPercent, insiderPercent) != 0) return false;
        if (Double.compare(keyStats.shortRatio, shortRatio) != 0) return false;
        if (companyName != null ? !companyName.equals(keyStats.companyName) : keyStats.companyName != null)
            return false;
        if (shortDate != null ? !shortDate.equals(keyStats.shortDate) : keyStats.shortDate != null) return false;
        if (exDividendDate != null ? !exDividendDate.equals(keyStats.exDividendDate) : keyStats.exDividendDate != null)
            return false;
        if (latestEPSDate != null ? !latestEPSDate.equals(keyStats.latestEPSDate) : keyStats.latestEPSDate != null)
            return false;
        return symbol != null ? symbol.equals(keyStats.symbol) : keyStats.symbol == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = companyName != null ? companyName.hashCode() : 0;
        temp = Double.doubleToLongBits(marketcap);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(beta);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(week52high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(week52low);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(week52change);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shortInterest);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (shortDate != null ? shortDate.hashCode() : 0);
        temp = Double.doubleToLongBits(dividendRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dividendYield);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (exDividendDate != null ? exDividendDate.hashCode() : 0);
        temp = Double.doubleToLongBits(latestEPS);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (latestEPSDate != null ? latestEPSDate.hashCode() : 0);
        temp = Double.doubleToLongBits(sharesOutstanding);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Float);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(returnOnEquity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(consensusEPS);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfEstimates;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        temp = Double.doubleToLongBits(EBITDA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(revenue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(grossProfit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cash);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(debt);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ttmEPS);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(revenuePerShare);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(revenuePerEmployee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peRatioHigh);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peRatioLow);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(EPSSurpriseDollar);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(EPSSurprisePercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(returnOnAssets);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(returnOnCapital);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(profitMargin);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceToSales);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceToBook);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(day200MovingAvg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(day50MovingAvg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(institutionPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(insiderPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shortRatio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "KeyStats{" +
                "companyName='" + companyName + '\'' +
                ", marketcap=" + marketcap +
                ", beta=" + beta +
                ", week52high=" + week52high +
                ", week52low=" + week52low +
                ", week52change=" + week52change +
                ", shortInterest=" + shortInterest +
                ", shortDate='" + shortDate + '\'' +
                ", dividendRate=" + dividendRate +
                ", dividendYield=" + dividendYield +
                ", exDividendDate='" + exDividendDate + '\'' +
                ", latestEPS=" + latestEPS +
                ", latestEPSDate='" + latestEPSDate + '\'' +
                ", sharesOutstanding=" + sharesOutstanding +
                ", Float=" + Float +
                ", returnOnEquity=" + returnOnEquity +
                ", consensusEPS=" + consensusEPS +
                ", numberOfEstimates=" + numberOfEstimates +
                ", symbol='" + symbol + '\'' +
                ", EBITDA=" + EBITDA +
                ", revenue=" + revenue +
                ", grossProfit=" + grossProfit +
                ", cash=" + cash +
                ", debt=" + debt +
                ", ttmEPS=" + ttmEPS +
                ", revenuePerShare=" + revenuePerShare +
                ", revenuePerEmployee=" + revenuePerEmployee +
                ", peRatioHigh=" + peRatioHigh +
                ", peRatioLow=" + peRatioLow +
                ", EPSSurpriseDollar=" + EPSSurpriseDollar +
                ", EPSSurprisePercent=" + EPSSurprisePercent +
                ", returnOnAssets=" + returnOnAssets +
                ", returnOnCapital=" + returnOnCapital +
                ", profitMargin=" + profitMargin +
                ", priceToSales=" + priceToSales +
                ", priceToBook=" + priceToBook +
                ", day200MovingAvg=" + day200MovingAvg +
                ", day50MovingAvg=" + day50MovingAvg +
                ", institutionPercent=" + institutionPercent +
                ", insiderPercent=" + insiderPercent +
                ", shortRatio=" + shortRatio +
                '}';
    }

}
