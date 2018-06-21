package pl.zankowski.iextrading4j.client.mapper;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepChannel;

class DeepChannelDeserializer extends AbstractEnumDeserializer<DeepChannel> {

    static final BiMap<String, DeepChannel> DEEP_CHANNEL_MAPPER = ImmutableBiMap.<String, DeepChannel>builder()
            .put("tradingstatus", DeepChannel.TRADING_STATUS)
            .put("auction", DeepChannel.AUCTION)
            .put("ophaltstatus", DeepChannel.OP_HALT_STATUS)
            .put("ssr", DeepChannel.SSR_STATUS)
            .put("securityevent", DeepChannel.SECURITY_EVENT)
            .put("tradebreak", DeepChannel.TRADE_BREAK)
            .put("trades", DeepChannel.TRADES)
            .put("book", DeepChannel.BOOK)
            .put("systemevent", DeepChannel.SYSTEM_EVENT)
            .put("deep", DeepChannel.DEEP)
            .build();

    DeepChannelDeserializer() {
        super(DEEP_CHANNEL_MAPPER, DeepChannel.UNKNOWN);
    }
}
