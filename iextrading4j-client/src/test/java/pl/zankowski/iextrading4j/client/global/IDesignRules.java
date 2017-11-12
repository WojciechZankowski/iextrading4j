package pl.zankowski.iextrading4j.client.global;

import java.util.Set;

public interface IDesignRules {

    Scope getScope();

    Set<IDesignRule> getDesignRules();

    IDesignRule selectDesignRule(RuleCode ruleCode);

}
