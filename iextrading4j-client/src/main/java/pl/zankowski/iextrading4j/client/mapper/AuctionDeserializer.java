package pl.zankowski.iextrading4j.client.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.zankowski.iextrading4j.api.marketdata.Auction;

import java.io.IOException;

public class AuctionDeserializer extends JsonDeserializer<Auction> {

    @Override
    public Auction deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final String value = p.getValueAsString();

        if (value == null) {
            return null;
        }

        return p.readValueAs(Auction.class);
    }

}
