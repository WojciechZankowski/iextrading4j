package pl.zankowski.iextrading4j.test.design.api;

import pl.zankowski.iextrading4j.test.design.RuleCode;
import pl.zankowski.iextrading4j.test.design.DesignRuleInput;

public class HasOneConstructorDR extends AbstractApiDR {

    private static final String DESCRIPTION = "Every object in API can has only one constructor.";
    private static final String DIRECTIONS = "Please be sure that object has only one constructor";
    private static final RuleCode CODE = RuleCode.API_ONE_CONSTRUCTOR;

    @Override
    public void check(DesignRuleInput input) {
        if (!isEnum(input.getClazz()) && !hasOneConstructor(input.getClazz()) && !isAbstract(input.getClazz())) {
            input.getStore().put(CODE.getCodeName(), input.getClazzName());
        }
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public String getDirections() {
        return DIRECTIONS;
    }

    @Override
    public RuleCode getRuleCode() {
        return CODE;
    }

}
