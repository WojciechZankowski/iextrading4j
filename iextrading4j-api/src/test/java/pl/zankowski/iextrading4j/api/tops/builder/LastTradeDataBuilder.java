package pl.zankowski.iextrading4j.api.tops.builder;

import pl.zankowski.iextrading4j.api.marketdata.LastTrade;

/**
 * @author Wojciech Zankowski
 */
public class LastTradeDataBuilder {

	private String symbol = "FTR";
	private double price = 2.545;
	private int size = 100;
	private long time = 1489435195124L;

	public static LastTrade defaultLastTrade() {
		return aLastTrade().build();
	}

	public static LastTradeDataBuilder aLastTrade() {
		return new LastTradeDataBuilder();
	}

	public LastTradeDataBuilder withSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	public LastTradeDataBuilder withPrice(double price) {
		this.price = price;
		return this;
	}

	public LastTradeDataBuilder withSize(int size) {
		this.size = size;
		return this;
	}

	public LastTradeDataBuilder withTime(long time) {
		this.time = time;
		return this;
	}

	public LastTrade build() {
		return new LastTrade(symbol, price, size, time);
	}

}
