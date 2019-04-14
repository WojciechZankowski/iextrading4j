package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class Currency implements Serializable {

    private final String code;
    private final String name;

    @JsonCreator
    public Currency(
            @JsonProperty("code") final String code,
            @JsonProperty("name") final String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        final Currency currency = (Currency) o;
        return Objects.equal(code, currency.code) &&
                Objects.equal(name, currency.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("name", name)
                .toString();
    }

}
