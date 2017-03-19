package pl.zankowski.iextrading4j.api.market;

import pl.zankowski.iextrading4j.api.util.DoubleUtil;

/**
 * @author Wojciech Zankowski
 */
public class MarketVolume {

    private String mic;
    private String tapeId;
    private String venueName;
    private long volume;
    private long tapeA;
    private long tapeB;
    private long tapeC;
    private double marketPercent;
    private long lastUpdated;

    public MarketVolume() {
    }

    public MarketVolume(String mic, String tapeId, String venueName, long volume, long tapeA, long tapeB, long tapeC,
                        double marketPercent, long lastUpdated) {
        this.mic = mic;
        this.tapeId = tapeId;
        this.venueName = venueName;
        this.volume = volume;
        this.tapeA = tapeA;
        this.tapeB = tapeB;
        this.tapeC = tapeC;
        this.marketPercent = marketPercent;
        this.lastUpdated = lastUpdated;
    }

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public String getTapeId() {
        return tapeId;
    }

    public void setTapeId(String tapeId) {
        this.tapeId = tapeId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getTapeA() {
        return tapeA;
    }

    public void setTapeA(long tapeA) {
        this.tapeA = tapeA;
    }

    public long getTapeB() {
        return tapeB;
    }

    public void setTapeB(long tapeB) {
        this.tapeB = tapeB;
    }

    public long getTapeC() {
        return tapeC;
    }

    public void setTapeC(long tapeC) {
        this.tapeC = tapeC;
    }

    public double getMarketPercent() {
        return marketPercent;
    }

    public void setMarketPercent(double marketPercent) {
        this.marketPercent = marketPercent;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketVolume that = (MarketVolume) o;

        if (volume != that.volume) return false;
        if (tapeA != that.tapeA) return false;
        if (tapeB != that.tapeB) return false;
        if (tapeC != that.tapeC) return false;
        if (Double.compare(that.marketPercent, marketPercent) != 0) return false;
        if (lastUpdated != that.lastUpdated) return false;
        if (mic != null ? !mic.equals(that.mic) : that.mic != null) return false;
        if (tapeId != null ? !tapeId.equals(that.tapeId) : that.tapeId != null) return false;
        return venueName != null ? venueName.equals(that.venueName) : that.venueName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = mic != null ? mic.hashCode() : 0;
        result = 31 * result + (tapeId != null ? tapeId.hashCode() : 0);
        result = 31 * result + (venueName != null ? venueName.hashCode() : 0);
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        result = 31 * result + (int) (tapeA ^ (tapeA >>> 32));
        result = 31 * result + (int) (tapeB ^ (tapeB >>> 32));
        result = 31 * result + (int) (tapeC ^ (tapeC >>> 32));
        temp = Double.doubleToLongBits(marketPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "MarketVolume{" +
                "mic='" + mic + '\'' +
                ", tapeId='" + tapeId + '\'' +
                ", venueName='" + venueName + '\'' +
                ", volume=" + volume +
                ", tapeA=" + tapeA +
                ", tapeB=" + tapeB +
                ", tapeC=" + tapeC +
                ", marketPercent=" + DoubleUtil.printDouble(marketPercent) +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
