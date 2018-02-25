package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.IssueEvent;

import static pl.zankowski.iextrading4j.client.mapper.IssueEventDeserializer.ISSUE_EVENT_MAPPER;

class IssueEventSerializer extends AbstractEnumSerializer<IssueEvent> {

    IssueEventSerializer() {
        super(ISSUE_EVENT_MAPPER.inverse(), IssueEvent.UNKNOWN);
    }

}
