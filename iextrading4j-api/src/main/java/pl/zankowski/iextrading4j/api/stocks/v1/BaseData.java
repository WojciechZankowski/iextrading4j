package pl.zankowski.iextrading4j.api.stocks.v1;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class BaseData implements Serializable {

    private static final long serialVersionUID = 7376752572976245626L;

    private final String symbol;
    private final String id;
    private final String key;
    private final String subkey;
    private final Long updated;
    private final Long date;

    protected BaseData(final String symbol, final String id, final String key, final String subkey,
                       final Long updated, final Long date) {
        this.symbol = symbol;
        this.id = id;
        this.key = key;
        this.subkey = subkey;
        this.updated = updated;
        this.date = date;
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

    public Long getDate() {
        return date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BaseData baseData = (BaseData) o;
        return Objects.equals(symbol, baseData.symbol) && Objects.equals(id, baseData.id) &&
                Objects.equals(key, baseData.key) && Objects.equals(subkey, baseData.subkey) &&
                Objects.equals(updated, baseData.updated) && Objects.equals(date, baseData.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, id, key, subkey, updated, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseData.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("id='" + id + "'")
                .add("key='" + key + "'")
                .add("subkey='" + subkey + "'")
                .add("updated=" + updated)
                .add("date=" + date)
                .toString();
    }
}
