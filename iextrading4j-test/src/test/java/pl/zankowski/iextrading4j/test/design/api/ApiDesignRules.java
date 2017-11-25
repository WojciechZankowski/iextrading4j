package pl.zankowski.iextrading4j.test.design.api;

import pl.zankowski.iextrading4j.test.design.IDesignRule;
import pl.zankowski.iextrading4j.test.design.RuleCode;
import pl.zankowski.iextrading4j.test.design.Scope;
import pl.zankowski.iextrading4j.test.design.IDesignRules;

import java.util.HashSet;
import java.util.Set;

public class ApiDesignRules implements IDesignRules {

    private final Set<IDesignRule> designRules;

    public ApiDesignRules() {
        designRules = new HashSet<>();
        designRules.add(new HasJsonAnnotationsDR());
        designRules.add(new HasOneConstructorDR());
        designRules.add(new HasOverriddenEqualsHashCodeAndToStringDR());
        designRules.add(new InheritsSerializableDR());
    }

    @Override
    public Scope getScope() {
        return Scope.API;
    }

    @Override
    public Set<IDesignRule> getDesignRules() {
        return designRules;
    }

    @Override
    public IDesignRule selectDesignRule(RuleCode ruleCode) {
        for (IDesignRule designRule : designRules) {
            if (ruleCode.equals(designRule.getRuleCode())) {
                return designRule;
            }
        }

        return null;
    }
}
