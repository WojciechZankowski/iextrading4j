package pl.zankowski.iextrading4j.client.sse.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.TOPS;
import pl.zankowski.iextrading4j.client.sse.manager.SseManager;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.request.marketdata.TopsSseRequestBuilder;

import java.util.List;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GenericSseEndpointTest {

    private GenericSseEndpoint genericSseEndpoint;
    private SseManager sseManagerMock;

    @BeforeEach
    public void setUp() {
        sseManagerMock = mock(SseManager.class);
        genericSseEndpoint = new GenericSseEndpoint(sseManagerMock);
    }

    @Test
    public void shouldSuccessfullySubscribe() {
        final SseRequest<List<TOPS>> request = new TopsSseRequestBuilder().build();
        final Consumer<List<TOPS>> topsConsumer = mock(Consumer.class);

        genericSseEndpoint.subscribe(request, topsConsumer);

        verify(sseManagerMock).subscribe(eq(request), eq(topsConsumer));
    }

    @Test
    public void shouldSuccessfullyUnsubscribe() {
        final SseRequest<List<TOPS>> request = new TopsSseRequestBuilder().build();

        genericSseEndpoint.unsubscribe(request);

        verify(sseManagerMock).unsubscribe(eq(request));
    }

}
