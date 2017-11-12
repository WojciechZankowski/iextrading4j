package pl.zankowski.iextrading4j.client.global;

public interface IDesignRule {

    void check(DesignRuleInput input);

    String getDescription();

    String getDirections();

    RuleCode getRuleCode();

}
