package pl.zankowski.iextrading4j.test.design.api;

import pl.zankowski.iextrading4j.test.design.RuleCode;
import pl.zankowski.iextrading4j.test.design.DesignRuleInput;

public class InheritsSerializableDR extends AbstractApiDR {

    private static final String DESCRIPTION = "Every object in API needs to implement Serializable";
    private static final String DIRECTIONS = "Please add Serializable implementation";
    private static final RuleCode CODE = RuleCode.API_SERIALIZABLE;

    @Override
    public void check(DesignRuleInput input) {
        if (!isEnum(input.getClazz()) && !inheritsSerializable(input.getClazz())) {
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
