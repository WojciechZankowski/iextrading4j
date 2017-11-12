package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.SystemEventType;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusReasonType;
import pl.zankowski.iextrading4j.api.marketdata.TradingStatusType;
import pl.zankowski.iextrading4j.api.stocks.DividendQualification;
import pl.zankowski.iextrading4j.api.stocks.DividendType;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Provider
public class IEXTradingMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public IEXTradingMapperContextResolver() {
        objectMapper = initializeObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }

    private ObjectMapper initializeObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(iexTradingModule());

        return objectMapper;
    }

    private Module iexTradingModule() {
        final SimpleModule module = new SimpleModule("iexTradingModule");

        module.addDeserializer(BigDecimal.class, new EmptyStringDeserializer());
        module.addDeserializer(Auction.class, new AuctionDeserializer());

        module.addSerializer(SystemEventType.class, new SystemEventTypeSerializer());
        module.addDeserializer(SystemEventType.class, new SystemEventTypeDeserializer());

        module.addSerializer(TradingStatusType.class, new TradingStatusTypeSerializer());
        module.addDeserializer(TradingStatusType.class, new TradingStatusTypeDeserializer());

        module.addSerializer(TradingStatusReasonType.class, new TradingStatusReasonTypeSerializer());
        module.addDeserializer(TradingStatusReasonType.class, new TradingStatusReasonTypeDeserializer());

        module.addSerializer(DividendQualification.class, new DividendQualificationSerializer());
        module.addDeserializer(DividendQualification.class, new DividendQualificationDeserializer());

        module.addSerializer(DividendType.class, new DividendTypeSerializer());
        module.addDeserializer(DividendType.class, new DividendTypeDeserializer());

        return module;
    }

}
