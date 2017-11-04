package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonPropertyOrder({"symbol, companyName", "exchange", "industry", "website",
        "description", "CEO", "issueType", "sector"})
public class Company {

    private final String symbol;
    private final String companyName;
    private final String exchange;
    private final String industry;
    private final String website;
    private final String description;
    private final String CEO;
    private final String issueType;
    private final String sector;

    @JsonCreator
    public Company(@JsonProperty("symbol") final String symbol,
                   @JsonProperty("companyName") final String companyName,
                   @JsonProperty("exchange") final String exchange,
                   @JsonProperty("industry") final String industry,
                   @JsonProperty("website") final String website,
                   @JsonProperty("description") final String description,
                   @JsonProperty("CEO") final String CEO,
                   @JsonProperty("issueType") final String issueType,
                   @JsonProperty("sector") final String sector) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.exchange = exchange;
        this.industry = industry;
        this.website = website;
        this.description = description;
        this.CEO = CEO;
        this.issueType = issueType;
        this.sector = sector;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getExchange() {
        return exchange;
    }

    public String getIndustry() {
        return industry;
    }

    public String getWebsite() {
        return website;
    }

    public String getDescription() {
        return description;
    }

    public String getCEO() {
        return CEO;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equal(symbol, company.symbol) &&
                Objects.equal(companyName, company.companyName) &&
                Objects.equal(exchange, company.exchange) &&
                Objects.equal(industry, company.industry) &&
                Objects.equal(website, company.website) &&
                Objects.equal(description, company.description) &&
                Objects.equal(CEO, company.CEO) &&
                Objects.equal(issueType, company.issueType) &&
                Objects.equal(sector, company.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, companyName, exchange, industry, website,
                description, CEO, issueType, sector);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("companyName", companyName)
                .add("exchange", exchange)
                .add("industry", industry)
                .add("website", website)
                .add("description", description)
                .add("CEO", CEO)
                .add("issueType", issueType)
                .add("sector", sector)
                .toString();
    }
}
