package pl.zankowski.iextrading4j.test.design;

import org.junit.Rule;
import org.reflections.Reflections;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

public class AbstractViolationTests {

    protected void validate(RuleCode ruleCode, List<Reflections> reflectionsList, IDesignRules designRules) {
        final List<String> classNames = reflectionsList.stream()
                .map(ref -> validate(ref, ruleCode))
                .flatMap(Collection::stream)
                .collect(toList());
        assertTrue(getMessage(designRules.selectDesignRule(ruleCode), classNames),
                classNames == null || classNames.isEmpty());
    }

    private Collection<String> validate(Reflections reflections, RuleCode ruleCode) {
        return reflections.getStore().get("ViolationsScanner").get(ruleCode.getCodeName());
    }

    private String getMessage(IDesignRule designRule, Collection<String> violations) {
        if (designRule == null || violations == null || violations.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder()
                .append("\nRule:\n")
                .append(designRule.getDescription())
                .append("\n-------------\n")
                .append("Violations:\n");

        for (String violation : violations) {
            builder.append(violation).append("\n");
        }
        builder.append("\n----------------\n").append("Directions:\n").append(designRule.getDirections());

        return builder.toString();
    }

}
