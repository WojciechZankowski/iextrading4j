package pl.zankowski.iextrading4j.api.account;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class UsageTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final Long monthlyUsage = fixture.create(Long.class);
        final Long monthlyPayAsYouGo = fixture.create(Long.class);
        final Map<String, Long> dailyUsage = fixture.collections().createMap(String.class, Long.class);
        final Map<String, Long> tokenUsage = fixture.collections().createMap(String.class, Long.class);
        final Map<String, Long> keyUsage = fixture.collections().createMap(String.class, Long.class);

        final Usage usage = new Usage(monthlyUsage, monthlyPayAsYouGo, dailyUsage, tokenUsage, keyUsage);

        assertThat(usage.getMonthlyUsage()).isEqualTo(monthlyUsage);
        assertThat(usage.getMonthlyPayAsYouGo()).isEqualTo(monthlyPayAsYouGo);
        assertThat(usage.getDailyUsage()).isEqualTo(dailyUsage);
        assertThat(usage.getTokenUsage()).isEqualTo(tokenUsage);
        assertThat(usage.getKeyUsage()).isEqualTo(keyUsage);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Usage.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Usage.class))
                .verify();
    }

}
