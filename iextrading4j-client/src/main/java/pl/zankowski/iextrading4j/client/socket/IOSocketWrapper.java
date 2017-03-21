package pl.zankowski.iextrading4j.client.socket;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;

/**
 * @author Wojciech Zankowski
 */
public class IOSocketWrapper {

    public Socket socket(String uri) throws URISyntaxException {
        return IO.socket(uri);
    }

}
