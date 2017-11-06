package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.marketdata.HIST;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.HistRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SymbolsRequestBuilder extends AbstractRequestFilterBuilder<ArrayList<ExchangeSymbol>, HistRequestBuilder> {

    @Override
    public RestRequest<ArrayList<ExchangeSymbol>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/ref-data/symbols").get()
                .withResponse(new GenericType<ArrayList<ExchangeSymbol>>() {});

        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }
}
