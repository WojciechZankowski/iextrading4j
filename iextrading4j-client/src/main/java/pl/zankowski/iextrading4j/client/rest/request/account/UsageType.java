package pl.zankowski.iextrading4j.client.rest.request.account;

public enum UsageType {

    MESSAGES("messages"),
    RULES("rules"),
    RULE_RECORDS("rule-records"),
    ALERTS("alerts"),
    ALERT_RECORDS("alert-records");

    private final String type;

    UsageType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
