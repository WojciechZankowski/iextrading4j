package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import static pl.zankowski.iextrading4j.api.refdata.SymbolType.ADR;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.BO;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.CLOSED_END_FUND;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.COMMON_STOCK;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.ETF;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.LIMITED_PARTNERSHIP;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.NOT_AVAILABLE;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.PS;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.REIT;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.SECONDARY_ISSUE;
import static pl.zankowski.iextrading4j.api.refdata.SymbolType.SU;

class SymbolTypeDeserializer extends AbstractEnumDeserializer<SymbolType> {

    static final BiMap<String, SymbolType> SYMBOL_TYPE_MAPPER = ImmutableBiMap.<String, SymbolType>builder()
            .put("ad", ADR)
            .put("re", REIT)
            .put("ce", CLOSED_END_FUND)
            .put("si", SECONDARY_ISSUE)
            .put("lp", LIMITED_PARTNERSHIP)
            .put("cs", COMMON_STOCK)
            .put("et", ETF)
            .put("ps", PS)
            .put("bo", BO)
            .put("su", SU)
            .put("N/A", NOT_AVAILABLE)
            .build();

    SymbolTypeDeserializer() {
        super(SYMBOL_TYPE_MAPPER, SymbolType.UNKNOWN);
    }

}
