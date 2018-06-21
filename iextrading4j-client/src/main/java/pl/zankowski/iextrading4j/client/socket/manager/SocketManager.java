package pl.zankowski.iextrading4j.client.socket.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import io.socket.client.Socket;
import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

public class SocketManager {

    private final Map<SocketRequest, Socket> socketStore = Maps.newHashMap();

    private final SocketWrapper socketWrapper;
    private final ObjectMapper objectMapper;

    public SocketManager(final SocketWrapper socketWrapper) {
        this.socketWrapper = socketWrapper;
        this.objectMapper = new IEXTradingMapperContextResolver().getContext(SocketManager.class);
    }

    public <T> void subscribe(final SocketRequest<T> request, final Consumer<T> consumer) {
        final String url = createURL(request);

        try {
            if (socketStore.containsKey(request)) {
                return;
            }

            final Socket socket = socketWrapper.socket(url).connect();
            socket.emit("subscribe", mapParam(request.getParam()))
                    .on("message", args -> processResponse(args, request, consumer));

            socketStore.put(request, socket);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private String mapParam(final Object param) throws JsonProcessingException {
        if (param instanceof String) {
            return String.valueOf(param);
        }
        return objectMapper.writeValueAsString(param);
    }

    public <T> void unsubscribe(final SocketRequest<T> request) {
        final Socket socket = socketStore.remove(request);
        if (socket == null) {
            return;
        }

        socket.disconnect();
    }

    private <T> void processResponse(final Object[] args, final SocketRequest<T> request, final Consumer<T> consumer) {
        Arrays.stream(args).forEach(arg -> {
            try {
                consumer.accept(mapObject(arg, request));
            } catch (IOException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        });
    }

    private <T> T mapObject(final Object arg, final SocketRequest<T> request) throws IOException {
        return objectMapper.readValue(String.valueOf(arg), request.getResponseType());
    }

    private <R> String createURL(final SocketRequest<R> restRequest) {
        return new StringBuilder()
                .append(getServicePath())
                .append(restRequest.getPath())
                .toString();
    }

    private String getServicePath() {
        return "https://ws-api.iextrading.com/1.0";
    }

}
