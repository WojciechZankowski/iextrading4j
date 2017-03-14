package pl.zankowski.iextrading.samples;

import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;
import pl.zankowski.iextrading.client.IEXTradingClient;
import pl.zankowski.iextrading.client.socket.listener.DataReceiver;

/**
 * @author Wojciech Zankowski
 */
public class AsyncSubscriptionExample {

    public static void main(String[] args) {
        AsyncSubscriptionExample asyncSubscriptionExample = new AsyncSubscriptionExample();
        asyncSubscriptionExample.test();
    }

    public void test() {
        IEXTradingClient iexTradingClient = IEXTradingClient.create(new DataReceiverImpl());
    }

    private class DataReceiverImpl implements DataReceiver {

        @Override
        public void onTOPS(TOPS tops) {
            System.out.println(tops);
        }

        @Override
        public void onLastTrade(LastTrade lastTrade) {
            System.out.println(lastTrade);
        }
    }

}
