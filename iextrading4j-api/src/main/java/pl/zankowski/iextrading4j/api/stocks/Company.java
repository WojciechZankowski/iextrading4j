package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
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
    public Company(@JsonProperty("symbol") String symbol,
                   @JsonProperty("companyName") String companyName,
                   @JsonProperty("exchange") String exchange,
                   @JsonProperty("industry") String industry,
                   @JsonProperty("website") String website,
                   @JsonProperty("description") String description,
                   @JsonProperty("CEO") String CEO,
                   @JsonProperty("issueType") String issueType,
                   @JsonProperty("sector") String sector) {
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

        if (symbol != null ? !symbol.equals(company.symbol) : company.symbol != null) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (exchange != null ? !exchange.equals(company.exchange) : company.exchange != null) return false;
        if (industry != null ? !industry.equals(company.industry) : company.industry != null) return false;
        if (website != null ? !website.equals(company.website) : company.website != null) return false;
        if (description != null ? !description.equals(company.description) : company.description != null) return false;
        if (CEO != null ? !CEO.equals(company.CEO) : company.CEO != null) return false;
        if (issueType != null ? !issueType.equals(company.issueType) : company.issueType != null) return false;
        return sector != null ? sector.equals(company.sector) : company.sector == null;

    }

    @Override
    public int hashCode() {
        int result = symbol != null ? symbol.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (exchange != null ? exchange.hashCode() : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (CEO != null ? CEO.hashCode() : 0);
        result = 31 * result + (issueType != null ? issueType.hashCode() : 0);
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", exchange='" + exchange + '\'' +
                ", industry='" + industry + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                ", CEO='" + CEO + '\'' +
                ", issueType='" + issueType + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }

}
