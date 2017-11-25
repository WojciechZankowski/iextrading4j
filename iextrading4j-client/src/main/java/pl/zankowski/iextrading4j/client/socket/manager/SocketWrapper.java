package pl.zankowski.iextrading4j.client.socket.manager;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;

public class SocketWrapper {

    public Socket socket(String uri) throws URISyntaxException {
        return IO.socket(uri);
    }

}
