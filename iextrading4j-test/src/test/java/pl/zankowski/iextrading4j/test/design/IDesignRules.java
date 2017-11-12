package pl.zankowski.iextrading4j.test.design;

import java.util.Set;

public interface IDesignRules {

    Scope getScope();

    Set<IDesignRule> getDesignRules();

    IDesignRule selectDesignRule(RuleCode ruleCode);

}
