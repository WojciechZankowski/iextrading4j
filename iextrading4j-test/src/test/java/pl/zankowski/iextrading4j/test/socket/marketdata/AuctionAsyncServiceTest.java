package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.AuctionType;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.AuctionAsyncRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepAsyncResponse;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.deep.DeepMessageType;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class AuctionAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<DeepAsyncResponse<Auction>> dataCaptor = ArgumentCaptor.forClass(DeepAsyncResponse.class);

    @Test
    public void auctionAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/AuctionAsyncResponse.json");

        final Consumer<DeepAsyncResponse<Auction>> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new AuctionAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final DeepAsyncResponse<Auction> response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getMessageType()).isEqualTo(DeepMessageType.AUCTION);
        assertThat(response.getSeq()).isEqualTo(1L);

        final Auction data = response.getData();
        assertThat(data.getAuctionType()).isEqualTo(AuctionType.Open);
        assertThat(data.getPairedShares()).isEqualTo(BigDecimal.valueOf(3600));
        assertThat(data.getImbalanceShares()).isEqualTo(BigDecimal.valueOf(600));
        assertThat(data.getReferencePrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(data.getIndicativePrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(data.getAuctionBookPrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(data.getCollarReferencePrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(data.getLowerCollarPrice()).isEqualTo(BigDecimal.valueOf(0.5));
        assertThat(data.getUpperCollarPrice()).isEqualTo(BigDecimal.valueOf(1.6));
        assertThat(data.getExtensionNumber()).isEqualTo(BigDecimal.ZERO);
        assertThat(data.getStartTime()).isEqualTo(LocalTime.of(9, 30, 0));
        assertThat(data.getLastUpdate()).isEqualTo(1506706199025L);
    }

}
