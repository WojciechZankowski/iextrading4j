package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.FinancialStatus;

import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.BANKRUPT;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.BANKRUPT_AND_BELOW_CONTINUING_LISTING_STANDARDS;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.BANKRUPT_AND_BELOW_CONTINUING_LISTING_STANDARDS_AND_LATE_FILING;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.BANKRUPT_AND_LATE_FILING;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.BELOW_CONTINUING_LISTING_STANDARDS;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.BELOW_CONTINUING_LISTING_STANDARDS_LATE_FILING;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.CREATIONS_SUSPENDED;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.LATE_FILING;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.LIQUIDATION;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.NORMAL;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.NOT_AVAILABLE;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.REDEMPTIONS_SUSPENDED;
import static pl.zankowski.iextrading4j.api.refdata.FinancialStatus.UNKNOWN;

class FinancialStatusDeserializer extends AbstractEnumDeserializer<FinancialStatus> {

    static final BiMap<String, FinancialStatus> FINANCIAL_STATUS_MAPPER = ImmutableBiMap.<String, FinancialStatus>builder()
            .put("0", NORMAL)
            .put("1", BANKRUPT)
            .put("2", BELOW_CONTINUING_LISTING_STANDARDS)
            .put("3", BANKRUPT_AND_BELOW_CONTINUING_LISTING_STANDARDS)
            .put("4", LATE_FILING)
            .put("5", BANKRUPT_AND_LATE_FILING)
            .put("6", BELOW_CONTINUING_LISTING_STANDARDS_LATE_FILING)
            .put("7", BANKRUPT_AND_BELOW_CONTINUING_LISTING_STANDARDS_AND_LATE_FILING)
            .put("8", CREATIONS_SUSPENDED)
            .put("9", REDEMPTIONS_SUSPENDED)
            .put("A", LIQUIDATION)
            .put("", NOT_AVAILABLE)
            .build();

    FinancialStatusDeserializer() {
        super(FINANCIAL_STATUS_MAPPER, UNKNOWN);
    }

}
