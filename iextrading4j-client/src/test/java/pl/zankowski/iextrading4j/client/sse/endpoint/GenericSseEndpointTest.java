package pl.zankowski.iextrading4j.client.sse.endpoint;

import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.sse.manager.SseManager;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.TopsSseRequestBuilder;

import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GenericSseEndpointTest {

    private GenericSseEndpoint genericSseEndpoint;
    private SseManager sseManagerMock;

    @Before
    public void setUp() {
        sseManagerMock = mock(SseManager.class);
        genericSseEndpoint = new GenericSseEndpoint(sseManagerMock);
    }

    @Test
    public void shouldSuccessfullySubscribe() {
        final SseRequest<TOPS> request = new TopsSseRequestBuilder().build();
        final Consumer<TOPS> topsConsumer = mock(Consumer.class);

        genericSseEndpoint.subscribe(request, topsConsumer);

        verify(sseManagerMock).subscribe(eq(request), eq(topsConsumer));
    }

    @Test
    public void shouldSuccessfullyUnsubscribe() {
        final SseRequest<TOPS> request = new TopsSseRequestBuilder().build();

        genericSseEndpoint.unsubscribe(request);

        verify(sseManagerMock).unsubscribe(eq(request));
    }

}
