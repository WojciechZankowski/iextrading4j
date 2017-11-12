package pl.zankowski.iextrading4j.client.global.api;

import pl.zankowski.iextrading4j.client.global.IDesignRule;
import pl.zankowski.iextrading4j.client.global.IDesignRules;
import pl.zankowski.iextrading4j.client.global.RuleCode;
import pl.zankowski.iextrading4j.client.global.Scope;

import java.util.HashSet;
import java.util.Set;

import static pl.zankowski.iextrading4j.client.global.Scope.API;

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
        return API;
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
