package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.stocks.DividendType;

import static pl.zankowski.iextrading4j.api.stocks.DividendType.DIVIDEND_INCOME;
import static pl.zankowski.iextrading4j.api.stocks.DividendType.INTEREST_INCOME;
import static pl.zankowski.iextrading4j.api.stocks.DividendType.LONG_TERM_CAPITAL_GAIN;
import static pl.zankowski.iextrading4j.api.stocks.DividendType.MEDIUM_TERM_CAPITAL_GAIN;
import static pl.zankowski.iextrading4j.api.stocks.DividendType.SHORT_TERM_CAPITAL_GAIN;
import static pl.zankowski.iextrading4j.api.stocks.DividendType.STOCK_DIVIDEND;
import static pl.zankowski.iextrading4j.api.stocks.DividendType.UNSPECIFIED_TERM_CAPITAL_GAIN;

class DividendTypeDeserializer extends AbstractEnumDeserializer<DividendType> {

    static final BiMap<String, DividendType> DIVIDEND_TYPE_MAPPER = ImmutableBiMap.<String, DividendType>builder()
            .put("Dividend income", DIVIDEND_INCOME)
            .put("Interest income", INTEREST_INCOME)
            .put("Stock dividend", STOCK_DIVIDEND)
            .put("Short term capital gain", SHORT_TERM_CAPITAL_GAIN)
            .put("Medium term capital gain", MEDIUM_TERM_CAPITAL_GAIN)
            .put("Long term capital gain", LONG_TERM_CAPITAL_GAIN)
            .put("Unspecified term capital gain", UNSPECIFIED_TERM_CAPITAL_GAIN)
            .build();

    DividendTypeDeserializer() {
        super(DIVIDEND_TYPE_MAPPER, DividendType.UNKNOWN);
    }

}
