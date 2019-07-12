package pl.zankowski.iextrading4j.client.rest.request.options;

public enum OptionSide {

    PUT("put"),
    CALL("call");

    private final String name;

    OptionSide(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
