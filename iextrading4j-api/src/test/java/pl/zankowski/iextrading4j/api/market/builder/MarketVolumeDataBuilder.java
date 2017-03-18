package pl.zankowski.iextrading4j.api.market.builder;

import pl.zankowski.iextrading4j.api.market.MarketVolume;

/**
 * @author Wojciech Zankowski
 */
public class MarketVolumeDataBuilder {

    private String mic = "XCHI";
    private String tapeId = "M";
    private String venueName = "CHX";
    private long volume = 16475000;
    private long tapeA = 5155704;
    private long tapeB = 7013233;
    private long tapeC = 4306063;
    private double marketPercent = 0.00266;
    private long lastUpdated = 1489438707493L;

    public static MarketVolume defaultMarketVolume() {
        return aMarketVolume().build();
    }

    public static MarketVolumeDataBuilder aMarketVolume() {
        return new MarketVolumeDataBuilder();
    }

    public MarketVolumeDataBuilder withMic(String mic) {
        this.mic = mic;
        return this;
    }

    public MarketVolumeDataBuilder withTapeId(String tapeId) {
        this.tapeId = tapeId;
        return this;
    }

    public MarketVolumeDataBuilder withVenueName(String venueName) {
        this.venueName = venueName;
        return this;
    }

    public MarketVolumeDataBuilder withVolume(long volume) {
        this.volume = volume;
        return this;
    }

    public MarketVolumeDataBuilder withTapeA(long tapeA) {
        this.tapeA = tapeA;
        return this;
    }

    public MarketVolumeDataBuilder withTapeB(long tapeB) {
        this.tapeB = tapeB;
        return this;
    }

    public MarketVolumeDataBuilder withTapeC(long tapeC) {
        this.tapeC = tapeC;
        return this;
    }

    public MarketVolumeDataBuilder withMarketPercent(double marketPercent) {
        this.marketPercent = marketPercent;
        return this;
    }

    public MarketVolumeDataBuilder withLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public MarketVolume build() {
        return new MarketVolume(mic, tapeId, venueName, volume, tapeA, tapeB, tapeC, marketPercent, lastUpdated);
    }

}
