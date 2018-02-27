package pl.zankowski.iextrading4j.test.design.api;

import pl.zankowski.iextrading4j.test.design.RuleCode;
import pl.zankowski.iextrading4j.test.design.DesignRuleInput;

import java.lang.reflect.Method;

public class HasOverriddenEqualsHashCodeAndToStringDR extends AbstractApiDR {

    private static final String DESCRIPTION = "Every object in API should have custom hashCode, equals and toString methods";
    private static final String DIRECTIONS = "Generate custom hashCode, equals and toString methods using Guava library";
    private static final RuleCode CODE = RuleCode.API_OVERRIDDEN;

    @Override
    public void check(DesignRuleInput input) {
        if (!isEnum(input.getClazz()) && !isAbstract(input.getClazz()) && (!hasOverriddenEquals(input.getClazz())
                || !hasOverriddenHashCode(input.getClazz()) || !hasOverriddenToString(input.getClazz()))) {
            input.getStore().put(CODE.getCodeName(), input.getClazzName());
        }
    }

    private boolean hasOverriddenEquals(Class<?> clazz) {
        try {
            Method method = clazz.getMethod("equals", Object.class);
            return clazz == method.getDeclaringClass();
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private boolean hasOverriddenHashCode(Class<?> clazz) {
        try {
            Method method = clazz.getMethod("hashCode");
            return clazz == method.getDeclaringClass();
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private boolean hasOverriddenToString(Class<?> clazz) {
        try {
            Method method = clazz.getMethod("toString");
            return clazz == method.getDeclaringClass();
        } catch (NoSuchMethodException e) {
            return false;
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
