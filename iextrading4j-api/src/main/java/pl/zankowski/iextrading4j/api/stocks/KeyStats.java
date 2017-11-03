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
    private final double EPSSurpriseDollar;
    private final double EPSSurprisePercent;
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
    private final double year5ChangePercent;
    private final double year2ChangePercent;
    private final double year1ChangePercent;
    private final double ytdChangePercent;
    private final double month6ChangePercent;
    private final double month3ChangePercent;
    private final double month1ChangePercent;
    private final double day5ChangePercent;

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
                    @JsonProperty("EPSSurpriseDollar") double EPSSurpriseDollar,
                    @JsonProperty("EPSSurprisePercent") double EPSSurprisePercent,
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
                    @JsonProperty("returnOnAssets") double returnOnAssets,
                    @JsonProperty("returnOnCapital") double returnOnCapital,
                    @JsonProperty("profitMargin") double profitMargin,
                    @JsonProperty("priceToSales") double priceToSales,
                    @JsonProperty("priceToBook") double priceToBook,
                    @JsonProperty("day200MovingAvg") double day200MovingAvg,
                    @JsonProperty("day50MovingAvg") double day50MovingAvg,
                    @JsonProperty("institutionPercent") double institutionPercent,
                    @JsonProperty("insiderPercent") double insiderPercent,
                    @JsonProperty("shortRatio") double shortRatio,
                    @JsonProperty("year5ChangePercent") double year5ChangePercent,
                    @JsonProperty("year2ChangePercent") double year2ChangePercent,
                    @JsonProperty("year1ChangePercent") double year1ChangePercent,
                    @JsonProperty("ytdChangePercent") double ytdChangePercent,
                    @JsonProperty("month6ChangePercent") double month6ChangePercent,
                    @JsonProperty("month3ChangePercent") double month3ChangePercent,
                    @JsonProperty("month1ChangePercent") double month1ChangePercent,
                    @JsonProperty("day5ChangePercent") double day5ChangePercent )
    {
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
    }


    @Override
    public boolean equals( final Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        final KeyStats keyStats = (KeyStats) o;

        if ( Double.compare( keyStats.marketcap, marketcap ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.beta, beta ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.week52high, week52high ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.week52low, week52low ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.week52change, week52change ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.shortInterest, shortInterest ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.dividendRate, dividendRate ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.dividendYield, dividendYield ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.latestEPS, latestEPS ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.sharesOutstanding, sharesOutstanding ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.Float, Float ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.returnOnEquity, returnOnEquity ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.consensusEPS, consensusEPS ) != 0 )
        {
            return false;
        }
        if ( numberOfEstimates != keyStats.numberOfEstimates )
        {
            return false;
        }
        if ( Double.compare( keyStats.EPSSurpriseDollar, EPSSurpriseDollar ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.EPSSurprisePercent, EPSSurprisePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.EBITDA, EBITDA ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.revenue, revenue ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.grossProfit, grossProfit ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.cash, cash ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.debt, debt ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.ttmEPS, ttmEPS ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.revenuePerShare, revenuePerShare ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.revenuePerEmployee, revenuePerEmployee ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.peRatioHigh, peRatioHigh ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.peRatioLow, peRatioLow ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.returnOnAssets, returnOnAssets ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.returnOnCapital, returnOnCapital ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.profitMargin, profitMargin ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.priceToSales, priceToSales ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.priceToBook, priceToBook ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.day200MovingAvg, day200MovingAvg ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.day50MovingAvg, day50MovingAvg ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.institutionPercent, institutionPercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.insiderPercent, insiderPercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.shortRatio, shortRatio ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.year5ChangePercent, year5ChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.year2ChangePercent, year2ChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.year1ChangePercent, year1ChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.ytdChangePercent, ytdChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.month6ChangePercent, month6ChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.month3ChangePercent, month3ChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.month1ChangePercent, month1ChangePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( keyStats.day5ChangePercent, day5ChangePercent ) != 0 )
        {
            return false;
        }
        if ( companyName != null
             ? !companyName.equals( keyStats.companyName )
             : keyStats.companyName != null )
        {
            return false;
        }
        if ( shortDate != null
             ? !shortDate.equals( keyStats.shortDate )
             : keyStats.shortDate != null )
        {
            return false;
        }
        if ( exDividendDate != null
             ? !exDividendDate.equals( keyStats.exDividendDate )
             : keyStats.exDividendDate != null )
        {
            return false;
        }
        if ( latestEPSDate != null
             ? !latestEPSDate.equals( keyStats.latestEPSDate )
             : keyStats.latestEPSDate != null )
        {
            return false;
        }
        return symbol != null
               ? symbol.equals( keyStats.symbol )
               : keyStats.symbol == null;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = companyName != null
                 ? companyName.hashCode()
                 : 0;
        temp = Double.doubleToLongBits( marketcap );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( beta );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( week52high );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( week52low );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( week52change );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( shortInterest );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (shortDate != null
                                ? shortDate.hashCode()
                                : 0);
        temp = Double.doubleToLongBits( dividendRate );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( dividendYield );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (exDividendDate != null
                                ? exDividendDate.hashCode()
                                : 0);
        temp = Double.doubleToLongBits( latestEPS );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (latestEPSDate != null
                                ? latestEPSDate.hashCode()
                                : 0);
        temp = Double.doubleToLongBits( sharesOutstanding );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( Float );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( returnOnEquity );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( consensusEPS );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfEstimates;
        temp = Double.doubleToLongBits( EPSSurpriseDollar );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( EPSSurprisePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (symbol != null
                                ? symbol.hashCode()
                                : 0);
        temp = Double.doubleToLongBits( EBITDA );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( revenue );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( grossProfit );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( cash );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( debt );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( ttmEPS );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( revenuePerShare );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( revenuePerEmployee );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( peRatioHigh );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( peRatioLow );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( returnOnAssets );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( returnOnCapital );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( profitMargin );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( priceToSales );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( priceToBook );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( day200MovingAvg );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( day50MovingAvg );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( institutionPercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( insiderPercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( shortRatio );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( year5ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( year2ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( year1ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( ytdChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( month6ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( month3ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( month1ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( day5ChangePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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

    public double getYear5ChangePercent()
    {
        return year5ChangePercent;
    }

    public double getYear2ChangePercent()
    {
        return year2ChangePercent;
    }

    public double getYear1ChangePercent()
    {
        return year1ChangePercent;
    }

    public double getYtdChangePercent()
    {
        return ytdChangePercent;
    }

    public double getMonth6ChangePercent()
    {
        return month6ChangePercent;
    }

    public double getMonth3ChangePercent()
    {
        return month3ChangePercent;
    }

    public double getMonth1ChangePercent()
    {
        return month1ChangePercent;
    }

    public double getDay5ChangePercent()
    {
        return day5ChangePercent;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "KeyStats{" );
        sb.append( "companyName='" ).append( companyName ).append( '\'' );
        sb.append( ", marketcap=" ).append( marketcap );
        sb.append( ", beta=" ).append( beta );
        sb.append( ", week52high=" ).append( week52high );
        sb.append( ", week52low=" ).append( week52low );
        sb.append( ", week52change=" ).append( week52change );
        sb.append( ", shortInterest=" ).append( shortInterest );
        sb.append( ", shortDate='" ).append( shortDate ).append( '\'' );
        sb.append( ", dividendRate=" ).append( dividendRate );
        sb.append( ", dividendYield=" ).append( dividendYield );
        sb.append( ", exDividendDate='" ).append( exDividendDate ).append( '\'' );
        sb.append( ", latestEPS=" ).append( latestEPS );
        sb.append( ", latestEPSDate='" ).append( latestEPSDate ).append( '\'' );
        sb.append( ", sharesOutstanding=" ).append( sharesOutstanding );
        sb.append( ", Float=" ).append( Float );
        sb.append( ", returnOnEquity=" ).append( returnOnEquity );
        sb.append( ", consensusEPS=" ).append( consensusEPS );
        sb.append( ", numberOfEstimates=" ).append( numberOfEstimates );
        sb.append( ", EPSSurpriseDollar=" ).append( EPSSurpriseDollar );
        sb.append( ", EPSSurprisePercent=" ).append( EPSSurprisePercent );
        sb.append( ", symbol='" ).append( symbol ).append( '\'' );
        sb.append( ", EBITDA=" ).append( EBITDA );
        sb.append( ", revenue=" ).append( revenue );
        sb.append( ", grossProfit=" ).append( grossProfit );
        sb.append( ", cash=" ).append( cash );
        sb.append( ", debt=" ).append( debt );
        sb.append( ", ttmEPS=" ).append( ttmEPS );
        sb.append( ", revenuePerShare=" ).append( revenuePerShare );
        sb.append( ", revenuePerEmployee=" ).append( revenuePerEmployee );
        sb.append( ", peRatioHigh=" ).append( peRatioHigh );
        sb.append( ", peRatioLow=" ).append( peRatioLow );
        sb.append( ", returnOnAssets=" ).append( returnOnAssets );
        sb.append( ", returnOnCapital=" ).append( returnOnCapital );
        sb.append( ", profitMargin=" ).append( profitMargin );
        sb.append( ", priceToSales=" ).append( priceToSales );
        sb.append( ", priceToBook=" ).append( priceToBook );
        sb.append( ", day200MovingAvg=" ).append( day200MovingAvg );
        sb.append( ", day50MovingAvg=" ).append( day50MovingAvg );
        sb.append( ", institutionPercent=" ).append( institutionPercent );
        sb.append( ", insiderPercent=" ).append( insiderPercent );
        sb.append( ", shortRatio=" ).append( shortRatio );
        sb.append( ", year5ChangePercent=" ).append( year5ChangePercent );
        sb.append( ", year2ChangePercent=" ).append( year2ChangePercent );
        sb.append( ", year1ChangePercent=" ).append( year1ChangePercent );
        sb.append( ", ytdChangePercent=" ).append( ytdChangePercent );
        sb.append( ", month6ChangePercent=" ).append( month6ChangePercent );
        sb.append( ", month3ChangePercent=" ).append( month3ChangePercent );
        sb.append( ", month1ChangePercent=" ).append( month1ChangePercent );
        sb.append( ", day5ChangePercent=" ).append( day5ChangePercent );
        sb.append( '}' );
        return sb.toString();
    }

}
