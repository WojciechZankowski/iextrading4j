package pl.zankowski.iextrading4j.client.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Wojciech Zankowski
 */
@Provider
public class LocalDateObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public LocalDateObjectMapperContextResolver() {
        objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(double.class, new EmptyStringDeserializer());
        objectMapper.registerModule(javaTimeModule);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class type) {
        return objectMapper;
    }

    public class EmptyStringDeserializer extends StdScalarDeserializer<Double> {
        public EmptyStringDeserializer() {
            super(double.class);
        }

        @Override
        public Double deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
            final String val = parser.getValueAsString();

            if ("N/A".equalsIgnoreCase(val)) {
                return 0d;
            }

            return parser.getDoubleValue();
        }
    }

}
