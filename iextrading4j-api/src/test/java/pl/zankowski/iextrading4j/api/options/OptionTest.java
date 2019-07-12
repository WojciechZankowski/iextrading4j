package pl.zankowski.iextrading4j.api.options;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final String expirationDate = fixture.create(String.class);
        final BigDecimal contractSize = fixture.create(BigDecimal.class);
        final BigDecimal strikePrice = fixture.create(BigDecimal.class);
        final BigDecimal closingPrice = fixture.create(BigDecimal.class);
        final String side = fixture.create(String.class);
        final String type = fixture.create(String.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal openInterest = fixture.create(BigDecimal.class);
        final BigDecimal bid = fixture.create(BigDecimal.class);
        final BigDecimal ask = fixture.create(BigDecimal.class);
        final LocalDate lastUpdated = fixture.create(LocalDate.class);

        final Option option = new Option(symbol, id, expirationDate, contractSize, strikePrice,
                closingPrice, side, type, volume, openInterest, bid, ask, lastUpdated);

        assertThat(option.getSymbol()).isEqualTo(symbol);
        assertThat(option.getId()).isEqualTo(id);
        assertThat(option.getExpirationDate()).isEqualTo(expirationDate);
        assertThat(option.getContractSize()).isEqualTo(contractSize);
        assertThat(option.getStrikePrice()).isEqualTo(strikePrice);
        assertThat(option.getClosingPrice()).isEqualTo(closingPrice);
        assertThat(option.getSide()).isEqualTo(side);
        assertThat(option.getType()).isEqualTo(type);
        assertThat(option.getVolume()).isEqualTo(volume);
        assertThat(option.getOpenInterest()).isEqualTo(openInterest);
        assertThat(option.getBid()).isEqualTo(bid);
        assertThat(option.getAsk()).isEqualTo(ask);
        assertThat(option.getLastUpdated()).isEqualTo(lastUpdated);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Option.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Option.class))
                .verify();
    }

}
