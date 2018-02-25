package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.stocks.DividendQualification;

import static pl.zankowski.iextrading4j.api.stocks.DividendQualification.PARTIALLY_QUALIFIED_INCOME;
import static pl.zankowski.iextrading4j.api.stocks.DividendQualification.QUALIFIED_INCOME;
import static pl.zankowski.iextrading4j.api.stocks.DividendQualification.UNQUALIFIED_INCOME;

class DividendQualificationDeserializer extends AbstractEnumDeserializer<DividendQualification> {

    static final BiMap<String, DividendQualification> DIVIDEND_QUALIFICATION_MAPPER = ImmutableBiMap.<String, DividendQualification>builder()
            .put("P", PARTIALLY_QUALIFIED_INCOME)
            .put("Q", QUALIFIED_INCOME)
            .put("N", UNQUALIFIED_INCOME)
            .build();

    DividendQualificationDeserializer() {
        super(DIVIDEND_QUALIFICATION_MAPPER, DividendQualification.UNKNOWN);
    }
}
