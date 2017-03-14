package pl.zankowski.iextrading.client.socket.listener;

import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;

/**
 * @author Wojciech Zankowski
 */
public interface DataReceiver {

    void onTOPS(TOPS tops);

    void onLastTrade(LastTrade lastTrade);

}
