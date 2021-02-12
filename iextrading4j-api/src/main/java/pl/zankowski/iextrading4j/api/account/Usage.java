package pl.zankowski.iextrading4j.api.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Map;

import static pl.zankowski.iextrading4j.api.util.MapUtil.immutableMap;

public class Usage implements Serializable {

    private static final long serialVersionUID = -4979856478459362719L;

    private final Long monthlyUsage;
    private final Long monthlyPayAsYouGo;
    private final Map<String, Long> dailyUsage;
    private final Map<String, Long> tokenUsage;
    private final Map<String, Long> keyUsage;

    @JsonCreator
    public Usage(
            @JsonProperty("monthlyUsage") final Long monthlyUsage,
            @JsonProperty("monthlyPayAsYouGo") final Long monthlyPayAsYouGo,
            @JsonProperty("dailyUsage") final Map<String, Long> dailyUsage,
            @JsonProperty("tokenUsage") final Map<String, Long> tokenUsage,
            @JsonProperty("keyUsage") final Map<String, Long> keyUsage) {
        this.monthlyUsage = monthlyUsage;
        this.monthlyPayAsYouGo = monthlyPayAsYouGo;
        this.dailyUsage = immutableMap(dailyUsage);
        this.tokenUsage = immutableMap(tokenUsage);
        this.keyUsage = immutableMap(keyUsage);
    }

    public Long getMonthlyUsage() {
        return monthlyUsage;
    }

    public Long getMonthlyPayAsYouGo() {
        return monthlyPayAsYouGo;
    }

    public Map<String, Long> getDailyUsage() {
        return dailyUsage;
    }

    public Map<String, Long> getTokenUsage() {
        return tokenUsage;
    }

    public Map<String, Long> getKeyUsage() {
        return keyUsage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Usage usage = (Usage) o;
        return Objects.equal(monthlyUsage, usage.monthlyUsage) &&
                Objects.equal(monthlyPayAsYouGo, usage.monthlyPayAsYouGo) &&
                Objects.equal(dailyUsage, usage.dailyUsage) &&
                Objects.equal(tokenUsage, usage.tokenUsage) &&
                Objects.equal(keyUsage, usage.keyUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(monthlyUsage, monthlyPayAsYouGo, dailyUsage, tokenUsage, keyUsage);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("monthlyUsage", monthlyUsage)
                .add("monthlyPayAsYouGo", monthlyPayAsYouGo)
                .add("dailyUsage", dailyUsage)
                .add("tokenUsage", tokenUsage)
                .add("keyUsage", keyUsage)
                .toString();
    }

}
