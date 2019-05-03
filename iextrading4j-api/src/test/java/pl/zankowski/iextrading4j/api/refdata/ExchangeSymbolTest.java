package pl.zankowski.iextrading4j.api.refdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeSymbolTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final Boolean isEnabled = fixture.create(Boolean.class);
        final SymbolType type = fixture.create(SymbolType.class);
        final String iexId = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String currency = fixture.create(String.class);

        final ExchangeSymbol exchangeSymbol = new ExchangeSymbol(symbol, name, date, isEnabled, type, iexId, region,
                currency);

        assertThat(exchangeSymbol.getSymbol()).isEqualTo(symbol);
        assertThat(exchangeSymbol.getName()).isEqualTo(name);
        assertThat(exchangeSymbol.getDate()).isEqualTo(date);
        assertThat(exchangeSymbol.isEnabled()).isEqualTo(isEnabled);
        assertThat(exchangeSymbol.getType()).isEqualTo(type);
        assertThat(exchangeSymbol.getIexId()).isEqualTo(iexId);
        assertThat(exchangeSymbol.getCurrency()).isEqualTo(currency);
        assertThat(exchangeSymbol.getRegion()).isEqualTo(region);
    }

    @Test
    public void testBaseDeserialization() throws Exception {
        final String symbol = "A";
        final String name = "Agilent Technologies Inc.";
        final LocalDate date = LocalDate.of(2019, 3, 7);
        final Boolean isEnabled = true;
        final String iexId = "IEX_46574843354B2D52";
        final String region = "US";
        final String currency = "USD";
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        final ExchangeSymbol mappedExchangeSymbol = mapper.readValue(this.getClass().getResourceAsStream("sample-ref-data.json"), ExchangeSymbol.class);

        assertThat(mappedExchangeSymbol.getSymbol()).isEqualTo(symbol);
        assertThat(mappedExchangeSymbol.getName()).isEqualTo(name);
        assertThat(mappedExchangeSymbol.getDate()).isEqualTo(date);
        assertThat(mappedExchangeSymbol.isEnabled()).isEqualTo(isEnabled);
        assertThat(mappedExchangeSymbol.getIexId()).isEqualTo(iexId);
        assertThat(mappedExchangeSymbol.getCurrency()).isEqualTo(currency);
        assertThat(mappedExchangeSymbol.getRegion()).isEqualTo(region);
    }

    @Test
    public void testSerializationRoundTrip() throws Exception {
        final String symbol = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final LocalDate date = fixture.create(LocalDate.class);
        final Boolean isEnabled = fixture.create(Boolean.class);
        final SymbolType type = fixture.create(SymbolType.class);
        final String iexId = fixture.create(String.class);
        final String region = fixture.create(String.class);
        final String currency = fixture.create(String.class);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        final String serializedValue = mapper.writeValueAsString(new ExchangeSymbol(symbol, name, date, isEnabled, type, iexId,
                region, currency));
        final ExchangeSymbol mappedExchangeSymbol = mapper.readValue(serializedValue, ExchangeSymbol.class);

        assertThat(mappedExchangeSymbol.getSymbol()).isEqualTo(symbol);
        assertThat(mappedExchangeSymbol.getName()).isEqualTo(name);
        assertThat(mappedExchangeSymbol.getDate()).isEqualTo(date);
        assertThat(mappedExchangeSymbol.isEnabled()).isEqualTo(isEnabled);
        assertThat(mappedExchangeSymbol.getType()).isEqualTo(type);
        assertThat(mappedExchangeSymbol.getIexId()).isEqualTo(iexId);
        assertThat(mappedExchangeSymbol.getCurrency()).isEqualTo(currency);
        assertThat(mappedExchangeSymbol.getRegion()).isEqualTo(region);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ExchangeSymbol.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(ExchangeSymbol.class))
                .verify();
    }

}
