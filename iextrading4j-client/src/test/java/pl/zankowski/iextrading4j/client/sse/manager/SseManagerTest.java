package pl.zankowski.iextrading4j.client.sse.manager;

import org.junit.Before;

import static org.mockito.Mockito.mock;

public class SseManagerTest {

    private SseClient sseClientMock;
    private SseManager sseManager;

    @Before
    public void setUp() {
        sseClientMock = mock(SseClient.class);
        sseManager = new SseManager(sseClientMock);
    }



}
