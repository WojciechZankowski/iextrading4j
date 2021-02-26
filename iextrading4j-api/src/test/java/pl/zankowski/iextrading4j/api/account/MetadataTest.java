package pl.zankowski.iextrading4j.api.account;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class MetadataTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final Boolean overagesEnabled = fixture.create(Boolean.class);
        final Long effectiveDate = fixture.create(Long.class);
        final Long endDateEffective = fixture.create(Long.class);
        final String subscriptionTermType = fixture.create(String.class);
        final String tierName = fixture.create(String.class);
        final Long messageLimit = fixture.create(Long.class);
        final Long creditLimit = fixture.create(Long.class);
        final Long messagesUsed = fixture.create(Long.class);
        final Long creditsUsed = fixture.create(Long.class);
        final Long circuitBreaker = fixture.create(Long.class);

        final Metadata metadata = new Metadata(overagesEnabled, effectiveDate, endDateEffective,
                subscriptionTermType, tierName, messageLimit, creditLimit, messagesUsed, creditsUsed, circuitBreaker);

        assertThat(metadata.getPayAsYouGoEnabled()).isEqualTo(overagesEnabled);
        assertThat(metadata.getEffectiveDate()).isEqualTo(effectiveDate);
        assertThat(metadata.getEndDateEffective()).isEqualTo(endDateEffective);
        assertThat(metadata.getSubscriptionTermType()).isEqualTo(subscriptionTermType);
        assertThat(metadata.getTierName()).isEqualTo(tierName);
        assertThat(metadata.getMessageLimit()).isEqualTo(messageLimit);
        assertThat(metadata.getCreditLimit()).isEqualTo(creditLimit);
        assertThat(metadata.getMessagesUsed()).isEqualTo(messagesUsed);
        assertThat(metadata.getCreditsUsed()).isEqualTo(creditsUsed);
        assertThat(metadata.getCircuitBreaker()).isEqualTo(circuitBreaker);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Metadata.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Metadata.class))
                .verify();
    }

}
