package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class VenueVolumeRequestBuilder extends AbstractStocksRequestBuilder<List<VenueVolume>, VenueVolumeRequestBuilder> {

    @Override
    public RestRequest<List<VenueVolume>> build() {
        return RestRequestBuilder.<List<VenueVolume>>builder()
                .withPath("/stock/{symbol}/volume-by-venue")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<VenueVolume>>() {})
                .build();
    }

}
