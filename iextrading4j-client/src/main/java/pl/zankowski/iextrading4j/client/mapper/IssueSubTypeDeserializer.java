package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.IssueSubType;

import static pl.zankowski.iextrading4j.api.refdata.IssueSubType.*;

class IssueSubTypeDeserializer extends AbstractEnumDeserializer<IssueSubType> {

    static final BiMap<String, IssueSubType> ISSUE_SUB_TYPE_MAPPER = ImmutableBiMap.<String, IssueSubType>builder()
            .put("A", PREFERRED_TRUST_SECURITIES)
            .put("B", INDEX_BASED_DERIVATIVE)
            .put("C", COMMON_SHARES)
            .put("CB", COMMODITY_BASED_TRUST_SHARES)
            .put("CE", CLOSED_END_FUND)
            .put("CF", COMMODITY_FUTURES_TRUST_SHARES)
            .put("CL", COMMODITY_LINKED_SECURITIES)
            .put("CM", COMMODITY_INDEX_TRUST_SHARES)
            .put("CT", CURRENCY_TRUST_SHARES)
            .put("CU", COMMODITY_CURRENCY_LINKED_SECURITIES)
            .put("CW", CURRENCY_WARRANTS)
            .put("D", GLOBAL_DEPOSITARY_SHARES)
            .put("E", ETF_PORTFOLIO_DEPOSITARY_RECEIPT)
            .put("EG", EQUITY_GOLD_SHARES)
            .put("EI", ETN_EQUITY_INDEX_LINKED_SECURITIES)
            .put("EN", EXCHANGE_TRADED_NOTES)
            .put("FI", ETN_FIXED_INCOME_LINKED_SECURITIES)
            .put("FL", ETN_FUTURES_LINKED_SECURITIES)
            .put("G", GLOBAL_SHARES)
            .put("H", DEBT_BASED_DERIVATIVE)
            .put("I", ETF_INDEX_FUND_SHARES)
            .put("IX", INDEX_LINKED_EXCHANGEABLE_NOTES)
            .put("K", CALLABLE_COMMON_STOCK)
            .put("L", CONTINGENT_LITIGATION_RIGHT)
            .put("LL", LIMITED_LIABILITY_COMPANY)
            .put("M", EQUITY_BASED_DERIVATIVE)
            .put("MF", MANAGED_FUND_SHARES)
            .put("ML", ETN_MULTI_FACTOR_INDEX_LINKED_SECURITIES)
            .put("MP", MASTER_LIMITED_PARTNERSHIP)
            .put("MT", MANAGED_TRUST_SECURITIES)
            .put("N", NY_REGISTRY_SHARES)
            .put("O", OPEN_ENDED_MUTUAL_FUND)
            .put("PU", PARTNERSHIP_UNITS)
            .put("R", REG_S)
            .put("RC", COMMODITY_REDEEMABLE_COMMODITY_LINKED_SECURITIES)
            .put("RF", ETN_REDEEMABLE_FUTURES_LINKED_SECURITIES)
            .put("RT", REIT)
            .put("RU", COMMODITY_REDEEMABLE_CURRENCY_LINKED_SECURITIES)
            .put("S", SEED)
            .put("T", TRACKING_STOCK)
            .put("TC", TRUST_CERTIFICATES)
            .put("TU", TRUST_UNITS)
            .put("V", CONTINGENT_VALUE_RIGHT)
            .put("W", TRUST_ISSUED_RECEIPTS)
            .put("", NOT_AVAILABLE)
            .build();

    IssueSubTypeDeserializer() {
        super(ISSUE_SUB_TYPE_MAPPER, IssueSubType.UNKNOWN);
    }

}
