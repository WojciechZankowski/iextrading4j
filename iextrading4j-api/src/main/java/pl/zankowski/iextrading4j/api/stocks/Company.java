package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class Company implements Serializable {

    private static final long serialVersionUID = 1665863689707337670L;

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
    private final String address;
    private final String address2;
    private final String state;
    private final String city;
    private final String zip;
    private final String country;
    private final String phone;
    private final String primarySicCode;

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
            @JsonProperty("tags") final List<String> tags,
            @JsonProperty("address") final String address,
            @JsonProperty("address2") final String address2,
            @JsonProperty("state") final String state,
            @JsonProperty("city") final String city,
            @JsonProperty("zip") final String zip,
            @JsonProperty("country") final String country,
            @JsonProperty("phone") final String phone,
            @JsonProperty("primarySicCode") final String primarySicCode) {
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
        this.address = address;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.primarySicCode = primarySicCode;
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

    @JsonProperty("CEO")
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

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getPrimarySicCode() {
        return primarySicCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
                Objects.equal(tags, company.tags) &&
                Objects.equal(address, company.address) &&
                Objects.equal(address2, company.address2) &&
                Objects.equal(state, company.state) &&
                Objects.equal(city, company.city) &&
                Objects.equal(zip, company.zip) &&
                Objects.equal(country, company.country) &&
                Objects.equal(phone, company.phone) &&
                Objects.equal(primarySicCode, company.primarySicCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, companyName, exchange, industry, website, description, CEO,
                securityName, issueType, sector, employees, tags, address, address2, state, city, zip,
                country, phone, primarySicCode);
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
                .add("address", address)
                .add("address2", address2)
                .add("state", state)
                .add("city", city)
                .add("zip", zip)
                .add("country", country)
                .add("phone", phone)
                .add("primarySicCode", primarySicCode)
                .toString();
    }

}
