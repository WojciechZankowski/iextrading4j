package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.stocks.v1.DirectIndirect;

import static pl.zankowski.iextrading4j.client.mapper.DirectIndirectDeserializer.DIRECT_INDIRECT_MAPPER;

public class DirectIndirectSerializer extends AbstractEnumSerializer<DirectIndirect> {

    DirectIndirectSerializer() {
        super(DIRECT_INDIRECT_MAPPER.inverse(), null);
    }
}
