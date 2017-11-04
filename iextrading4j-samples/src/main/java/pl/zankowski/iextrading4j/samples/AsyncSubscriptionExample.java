package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;
import pl.zankowski.iextrading4j.client.socket.model.LastAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.MarketAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.TOPSAsyncRequest;
import pl.zankowski.iextrading4j.client.socket.model.exception.SocketConnectException;
import pl.zankowski.iextrading4j.client.socket.model.exception.SubscribeException;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 * @author Wojciech Zankowski
 */
public class AsyncSubscriptionExample {

    public static void main(String[] args) throws InterruptedException {
        AsyncSubscriptionExample asyncSubscriptionExample = new AsyncSubscriptionExample();
        asyncSubscriptionExample.test();
    }

    public void test() throws InterruptedException {
        try {
            IEXTradingClient iexTradingClient = IEXTradingClient.create(new DataReceiverImpl());
            iexTradingClient.getWebSocket().connect();

            while (true) {

                if (iexTradingClient.getWebSocket().isConnected()) {
                    try {
                        iexTradingClient.getWebSocket().subscribe(TOPSAsyncRequest.builder()
                                .withAllSymbols()
                                .build());
                        iexTradingClient.getWebSocket().subscribe(LastAsyncRequest.builder()
                                .withAllSymbols()
                                .build());
                        iexTradingClient.getWebSocket().subscribe(MarketAsyncRequest.builder()
                                .build());
                    } catch (SubscribeException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                Thread.sleep(100);
            }
        } catch (SocketConnectException e) {
            e.printStackTrace();
        }

        new Semaphore(0).acquire();
    }

    private class DataReceiverImpl implements DataReceiver {

        @Override
        public void onEvent(TOPS tops) {
            System.out.println(tops);
        }

        @Override
        public void onEvent(LastTrade lastTrade) {
            System.out.println(lastTrade);
        }

        @Override
        public void onEvent(MarketVolume[] marketVolumes) {
            Arrays.stream(marketVolumes).forEach(System.out::println);
        }
    }

}
