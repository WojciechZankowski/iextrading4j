package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.DeepResult;
import pl.zankowski.iextrading4j.api.marketdata.OpHaltStatus;
import pl.zankowski.iextrading4j.api.marketdata.SecurityEvent;
import pl.zankowski.iextrading4j.api.marketdata.SsrStatus;
import pl.zankowski.iextrading4j.api.marketdata.SystemEvent;
import pl.zankowski.iextrading4j.api.marketdata.Trade;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatus;

import java.io.Serializable;

@JsonPropertyOrder({"symbol", "messageType", "data", "seq"})
public class DeepAsyncResponse<T extends DeepResult> implements Serializable {

    private final String symbol;
    private final DeepMessageType messageType;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "messageType", visible = true)
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Auction.class, name = "auction"),
            @JsonSubTypes.Type(value = Book.class, name = "book"),
            @JsonSubTypes.Type(value = OpHaltStatus.class, name = "ophaltstatus"),
            @JsonSubTypes.Type(value = SecurityEvent.class, name = "securityevent"),
            @JsonSubTypes.Type(value = SsrStatus.class, name = "ssr"),
            @JsonSubTypes.Type(value = SystemEvent.class, name = "systemevent"),
            @JsonSubTypes.Type(value = TradingStatus.class, name = "tradingstatus"),
            @JsonSubTypes.Type(value = Trade.class, name = "trades"),
            @JsonSubTypes.Type(value = Trade.class, name = "tradebreak")
    })
    private final T data;
    private final Long seq;

    @JsonCreator
    public DeepAsyncResponse(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("messageType") final String messageType,
            @JsonProperty("data") final T data,
            @JsonProperty("seq") final Long seq) {
        this.symbol = symbol;
        this.messageType = DeepMessageType.getMessageType(messageType);
        this.data = data;
        this.seq = seq;
    }

    public String getSymbol() {
        return symbol;
    }

    public DeepMessageType getMessageType() {
        return messageType;
    }

    public T getData() {
        return data;
    }

    public Long getSeq() {
        return seq;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DeepAsyncResponse<?> that = (DeepAsyncResponse<?>) o;
        return Objects.equal(symbol, that.symbol) &&
                messageType == that.messageType &&
                Objects.equal(data, that.data) &&
                Objects.equal(seq, that.seq);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, messageType, data, seq);
    }

    @Override
    public String toString() {
        return "DeepAsyncResponse{" +
                "symbol='" + symbol + '\'' +
                ", messageType=" + messageType +
                ", data=" + data +
                ", seq=" + seq +
                '}';
    }
}
