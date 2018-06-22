package pl.zankowski.iextrading4j.api.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalTime;

@JsonPropertyOrder({"auctionType", "pairedShares", "imbalanceShares", "referencePrice",
        "indicativePrice", "auctionBookPrice", "collarReferencePrice", "lowerCollarPrice",
        "upperCollarPrice", "extensionNumber", "startTime", "lastUpdate"})
public class Auction extends DeepResult {

    private final AuctionType auctionType;
    private final BigDecimal pairedShares;
    private final BigDecimal imbalanceShares;
    private final BigDecimal referencePrice;
    private final BigDecimal indicativePrice;
    private final BigDecimal auctionBookPrice;
    private final BigDecimal collarReferencePrice;
    private final BigDecimal lowerCollarPrice;
    private final BigDecimal upperCollarPrice;
    private final BigDecimal extensionNumber;
    private final LocalTime startTime;
    private final Long lastUpdate;

    @JsonCreator
    public Auction(
            @JsonProperty("auctionType") final AuctionType auctionType,
            @JsonProperty("pairedShares") final BigDecimal pairedShares,
            @JsonProperty("imbalanceShares") final BigDecimal imbalanceShares,
            @JsonProperty("referencePrice") final BigDecimal referencePrice,
            @JsonProperty("indicativePrice") final BigDecimal indicativePrice,
            @JsonProperty("auctionBookPrice") final BigDecimal auctionBookPrice,
            @JsonProperty("collarReferencePrice") final BigDecimal collarReferencePrice,
            @JsonProperty("lowerCollarPrice") final BigDecimal lowerCollarPrice,
            @JsonProperty("upperCollarPrice") final BigDecimal upperCollarPrice,
            @JsonProperty("extensionNumber") final BigDecimal extensionNumber,
            @JsonProperty("startTime") final LocalTime startTime,
            @JsonProperty("lastUpdate") final Long lastUpdate) {
        this.auctionType = auctionType;
        this.pairedShares = pairedShares;
        this.imbalanceShares = imbalanceShares;
        this.referencePrice = referencePrice;
        this.indicativePrice = indicativePrice;
        this.auctionBookPrice = auctionBookPrice;
        this.collarReferencePrice = collarReferencePrice;
        this.lowerCollarPrice = lowerCollarPrice;
        this.upperCollarPrice = upperCollarPrice;
        this.extensionNumber = extensionNumber;
        this.startTime = startTime;
        this.lastUpdate = lastUpdate;
    }

    public AuctionType getAuctionType() {
        return auctionType;
    }

    public BigDecimal getPairedShares() {
        return pairedShares;
    }

    public BigDecimal getImbalanceShares() {
        return imbalanceShares;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public BigDecimal getIndicativePrice() {
        return indicativePrice;
    }

    public BigDecimal getAuctionBookPrice() {
        return auctionBookPrice;
    }

    public BigDecimal getCollarReferencePrice() {
        return collarReferencePrice;
    }

    public BigDecimal getLowerCollarPrice() {
        return lowerCollarPrice;
    }

    public BigDecimal getUpperCollarPrice() {
        return upperCollarPrice;
    }

    public BigDecimal getExtensionNumber() {
        return extensionNumber;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return auctionType == auction.auctionType &&
                Objects.equal(pairedShares, auction.pairedShares) &&
                Objects.equal(imbalanceShares, auction.imbalanceShares) &&
                Objects.equal(referencePrice, auction.referencePrice) &&
                Objects.equal(indicativePrice, auction.indicativePrice) &&
                Objects.equal(auctionBookPrice, auction.auctionBookPrice) &&
                Objects.equal(collarReferencePrice, auction.collarReferencePrice) &&
                Objects.equal(lowerCollarPrice, auction.lowerCollarPrice) &&
                Objects.equal(upperCollarPrice, auction.upperCollarPrice) &&
                Objects.equal(extensionNumber, auction.extensionNumber) &&
                Objects.equal(startTime, auction.startTime) &&
                Objects.equal(lastUpdate, auction.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(auctionType, pairedShares, imbalanceShares, referencePrice,
                indicativePrice, auctionBookPrice, collarReferencePrice, lowerCollarPrice,
                upperCollarPrice, extensionNumber, startTime, lastUpdate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("auctionType", auctionType)
                .add("pairedShares", pairedShares)
                .add("imbalanceShares", imbalanceShares)
                .add("referencePrice", referencePrice)
                .add("indicativePrice", indicativePrice)
                .add("auctionBookPrice", auctionBookPrice)
                .add("collarReferencePrice", collarReferencePrice)
                .add("lowerCollarPrice", lowerCollarPrice)
                .add("upperCollarPrice", upperCollarPrice)
                .add("extensionNumber", extensionNumber)
                .add("startTime", startTime)
                .add("lastUpdate", lastUpdate)
                .toString();
    }
}
