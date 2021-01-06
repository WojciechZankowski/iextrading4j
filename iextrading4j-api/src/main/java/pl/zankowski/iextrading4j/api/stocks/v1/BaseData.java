package pl.zankowski.iextrading4j.api.stocks.v1;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class BaseData implements Serializable {

    private final String symbol;
    private final String id;
    private final String key;
    private final String subkey;
    private final Long updated;

    public BaseData(final String symbol, final String id, final String key, final String subkey, final Long updated) {
        this.symbol = symbol;
        this.id = id;
        this.key = key;
        this.subkey = subkey;
        this.updated = updated;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getSubkey() {
        return subkey;
    }

    public Long getUpdated() {
        return updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseData baseData = (BaseData) o;
        return Objects.equals(symbol, baseData.symbol) &&
                Objects.equals(id, baseData.id) &&
                Objects.equals(key, baseData.key) &&
                Objects.equals(subkey, baseData.subkey) &&
                Objects.equals(updated, baseData.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, id, key, subkey, updated);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseData.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("id='" + id + "'")
                .add("key='" + key + "'")
                .add("subkey='" + subkey + "'")
                .add("updated=" + updated)
                .toString();
    }
}
