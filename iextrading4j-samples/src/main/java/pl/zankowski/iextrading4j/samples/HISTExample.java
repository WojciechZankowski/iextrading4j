package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.hist.HIST;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.hist.request.HISTRequest;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class HISTExample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        HISTExample histExample = new HISTExample();
        histExample.testHISTRequest();
    }

    private void testHISTRequest() {
        HIST[] histArray = iexTradingClient.getHistEndpoint().requestHIST(HISTRequest.builder()
                .withDate(LocalDate.of(2017, 5, 15))
                .build());
        Arrays.stream(histArray).forEach(System.out::println);
    }

}
