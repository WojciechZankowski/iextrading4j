package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"peers", "symbols"})
public class Relevant implements Serializable {

    private final Boolean peers;
    private final List<String> symbols;

    @JsonCreator
    public Relevant(
            @JsonProperty("peers") final Boolean peers,
            @JsonProperty("symbols") final List<String> symbols) {
        this.peers = peers;
        this.symbols = immutableList(symbols);
    }

    public Boolean isPeers() {
        return peers;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relevant relevant = (Relevant) o;
        return Objects.equal(peers, relevant.peers) &&
                Objects.equal(symbols, relevant.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(peers, symbols);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("peers", peers)
                .add("symbols", symbols)
                .toString();
    }
}
