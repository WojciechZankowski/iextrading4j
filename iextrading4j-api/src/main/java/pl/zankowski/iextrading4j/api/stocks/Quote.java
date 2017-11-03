package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class Quote {

    private final String symbol;
    private final String companyName;
    private final String primaryExchange;
    private final String sector;
    private final String calculationPrice;
    private final double open;
    private final long openTime;
    private final double close;
    private final long closeTime;
    private final double latestPrice;
    private final String latestSource;
    private final String latestTime;
    private final long latestUpdate;
    private final long latestVolume;
    private final double iexRealtimePrice;
    private final long iexRealtimeSize;
    private final long iexLastUpdated;
    private final double delayedPrice;
    private final long delayedPriceTime;
    private final double previousClose;
    private final double change;
    private final double changePercent;
    private final double iexMarketPercent;
    private final long iexVolume;
    private final double avgTotalVolume;
    private final double iexBidPrice;
    private final long iexBidSize;
    private final double iexAskPrice;
    private final long iexAskSize;
    private final double marketCap;
    private final double peRatio;
    private final double week52High;
    private final double week52Low;
    private final double ytdChange;

    @JsonCreator
    public Quote(@JsonProperty("symbol") String symbol,
                 @JsonProperty("companyName") String companyName,
                 @JsonProperty("primaryExchange") String primaryExchange,
                 @JsonProperty("sector") String sector,
                 @JsonProperty("calculationPrice") String calculationPrice,
                 @JsonProperty("open") double open,
                 @JsonProperty("openTime") long openTime,
                 @JsonProperty("close") double close,
                 @JsonProperty("closeTime") long closeTime,
                 @JsonProperty("latestPrice") double latestPrice,
                 @JsonProperty("latestSource") String latestSource,
                 @JsonProperty("latestTime") String latestTime,
                 @JsonProperty("latestUpdate") long latestUpdate,
                 @JsonProperty("latestVolume") long latestVolume,
                 @JsonProperty("iexRealtimePrice") double iexRealtimePrice,
                 @JsonProperty("iexRealtimeSize") long iexRealtimeSize,
                 @JsonProperty("iexLastUpdated") long iexLastUpdated,
                 @JsonProperty("delayedPrice") double delayedPrice,
                 @JsonProperty("delayedPriceTime") long delayedPriceTime,
                 @JsonProperty("previousClose") double previousClose,
                 @JsonProperty("change") double change,
                 @JsonProperty("changePercent") double changePercent,
                 @JsonProperty("iexMarketPercent") double iexMarketPercent,
                 @JsonProperty("iexVolume") long iexVolume,
                 @JsonProperty("avgTotalVolume") double avgTotalVolume,
                 @JsonProperty("iexBidPrice") double iexBidPrice,
                 @JsonProperty("iexBidSize") long iexBidSize,
                 @JsonProperty("iexAskPrice") double iexAskPrice,
                 @JsonProperty("iexAskSize") long iexAskSize,
                 @JsonProperty("marketCap") double marketCap,
                 @JsonProperty("peRatio") double peRatio,
                 @JsonProperty("week52High") double week52High,
                 @JsonProperty("week52Low") double week52Low,
                 @JsonProperty("ytdChange") double ytdChange)
    {
        this.symbol = symbol;
        this.companyName = companyName;
        this.primaryExchange = primaryExchange;
        this.sector = sector;
        this.calculationPrice = calculationPrice;
        this.open = open;
        this.openTime = openTime;
        this.close = close;
        this.closeTime = closeTime;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexLastUpdated = iexLastUpdated;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.previousClose = previousClose;
        this.change = change;
        this.changePercent = changePercent;
        this.iexMarketPercent = iexMarketPercent;
        this.iexVolume = iexVolume;
        this.avgTotalVolume = avgTotalVolume;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.marketCap = marketCap;
        this.peRatio = peRatio;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public String getSector() {
        return sector;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public double getOpen() { return open; }
    public long getOpenTime() { return openTime; }

    public double getClose() { return close; }
    public long getCloseTime() { return closeTime; }
    public double getLatestPrice() {
        return latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }
    public long getLatestUpdate() { return latestUpdate; }

    public long getLatestVolume() {
        return latestVolume;
    }

    public double getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public long getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public long getIexLastUpdated() {
        return iexLastUpdated;
    }

    public double getDelayedPrice() {
        return delayedPrice;
    }

    public long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public double getChange() {
        return change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public double getIexMarketPercent() {
        return iexMarketPercent;
    }

    public long getIexVolume() {
        return iexVolume;
    }

    public double getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public double getIexBidPrice() {
        return iexBidPrice;
    }

    public long getIexBidSize() {
        return iexBidSize;
    }

    public double getIexAskPrice() {
        return iexAskPrice;
    }

    public long getIexAskSize() {
        return iexAskSize;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public double getPeRatio() {
        return peRatio;
    }

    public double getWeek52High() {
        return week52High;
    }

    public double getWeek52Low() {
        return week52Low;
    }
    public double getYtdChange() { return ytdChange; }

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

        final Quote quote = (Quote) o;

        if ( Double.compare( quote.open, open ) != 0 )
        {
            return false;
        }
        if ( openTime != quote.openTime )
        {
            return false;
        }
        if ( Double.compare( quote.close, close ) != 0 )
        {
            return false;
        }
        if ( closeTime != quote.closeTime )
        {
            return false;
        }
        if ( Double.compare( quote.latestPrice, latestPrice ) != 0 )
        {
            return false;
        }
        if ( latestUpdate != quote.latestUpdate )
        {
            return false;
        }
        if ( latestVolume != quote.latestVolume )
        {
            return false;
        }
        if ( Double.compare( quote.iexRealtimePrice, iexRealtimePrice ) != 0 )
        {
            return false;
        }
        if ( iexRealtimeSize != quote.iexRealtimeSize )
        {
            return false;
        }
        if ( iexLastUpdated != quote.iexLastUpdated )
        {
            return false;
        }
        if ( Double.compare( quote.delayedPrice, delayedPrice ) != 0 )
        {
            return false;
        }
        if ( delayedPriceTime != quote.delayedPriceTime )
        {
            return false;
        }
        if ( Double.compare( quote.previousClose, previousClose ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.change, change ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.changePercent, changePercent ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.iexMarketPercent, iexMarketPercent ) != 0 )
        {
            return false;
        }
        if ( iexVolume != quote.iexVolume )
        {
            return false;
        }
        if ( Double.compare( quote.avgTotalVolume, avgTotalVolume ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.iexBidPrice, iexBidPrice ) != 0 )
        {
            return false;
        }
        if ( iexBidSize != quote.iexBidSize )
        {
            return false;
        }
        if ( Double.compare( quote.iexAskPrice, iexAskPrice ) != 0 )
        {
            return false;
        }
        if ( iexAskSize != quote.iexAskSize )
        {
            return false;
        }
        if ( Double.compare( quote.marketCap, marketCap ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.peRatio, peRatio ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.week52High, week52High ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.week52Low, week52Low ) != 0 )
        {
            return false;
        }
        if ( Double.compare( quote.ytdChange, ytdChange ) != 0 )
        {
            return false;
        }
        if ( symbol != null
             ? !symbol.equals( quote.symbol )
             : quote.symbol != null )
        {
            return false;
        }
        if ( companyName != null
             ? !companyName.equals( quote.companyName )
             : quote.companyName != null )
        {
            return false;
        }
        if ( primaryExchange != null
             ? !primaryExchange.equals( quote.primaryExchange )
             : quote.primaryExchange != null )
        {
            return false;
        }
        if ( sector != null
             ? !sector.equals( quote.sector )
             : quote.sector != null )
        {
            return false;
        }
        if ( calculationPrice != null
             ? !calculationPrice.equals( quote.calculationPrice )
             : quote.calculationPrice != null )
        {
            return false;
        }
        if ( latestSource != null
             ? !latestSource.equals( quote.latestSource )
             : quote.latestSource != null )
        {
            return false;
        }
        return latestTime != null
               ? latestTime.equals( quote.latestTime )
               : quote.latestTime == null;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = symbol != null
                 ? symbol.hashCode()
                 : 0;
        result = 31 * result + (companyName != null
                                ? companyName.hashCode()
                                : 0);
        result = 31 * result + (primaryExchange != null
                                ? primaryExchange.hashCode()
                                : 0);
        result = 31 * result + (sector != null
                                ? sector.hashCode()
                                : 0);
        result = 31 * result + (calculationPrice != null
                                ? calculationPrice.hashCode()
                                : 0);
        temp = Double.doubleToLongBits( open );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (openTime ^ (openTime >>> 32));
        temp = Double.doubleToLongBits( close );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (closeTime ^ (closeTime >>> 32));
        temp = Double.doubleToLongBits( latestPrice );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (latestSource != null
                                ? latestSource.hashCode()
                                : 0);
        result = 31 * result + (latestTime != null
                                ? latestTime.hashCode()
                                : 0);
        result = 31 * result + (int) (latestUpdate ^ (latestUpdate >>> 32));
        result = 31 * result + (int) (latestVolume ^ (latestVolume >>> 32));
        temp = Double.doubleToLongBits( iexRealtimePrice );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (iexRealtimeSize ^ (iexRealtimeSize >>> 32));
        result = 31 * result + (int) (iexLastUpdated ^ (iexLastUpdated >>> 32));
        temp = Double.doubleToLongBits( delayedPrice );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (delayedPriceTime ^ (delayedPriceTime >>> 32));
        temp = Double.doubleToLongBits( previousClose );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( change );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( changePercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( iexMarketPercent );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (iexVolume ^ (iexVolume >>> 32));
        temp = Double.doubleToLongBits( avgTotalVolume );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( iexBidPrice );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (iexBidSize ^ (iexBidSize >>> 32));
        temp = Double.doubleToLongBits( iexAskPrice );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (iexAskSize ^ (iexAskSize >>> 32));
        temp = Double.doubleToLongBits( marketCap );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( peRatio );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( week52High );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( week52Low );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( ytdChange );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Quote{" );
        sb.append( "symbol='" ).append( symbol ).append( '\'' );
        sb.append( ", companyName='" ).append( companyName ).append( '\'' );
        sb.append( ", primaryExchange='" ).append( primaryExchange ).append( '\'' );
        sb.append( ", sector='" ).append( sector ).append( '\'' );
        sb.append( ", calculationPrice='" ).append( calculationPrice ).append( '\'' );
        sb.append( ", open=" ).append( open );
        sb.append( ", openTime=" ).append( openTime );
        sb.append( ", close=" ).append( close );
        sb.append( ", closeTime=" ).append( closeTime );
        sb.append( ", latestPrice=" ).append( latestPrice );
        sb.append( ", latestSource='" ).append( latestSource ).append( '\'' );
        sb.append( ", latestTime='" ).append( latestTime ).append( '\'' );
        sb.append( ", latestUpdate=" ).append( latestUpdate );
        sb.append( ", latestVolume=" ).append( latestVolume );
        sb.append( ", iexRealtimePrice=" ).append( iexRealtimePrice );
        sb.append( ", iexRealtimeSize=" ).append( iexRealtimeSize );
        sb.append( ", iexLastUpdated=" ).append( iexLastUpdated );
        sb.append( ", delayedPrice=" ).append( delayedPrice );
        sb.append( ", delayedPriceTime=" ).append( delayedPriceTime );
        sb.append( ", previousClose=" ).append( previousClose );
        sb.append( ", change=" ).append( change );
        sb.append( ", changePercent=" ).append( changePercent );
        sb.append( ", iexMarketPercent=" ).append( iexMarketPercent );
        sb.append( ", iexVolume=" ).append( iexVolume );
        sb.append( ", avgTotalVolume=" ).append( avgTotalVolume );
        sb.append( ", iexBidPrice=" ).append( iexBidPrice );
        sb.append( ", iexBidSize=" ).append( iexBidSize );
        sb.append( ", iexAskPrice=" ).append( iexAskPrice );
        sb.append( ", iexAskSize=" ).append( iexAskSize );
        sb.append( ", marketCap=" ).append( marketCap );
        sb.append( ", peRatio=" ).append( peRatio );
        sb.append( ", week52High=" ).append( week52High );
        sb.append( ", week52Low=" ).append( week52Low );
        sb.append( ", ytdChange=" ).append( ytdChange );
        sb.append( '}' );
        return sb.toString();
    }
}
