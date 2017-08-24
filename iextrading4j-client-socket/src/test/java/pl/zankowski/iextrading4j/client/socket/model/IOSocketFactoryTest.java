package pl.zankowski.iextrading4j.client.socket.model;

import io.socket.client.Socket;
import org.junit.Before;
import org.junit.Test;
import pl.zankowski.iextrading4j.client.socket.IOSocketFactory;
import pl.zankowski.iextrading4j.client.socket.IOSocketWrapper;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;

import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author Wojciech Zankowski
 */
public class IOSocketFactoryTest {

    private IOSocketFactory ioSocketFactory;

    private DataReceiver dataReceiverMock;
    private IOSocketWrapper ioSocketWrapperMock;
    private Socket socketMock;

    @Before
    public void setUp() {
        dataReceiverMock = mock(DataReceiver.class);
        ioSocketWrapperMock = mock(IOSocketWrapper.class);
        socketMock = mock(Socket.class);
        ioSocketFactory = new IOSocketFactory(ioSocketWrapperMock, dataReceiverMock);
    }

    @Test
    public void shouldTryToConnectToTOPSSocket() throws URISyntaxException {
        when(ioSocketWrapperMock.socket(any())).thenReturn(socketMock);
        when(socketMock.on(any(), any())).thenReturn(null);

        ioSocketFactory.initSocket(AsyncRequestType.TOPS);

        verify(ioSocketWrapperMock).socket(eq("https://ws-api.iextrading.com/1.0/tops"));
    }

    @Test
    public void shouldTryToConnectToLASTSocket() throws URISyntaxException {
        when(ioSocketWrapperMock.socket(any())).thenReturn(socketMock);
        when(socketMock.on(any(), any())).thenReturn(null);

        ioSocketFactory.initSocket(AsyncRequestType.LAST);

        verify(ioSocketWrapperMock).socket(eq("https://ws-api.iextrading.com/1.0/last"));
    }

}
