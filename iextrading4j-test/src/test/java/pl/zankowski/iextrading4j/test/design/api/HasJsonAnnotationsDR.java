package pl.zankowski.iextrading4j.test.design.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.zankowski.iextrading4j.test.design.RuleCode;
import pl.zankowski.iextrading4j.test.design.DesignRuleInput;

import java.lang.annotation.Annotation;

public class HasJsonAnnotationsDR extends AbstractApiDR {

    private static final String DESCRIPTION = "Every object in API should have constructor annotated with @JsonCreator " +
            "and its parameters should be annotated with @JsonProperty.";
    private static final String DIRECTIONS = "Please adjust your constructor.";
    private static final RuleCode CODE = RuleCode.API_ANNOTATED;

    @Override
    public void check(DesignRuleInput input) {
        if (!isEnum(input.getClazz()) && !isAbstract(input.getClazz()) && hasOneConstructor(input.getClazz())
                && (!isAnnotated(input.getClazz()) || !hasValidParameterAnnotations(input.getClazz()))) {
            input.getStore().put(CODE.getCodeName(), input.getClazzName());
        }
    }

    private boolean isAnnotated(Class<?> clazz) {
        return clazz.getDeclaredConstructors()[0].isAnnotationPresent(JsonCreator.class);
    }

    private boolean hasValidParameterAnnotations(Class<?> clazz) {
        boolean valid = true;
        Annotation[][] annotations = clazz.getDeclaredConstructors()[0].getParameterAnnotations();

        for (int i = 0; i < annotations.length; i++) {
            boolean found = false;
            for (int j = 0; j < annotations[i].length; j++) {
                found |= annotations[i][j].annotationType().equals(JsonProperty.class);
            }
            valid &= found;
        }

        return valid;
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
