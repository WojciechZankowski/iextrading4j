package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class CryptoBook implements Serializable {

    private static final long serialVersionUID = 44462362459562860L;

    private final List<CryptoBookEntry> bids;
    private final List<CryptoBookEntry> asks;

    @JsonCreator
    public CryptoBook(
            @JsonProperty("bids") final List<CryptoBookEntry> bids,
            @JsonProperty("asks") final List<CryptoBookEntry> asks) {
        this.bids = immutableList(bids);
        this.asks = immutableList(asks);
    }

    public List<CryptoBookEntry> getBids() {
        return bids;
    }

    public List<CryptoBookEntry> getAsks() {
        return asks;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CryptoBook that = (CryptoBook) o;
        return Objects.equal(bids, that.bids) &&
                Objects.equal(asks, that.asks);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bids, asks);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bids", bids)
                .add("asks", asks)
                .toString();
    }

}
