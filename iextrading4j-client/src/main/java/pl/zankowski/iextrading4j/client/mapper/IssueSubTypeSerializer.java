package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.IssueSubType;

import static pl.zankowski.iextrading4j.client.mapper.IssueSubTypeDeserializer.ISSUE_SUB_TYPE_MAPPER;

class IssueSubTypeSerializer extends AbstractEnumSerializer<IssueSubType> {

    IssueSubTypeSerializer() {
        super(ISSUE_SUB_TYPE_MAPPER.inverse(), IssueSubType.UNKNOWN);
    }

}
