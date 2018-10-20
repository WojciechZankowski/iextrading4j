package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.BatchStocks;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchMarketStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.BatchStocksType;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class BatchStocksServiceTest extends BaseRestServiceTest {

    @Test
    public void batchStocksServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/batch?types=company"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/BatchStocksResponse.json")));

        final BatchStocks batchStocks = iexTradingClient.executeRequest(new BatchStocksRequestBuilder()
                .addType(BatchStocksType.COMPANY)
                .withSymbol("aapl")
                .build());

        final Company company = batchStocks.getCompany();
        assertThat(company.getSymbol()).isEqualTo("AAPL");
        assertThat(company.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(company.getExchange()).isEqualTo("Nasdaq Global Select");
        assertThat(company.getIndustry()).isEqualTo("Computer Hardware");
        assertThat(company.getWebsite()).isEqualTo("http://www.apple.com");
        assertThat(company.getCEO()).isEqualTo("Timothy D. Cook");
        assertThat(company.getIssueType()).isEqualTo("cs");
        assertThat(company.getSector()).isEqualTo("Technology");
        assertThat(company.getTags()).containsExactly("Technology", "Consumer Electronics", "Computer Hardware");
    }

    @Test
    public void batchMarketStocksServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/batch?types=company&symbols=aapl"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/BatchMarketStocksResponse.json")));

        final Map<String, BatchStocks> batchStocksMap = iexTradingClient.executeRequest(new BatchMarketStocksRequestBuilder()
                .addType(BatchStocksType.COMPANY)
                .withSymbol("aapl")
                .build());

        final BatchStocks batchStocks = batchStocksMap.get("AAPL");
        final Company company = batchStocks.getCompany();
        assertThat(company.getSymbol()).isEqualTo("AAPL");
        assertThat(company.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(company.getExchange()).isEqualTo("Nasdaq Global Select");
        assertThat(company.getIndustry()).isEqualTo("Computer Hardware");
        assertThat(company.getWebsite()).isEqualTo("http://www.apple.com");
        assertThat(company.getCEO()).isEqualTo("Timothy D. Cook");
        assertThat(company.getIssueType()).isEqualTo("cs");
        assertThat(company.getSector()).isEqualTo("Technology");
        assertThat(company.getTags()).containsExactly("Technology", "Consumer Electronics", "Computer Hardware");
    }

}
