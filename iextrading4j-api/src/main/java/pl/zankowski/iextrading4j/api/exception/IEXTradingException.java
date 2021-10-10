package pl.zankowski.iextrading4j.api.exception;

public class IEXTradingException extends RuntimeException {

    public static final String DEFAULT_PREFIX = "Message received from IEX Trading: ";

    private static final long serialVersionUID = -9007556226626660146L;

    private final Integer status;

    public IEXTradingException(final String message) {
        this(DEFAULT_PREFIX + message, null);
    }

    public IEXTradingException(final String message, final Integer status) {
        super(DEFAULT_PREFIX + message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
