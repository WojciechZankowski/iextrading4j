package pl.zankowski.iextrading4j.api.exception;

public class IEXTradingException extends RuntimeException {

    public static final String DEFAULT_PREFIX = "Message received from IEX Trading: ";

    private int status;

    public IEXTradingException(final String message) {
        super(DEFAULT_PREFIX + message);
    }

    public IEXTradingException(final String message, final int status) {
        super(DEFAULT_PREFIX + message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
