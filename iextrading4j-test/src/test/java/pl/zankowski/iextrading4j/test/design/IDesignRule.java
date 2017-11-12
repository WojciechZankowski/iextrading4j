package pl.zankowski.iextrading4j.test.design;

public interface IDesignRule {

    void check(DesignRuleInput input);

    String getDescription();

    String getDirections();

    RuleCode getRuleCode();

}
