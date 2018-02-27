package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.api.refdata.IssueEvent;

import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.ANTICIPATED_SECURITY_ADDITION;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.CUSIP_CHANGE;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.FINANCIAL_STATUS_CHANGE;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.ISSUE_DELETION;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.ISSUE_SUSPENSION;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.NAME_SYMBOL_CHANGE;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.NOT_AVAILABLE;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.SECURITY_ADDITION;
import static pl.zankowski.iextrading4j.api.refdata.IssueEvent.TRADING_DETAILS_CHANGE;

class IssueEventDeserializer extends AbstractEnumDeserializer<IssueEvent> {

    static final BiMap<String, IssueEvent> ISSUE_EVENT_MAPPER = ImmutableBiMap.<String, IssueEvent>builder()
            .put("SA", SECURITY_ADDITION)
            .put("AA", ANTICIPATED_SECURITY_ADDITION)
            .put("IS", ISSUE_SUSPENSION)
            .put("ID", ISSUE_DELETION)
            .put("NS", NAME_SYMBOL_CHANGE)
            .put("FS", FINANCIAL_STATUS_CHANGE)
            .put("CC", CUSIP_CHANGE)
            .put("TD", TRADING_DETAILS_CHANGE)
            .put("", NOT_AVAILABLE)
            .build();

    IssueEventDeserializer() {
        super(ISSUE_EVENT_MAPPER, IssueEvent.UNKNOWN);
    }
}
