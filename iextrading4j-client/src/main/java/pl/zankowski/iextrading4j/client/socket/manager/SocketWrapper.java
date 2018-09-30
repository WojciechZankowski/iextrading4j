package pl.zankowski.iextrading4j.client.socket.manager;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;

public class SocketWrapper {

    private static final int RECONNECTION_ATTEMPTS = 32;
    private static final long RECONNECTION_DELAY = 10000;

    public Socket socket(final String uri, final boolean reconnect) throws URISyntaxException {
        return IO.socket(uri, createOptions(reconnect));
    }

    private IO.Options createOptions(final boolean reconnect) {
        final IO.Options options = new IO.Options();
        options.reconnection = reconnect;
        options.reconnectionAttempts = RECONNECTION_ATTEMPTS;
        options.reconnectionDelay = RECONNECTION_DELAY;
        return options;
    }

}
