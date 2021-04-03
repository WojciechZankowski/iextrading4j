package pl.zankowski.iextrading4j.test.design.api;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import pl.zankowski.iextrading4j.test.design.AbstractViolationTests;
import pl.zankowski.iextrading4j.test.design.IDesignRules;
import pl.zankowski.iextrading4j.test.design.RuleCode;
import pl.zankowski.iextrading4j.test.design.ViolationsScanner;

import java.util.List;

public class ApiObjectTest extends AbstractViolationTests {

    private static List<Reflections> REFLECTIONS;
    private static IDesignRules DESIGN_RULES;

    @BeforeAll
    public static void setUpAll() {
        DESIGN_RULES = new ApiDesignRules();

        final ViolationsScanner violationsScanner = new ViolationsScanner(DESIGN_RULES);
        REFLECTIONS = Lists.newArrayList(
                new Reflections("pl.zankowski.iextrading4j.api.account", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.alternative", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.forex", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.market", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.marketdata", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.refdata", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.stats", violationsScanner),
                new Reflections("pl.zankowski.iextrading4j.api.stocks", violationsScanner));
    }

    @Test
    void inheritanceTest() {
        validate(RuleCode.API_SERIALIZABLE, REFLECTIONS, DESIGN_RULES);
    }

    @Test
    void annotationsTest() {
        validate(RuleCode.API_ANNOTATED, REFLECTIONS, DESIGN_RULES);
    }

    @Test
    void constructorsTest() {
        validate(RuleCode.API_ONE_CONSTRUCTOR, REFLECTIONS, DESIGN_RULES);
    }

    @Test
    void overriddenTest() {
        validate(RuleCode.API_OVERRIDDEN, REFLECTIONS, DESIGN_RULES);
    }

    @Test
    void serializationUidTest() {
        validate(RuleCode.API_SERIALIZATION_UID, REFLECTIONS, DESIGN_RULES);
    }

    @Disabled("For local testing")
    @Test
    void serializationRoundtripTest() {
        validate(RuleCode.API_SERIALIZATION_ROUNDTRIP, REFLECTIONS, DESIGN_RULES);
    }

}
