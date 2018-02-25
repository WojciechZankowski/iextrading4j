package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.api.refdata.SymbolType;

import static pl.zankowski.iextrading4j.client.mapper.SymbolTypeDeserializer.SYMBOL_TYPE_MAPPER;

class SymbolTypeSerializer extends AbstractEnumSerializer<SymbolType> {

    SymbolTypeSerializer() {
        super(SYMBOL_TYPE_MAPPER.inverse(), SymbolType.UNKNOWN);
    }
}
