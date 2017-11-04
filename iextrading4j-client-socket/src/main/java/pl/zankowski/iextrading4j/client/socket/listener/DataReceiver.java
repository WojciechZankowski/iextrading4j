package pl.zankowski.iextrading4j.client.socket.listener;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;

/**
 * @author Wojciech Zankowski
 */
public interface DataReceiver {

    void onEvent(TOPS tops);

    void onEvent(LastTrade lastTrade);

    void onEvent(MarketVolume[] marketVolumes);

}
