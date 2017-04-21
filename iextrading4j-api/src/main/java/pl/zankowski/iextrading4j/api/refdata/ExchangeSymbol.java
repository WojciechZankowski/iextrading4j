package pl.zankowski.iextrading4j.api.refdata;

import java.time.LocalDate;

/**
 * @author Wojciech Zankowski
 */
public class ExchangeSymbol {

    private String symbol;
    private String name;
    private LocalDate date;
    private boolean isEnabled;

    public ExchangeSymbol() {
    }

    public ExchangeSymbol(String symbol, String name, LocalDate date, boolean isEnabled) {
        this.symbol = symbol;
        this.name = name;
        this.date = date;
        this.isEnabled = isEnabled;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeSymbol)) return false;

        ExchangeSymbol that = (ExchangeSymbol) o;

        if (isEnabled != that.isEnabled) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = symbol != null ? symbol.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExchangeSymbol{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", isEnabled=" + isEnabled +
                '}';
    }

}
