package pl.zankowski.iextrading4j.client.sse.manager;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class SseManagerTest {

    private SseClient sseClientMock;
    private SseManager sseManager;

    @BeforeEach
    public void setUp() {
        sseClientMock = mock(SseClient.class);
        sseManager = new SseManager(sseClientMock);
    }

}
