package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"symbol, companyName", "exchange", "industry", "website",
        "description", "CEO", "securityName", "issueType", "sector", "employees", "tags"})
public class Company implements Serializable {

    private final String symbol;
    private final String companyName;
    private final String exchange;
    private final String industry;
    private final String website;
    private final String description;
    private final String CEO;
    private final String securityName;
    private final String issueType;
    private final String sector;
    private final BigDecimal employees;
    private final List<String> tags;

    @JsonCreator
    public Company(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("industry") final String industry,
            @JsonProperty("website") final String website,
            @JsonProperty("description") final String description,
            @JsonProperty("CEO") final String CEO,
            @JsonProperty("securityName") final String securityName,
            @JsonProperty("issueType") final String issueType,
            @JsonProperty("sector") final String sector,
            @JsonProperty("employees") final BigDecimal employees,
            @JsonProperty("tags") final List<String> tags) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.exchange = exchange;
        this.industry = industry;
        this.website = website;
        this.description = description;
        this.CEO = CEO;
        this.securityName = securityName;
        this.issueType = issueType;
        this.sector = sector;
        this.employees = employees;
        this.tags = immutableList(tags);
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

    public String getSecurityName() {
        return securityName;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getSector() {
        return sector;
    }

    public BigDecimal getEmployees() {
        return employees;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Company company = (Company) o;
        return Objects.equal(symbol, company.symbol) &&
                Objects.equal(companyName, company.companyName) &&
                Objects.equal(exchange, company.exchange) &&
                Objects.equal(industry, company.industry) &&
                Objects.equal(website, company.website) &&
                Objects.equal(description, company.description) &&
                Objects.equal(CEO, company.CEO) &&
                Objects.equal(securityName, company.securityName) &&
                Objects.equal(issueType, company.issueType) &&
                Objects.equal(sector, company.sector) &&
                Objects.equal(employees, company.employees) &&
                Objects.equal(tags, company.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, companyName, exchange, industry, website, description,
                CEO, securityName, issueType, sector, employees, tags);
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
                .add("securityName", securityName)
                .add("issueType", issueType)
                .add("sector", sector)
                .add("employees", employees)
                .add("tags", tags)
                .toString();
    }
}
