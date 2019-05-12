package pl.zankowski.iextrading4j.test.design.api;

import pl.zankowski.iextrading4j.test.design.DesignRuleInput;
import pl.zankowski.iextrading4j.test.design.RuleCode;

import java.lang.reflect.Field;

public class HasSerializationUidDR extends AbstractApiDR {

    private static final String DESCRIPTION = "Every object in API should have serialization uid";
    private static final String DIRECTIONS = "Generate serialization uid using IDE";
    private static final RuleCode CODE = RuleCode.API_SERIALIZATION_UID;

    @Override
    public void check(final DesignRuleInput input) {
        if (!isEnum(input.getClazz()) && isConcreteClass(input.getClazz())
                && !hasSerializationUidField(input.getClazz())) {
            input.getStore().put(CODE.getCodeName(), input.getClazzName());
        }
    }

    private boolean hasSerializationUidField(final Class<?> clazz) {
        if (clazz.getDeclaredFields().length == 0) {
            return false;
        }
        for (final Field field : clazz.getDeclaredFields()) {
            if ("serialVersionUID".equals(field.getName())) {
                return true;
            }
        }
        return false;
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
