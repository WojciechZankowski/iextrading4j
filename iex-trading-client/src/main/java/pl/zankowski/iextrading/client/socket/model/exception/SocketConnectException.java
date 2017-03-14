package pl.zankowski.iextrading.client.socket.model.exception;

/**
 * @author Wojciech Zankowski
 */
public class SocketConnectException extends Exception {

    public SocketConnectException() {
    }

    public SocketConnectException(String message) {
        super(message);
    }

}
