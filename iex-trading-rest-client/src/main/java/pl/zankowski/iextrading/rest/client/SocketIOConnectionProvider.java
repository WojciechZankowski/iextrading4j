package pl.zankowski.iextrading.rest.client;

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
                System.out.println("EVENT CONNECt");
                Arrays.stream(args).forEach(System.out::println);
                socket.emit("subscribe", "ibm", new Ack() {
                            @Override
                            public void call(Object... args) {
                                System.out.println("ACK");
                                Arrays.stream(args).forEach(System.out::println);
                            }
                        });
//                socket.disconnect();
            }

        }).on("message", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Arrays.stream(args).forEach(System.out::println);
            }

        }).on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Arrays.stream(args).forEach(System.out::println);
            }

        }).on(Socket.EVENT_ERROR, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Arrays.stream(args).forEach(System.out::println);
            }

        });
        socket.connect();
    }

}
