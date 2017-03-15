package pl.zankowski.iextrading4j.client.socket.listener;

import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;

/**
 * @author Wojciech Zankowski
 */
public interface DataReceiver {

    void onTOPS(TOPS tops);

    void onLastTrade(LastTrade lastTrade);

}
