package pl.zankowski.iextrading4j.test.socket.marketdata;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.socket.request.marketdata.TopsAsyncRequestBuilder;
import pl.zankowski.iextrading4j.test.socket.BaseSocketServiceTest;

import java.math.BigDecimal;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class TopsAsyncServiceTest extends BaseSocketServiceTest {

    private final ArgumentCaptor<TOPS> dataCaptor = ArgumentCaptor.forClass(TOPS.class);

    @Test
    public void topsAsyncServiceTest() {
        stubFor(socket)
                .withResponseFile("/marketdata/TopsAsyncResponse.json");

        final Consumer<TOPS> consumer = spy(Consumer.class);

        iexTradingClient.subscribe(new TopsAsyncRequestBuilder()
                .withSymbol("AAPL")
                .build(), consumer);

        verify(consumer).accept(dataCaptor.capture());

        final TOPS response = dataCaptor.getValue();
        assertThat(response.getSymbol()).isEqualTo("AAPL");
        assertThat(response.getSector()).isEqualTo("technologyhardwareequipment");
        assertThat(response.getSecurityType()).isEqualTo("commonstock");
        assertThat(response.getBidPrice()).usingComparator(BigDecimal::compareTo).isEqualTo(BigDecimal.valueOf(185.5900));
        assertThat(response.getBidSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(response.getAskPrice()).usingComparator(BigDecimal::compareTo).isEqualTo(BigDecimal.valueOf(185.6400));
        assertThat(response.getAskSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(response.getLastUpdated()).isEqualTo(1529689042490L);
        assertThat(response.getLastSalePrice()).usingComparator(BigDecimal::compareTo).isEqualTo(BigDecimal.valueOf(185.6300));
        assertThat(response.getLastSaleSize()).isEqualTo(BigDecimal.valueOf(100));
        assertThat(response.getLastSaleTime()).isEqualTo(1529689042476L);
        assertThat(response.getVolume()).isEqualTo(BigDecimal.valueOf(312038));
        assertThat(response.getMarketPercent()).usingComparator(BigDecimal::compareTo).isEqualTo(BigDecimal.valueOf(0.03250));
    }
}
