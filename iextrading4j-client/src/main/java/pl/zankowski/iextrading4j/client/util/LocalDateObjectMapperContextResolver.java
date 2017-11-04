package pl.zankowski.iextrading4j.client.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import pl.zankowski.iextrading4j.api.marketdata.Auction;

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
        objectMapper.registerModule(newModule());
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

    private Module newModule() {
        SimpleModule simpleModule = new SimpleModule();

        simpleModule.addDeserializer(Auction.class, new AuctionDeserializer());

        return simpleModule;
    }

    private class AuctionDeserializer extends JsonDeserializer<Auction> {

        @Override
        public Auction deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            final String value = p.getValueAsString();
            if (value == null) {
                return null;
            }
            return p.readValueAs(Auction.class);
        }
    }

}
