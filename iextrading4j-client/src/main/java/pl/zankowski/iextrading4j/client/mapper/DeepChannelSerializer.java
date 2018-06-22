package pl.zankowski.iextrading4j.client.mapper;

import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

import static pl.zankowski.iextrading4j.client.mapper.DeepChannelDeserializer.DEEP_CHANNEL_MAPPER;

class DeepChannelSerializer extends AbstractEnumSerializer<DeepChannel> {

    DeepChannelSerializer() {
        super(DEEP_CHANNEL_MAPPER.inverse(), DeepChannel.UNKNOWN);
    }
}
