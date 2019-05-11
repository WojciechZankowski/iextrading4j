package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"code", "name"})
public class Currency implements Serializable {

    private static final long serialVersionUID = 7575135563125400106L;

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
