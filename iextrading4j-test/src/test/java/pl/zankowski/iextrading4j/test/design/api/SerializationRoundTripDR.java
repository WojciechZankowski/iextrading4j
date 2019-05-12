package pl.zankowski.iextrading4j.test.design.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flextrade.jfixture.JFixture;
import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;
import pl.zankowski.iextrading4j.test.design.DesignRuleInput;
import pl.zankowski.iextrading4j.test.design.RuleCode;

import java.io.IOException;

public class SerializationRoundTripDR extends AbstractApiDR {

    private static final String DESCRIPTION = "Every object in API should properly pass serialization roundtrip";
    private static final String DIRECTIONS = "Be sure that object is deserialized in the proper way";
    private static final RuleCode CODE = RuleCode.API_SERIALIZATION_ROUNDTRIP;

    private final ObjectMapper objectMapper = new IEXTradingMapperContextResolver().getContext(null);
    private final JFixture fixture = new JFixture();

    @Override
    public void check(final DesignRuleInput input) {
        if (!isEnum(input.getClazz()) && isConcreteClass(input.getClazz()) && !hasPassedRoundTrip(input.getClazz())) {
            input.getStore().put(CODE.getCodeName(), input.getClazzName());
        }
    }

    private boolean hasPassedRoundTrip(final Class<?> clazz) {
        try {
            final Object object = fixture.create(clazz);
            final String objectJson = objectMapper.writeValueAsString(object);
            final Object serializedObject = objectMapper.readValue(objectJson, clazz);

            final boolean result = object.equals(serializedObject);
            if (result) {
                return true;
            }
            System.out.println(new StringBuilder().append(object).append("\n").append(objectJson).append("\n").append(serializedObject));
            return false;
        } catch (final IOException e) {
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
