package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.IssueType;

import static pl.zankowski.iextrading4j.client.mapper.IssueTypeDeserializer.ISSUE_TYPE_MAPPER;

class IssueTypeSerializer extends AbstractEnumSerializer<IssueType> {

    IssueTypeSerializer() {
        super(ISSUE_TYPE_MAPPER.inverse(), IssueType.UNKNOWN);
    }

}
