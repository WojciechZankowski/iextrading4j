package pl.zankowski.iextrading.client;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class SocketIOConnectionProvider {

    public static void main(String[] args) throws URISyntaxException {
        Socket socket = IO.socket("https://ws-api.iextrading.com/1.0/tops");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                socket.emit("subscribe", "ibm");
            }

        }).on("message", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Arrays.stream(args).forEach(System.out::println);
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Arrays.stream(args).forEach(System.out::println);
            }

        });
        socket.connect();
    }

}
