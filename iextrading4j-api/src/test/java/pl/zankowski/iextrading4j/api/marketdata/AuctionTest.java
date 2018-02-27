package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AuctionTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final AuctionType auctionType = fixture.create(AuctionType.class);
        final BigDecimal pairedShares = fixture.create(BigDecimal.class);
        final BigDecimal imbalanceShares = fixture.create(BigDecimal.class);
        final BigDecimal referencePrice = fixture.create(BigDecimal.class);
        final BigDecimal indicativePrice = fixture.create(BigDecimal.class);
        final BigDecimal auctionBookPrice = fixture.create(BigDecimal.class);
        final BigDecimal collarReferencePrice = fixture.create(BigDecimal.class);
        final BigDecimal lowerCollarPrice = fixture.create(BigDecimal.class);
        final BigDecimal upperCollarPrice = fixture.create(BigDecimal.class);
        final BigDecimal extensionNumber = fixture.create(BigDecimal.class);
        final LocalTime startTime = fixture.create(LocalTime.class);
        final Long lastUpdate = fixture.create(Long.class);

        final Auction auction = new Auction(auctionType, pairedShares, imbalanceShares, referencePrice,
                indicativePrice, auctionBookPrice, collarReferencePrice, lowerCollarPrice, upperCollarPrice,
                extensionNumber, startTime, lastUpdate);

        assertThat(auction.getAuctionType()).isEqualTo(auctionType);
        assertThat(auction.getPairedShares()).isEqualTo(pairedShares);
        assertThat(auction.getImbalanceShares()).isEqualTo(imbalanceShares);
        assertThat(auction.getReferencePrice()).isEqualTo(referencePrice);
        assertThat(auction.getIndicativePrice()).isEqualTo(indicativePrice);
        assertThat(auction.getAuctionBookPrice()).isEqualTo(auctionBookPrice);
        assertThat(auction.getCollarReferencePrice()).isEqualTo(collarReferencePrice);
        assertThat(auction.getLowerCollarPrice()).isEqualTo(lowerCollarPrice);
        assertThat(auction.getUpperCollarPrice()).isEqualTo(upperCollarPrice);
        assertThat(auction.getExtensionNumber()).isEqualTo(extensionNumber);
        assertThat(auction.getStartTime()).isEqualTo(startTime);
        assertThat(auction.getLastUpdate()).isEqualTo(lastUpdate);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Auction.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Auction.class))
                .verify();
    }

}
