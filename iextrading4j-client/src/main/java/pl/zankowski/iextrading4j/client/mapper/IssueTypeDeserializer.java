package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.IssueType;

import static pl.zankowski.iextrading4j.api.refdata.IssueType.AMERICAN_DEPOSITORY_SHARES;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.COMMON_STOCK;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.CONVERTIBLE_DEBENTURE;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.DEPOSITORY_RECEIPT;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.EXCHANGE_TRADED_PRODUCT;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.LIMITED_PARTNERSHIP;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.ORDINARY_SHARES;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.OTHER_SECURITIES;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.PREFERRED_SHARES;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.RIGHT;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.SHARES_OF_BENEFICIAL_INTEREST;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.UNIT;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.UNITS_OF_BENEFICIAL_INTEREST;
import static pl.zankowski.iextrading4j.api.refdata.IssueType.WARRANT;
import static pl.zankowski.iextrading4j.api.refdata.IssueType._144A;

class IssueTypeDeserializer extends AbstractEnumDeserializer<IssueType> {

    static final BiMap<String, IssueType> ISSUE_TYPE_MAPPER = ImmutableBiMap.<String, IssueType>builder()
            .put("A", AMERICAN_DEPOSITORY_SHARES)
            .put("C", COMMON_STOCK)
            .put("E", EXCHANGE_TRADED_PRODUCT)
            .put("F", DEPOSITORY_RECEIPT)
            .put("I", _144A)
            .put("L", LIMITED_PARTNERSHIP)
            .put("O", ORDINARY_SHARES)
            .put("P", PREFERRED_SHARES)
            .put("Q", OTHER_SECURITIES)
            .put("R", RIGHT)
            .put("S", SHARES_OF_BENEFICIAL_INTEREST)
            .put("T", CONVERTIBLE_DEBENTURE)
            .put("U", UNIT)
            .put("V", UNITS_OF_BENEFICIAL_INTEREST)
            .put("W", WARRANT)
            .build();

    IssueTypeDeserializer() {
        super(ISSUE_TYPE_MAPPER, IssueType.UNKNOWN);
    }

}
