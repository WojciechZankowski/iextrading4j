package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.ListingCenter;

import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.CBOE_BYX;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.CBOE_BZX;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.CBOE_EDGA;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.CBOE_EDGX;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.CBOE_STOCK_EXCHANGE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.CHICAGO_STOCK_EXCHANGE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.FINANCIAL_INDUSTRY_REGULATORY_AUTHORITY;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.INTERNATIONAL_SECURITIES_EXCHANGE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.INVESTORS_EXCHANGE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NASDAQ_BX;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NASDAQ_PSX;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NASDAQ_STOCK_EXCHANGE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NEW_YORK_STOCK_EXCHANGE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NOT_AVAILABLE;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NYSE_AMERICAN;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NYSE_ARCA;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.NYSE_NATIONAL;
import static pl.zankowski.iextrading4j.api.refdata.ListingCenter.OVER_THE_COUNTER_MARKET;

class ListingCenterDeserializer extends AbstractEnumDeserializer<ListingCenter> {

    static final BiMap<String, ListingCenter> LISTING_CENTER_MAPPER = ImmutableBiMap.<String, ListingCenter>builder()
            .put("A", NYSE_AMERICAN)
            .put("B", NASDAQ_BX)
            .put("C", NYSE_NATIONAL)
            .put("F", FINANCIAL_INDUSTRY_REGULATORY_AUTHORITY)
            .put("I", INTERNATIONAL_SECURITIES_EXCHANGE)
            .put("J", CBOE_EDGA)
            .put("K", CBOE_EDGX)
            .put("M", CHICAGO_STOCK_EXCHANGE)
            .put("N", NEW_YORK_STOCK_EXCHANGE)
            .put("O", OVER_THE_COUNTER_MARKET)
            .put("P", NYSE_ARCA)
            .put("Q", NASDAQ_STOCK_EXCHANGE)
            .put("V", INVESTORS_EXCHANGE)
            .put("W", CBOE_STOCK_EXCHANGE)
            .put("X", NASDAQ_PSX)
            .put("Y", CBOE_BYX)
            .put("Z", CBOE_BZX)
            .put("", NOT_AVAILABLE)
            .build();

    ListingCenterDeserializer() {
        super(LISTING_CENTER_MAPPER, ListingCenter.UNKNOWN);
    }

}
