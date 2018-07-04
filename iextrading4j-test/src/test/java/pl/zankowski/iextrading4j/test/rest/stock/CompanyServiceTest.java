package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Company;
import pl.zankowski.iextrading4j.client.rest.request.stocks.CompanyRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class CompanyServiceTest extends BaseRestServiceTest {

    @Test
    public void companyServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/company"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/CompanyResponse.json")));

        final Company company = iexTradingClient.executeRequest(new CompanyRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(company.getSymbol()).isEqualTo("AAPL");
        assertThat(company.getCompanyName()).isEqualTo("Apple Inc.");
        assertThat(company.getExchange()).isEqualTo("Nasdaq Global Select");
        assertThat(company.getIndustry()).isEqualTo("Computer Hardware");
        assertThat(company.getWebsite()).isEqualTo("http://www.apple.com");
        assertThat(company.getDescription()).isEqualTo("Apple Inc is designs, manufactures and markets mobile communication and media devices and personal computers, and sells a variety of related software, services, accessories, networking solutions and third-party digital content and applications.");
        assertThat(company.getCEO()).isEqualTo("Timothy D. Cook");
        assertThat(company.getIssueType()).isEqualTo("cs");
        assertThat(company.getSector()).isEqualTo("Technology");
        assertThat(company.getTags()).containsExactly("Technology", "Consumer Electronics", "Computer Hardware");
    }

}
