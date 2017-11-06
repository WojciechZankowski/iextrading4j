package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;

public class VenueVolumeRequestBuilder extends AbstractStocksRequestBuilder<ArrayList<VenueVolume>, VenueVolumeRequestBuilder> {

    @Override
    public RestRequest<ArrayList<VenueVolume>> build() {
        return RestRequestBuilder.builder()
                .withPath("/stock/{symbol}/volume-by-venue")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<ArrayList<VenueVolume>>() {})
                .build();
    }

}
