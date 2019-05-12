package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"symbol", "companyName", "expectedDate", "leadUnderwriters", "underwriters",
        "companyCounsel", "underwriterCounsel", "auditor", "market", "cik", "address", "city",
        "state", "zip", "phone", "ceo", "employees", "url", "status", "sharesOffered", "priceLow",
        "priceHigh", "offerAmount", "totalExpenses", "sharesOverAlloted", "shareholderShares", "sharesOutstanding",
        "lockupPeriodExpiration", "quietPeriodExpiration", "revenue", "netIncome", "totalAssets",
        "totalLiabilities", "stockholderEquity", "companyDescription", "businessDescription",
        "useOfProceeds", "competition", "amount", "percentOffered"})
public class Ipo implements Serializable {

    private static final long serialVersionUID = 6433050561897952237L;

    private final String symbol;
    private final String companyName;
    private final LocalDate expectedDate;
    private final List<String> leadUnderwriters;
    private final List<String> underwriters;
    private final List<String> companyCounsel;
    private final List<String> underwriterCounsel;
    private final String auditor;
    private final String market;
    private final String cik;
    private final String address;
    private final String city;
    private final String state;
    private final String zip;
    private final String phone;
    private final String ceo;
    private final BigDecimal employees;
    private final String url;
    private final String status;
    private final BigDecimal sharesOffered;
    private final BigDecimal priceLow;
    private final BigDecimal priceHigh;
    private final BigDecimal offerAmount;
    private final BigDecimal totalExpenses;
    private final BigDecimal sharesOverAlloted;
    private final BigDecimal shareholderShares;
    private final BigDecimal sharesOutstanding;
    private final LocalDate lockupPeriodExpiration;
    private final LocalDate quietPeriodExpiration;
    private final BigDecimal revenue;
    private final BigDecimal netIncome;
    private final BigDecimal totalAssets;
    private final BigDecimal totalLiabilities;
    private final BigDecimal stockholderEquity;
    private final String companyDescription;
    private final String businessDescription;
    private final String useOfProceeds;
    private final String competition;
    private final BigDecimal amount;
    private final BigDecimal percentOffered;

    @JsonCreator
    public Ipo(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("companyName") final String companyName,
            @JsonProperty("expectedDate") final LocalDate expectedDate,
            @JsonProperty("leadUnderwriters") final List<String> leadUnderwriters,
            @JsonProperty("underwriters") final List<String> underwriters,
            @JsonProperty("companyCounsel") final List<String> companyCounsel,
            @JsonProperty("underwriterCounsel") final List<String> underwriterCounsel,
            @JsonProperty("auditor") final String auditor,
            @JsonProperty("market") final String market,
            @JsonProperty("cik") final String cik,
            @JsonProperty("address") final String address,
            @JsonProperty("city") final String city,
            @JsonProperty("state") final String state,
            @JsonProperty("zip") final String zip,
            @JsonProperty("phone") final String phone,
            @JsonProperty("ceo") final String ceo,
            @JsonProperty("employees") final BigDecimal employees,
            @JsonProperty("url") final String url,
            @JsonProperty("status") final String status,
            @JsonProperty("sharesOffered") final BigDecimal sharesOffered,
            @JsonProperty("priceLow") final BigDecimal priceLow,
            @JsonProperty("priceHigh") final BigDecimal priceHigh,
            @JsonProperty("offerAmount") final BigDecimal offerAmount,
            @JsonProperty("totalExpenses") final BigDecimal totalExpenses,
            @JsonProperty("sharesOverAlloted") final BigDecimal sharesOverAlloted,
            @JsonProperty("shareholderShares") final BigDecimal shareholderShares,
            @JsonProperty("sharesOutstanding") final BigDecimal sharesOutstanding,
            @JsonProperty("lockupPeriodExpiration") final LocalDate lockupPeriodExpiration,
            @JsonProperty("quietPeriodExpiration") final LocalDate quietPeriodExpiration,
            @JsonProperty("revenue") final BigDecimal revenue,
            @JsonProperty("netIncome") final BigDecimal netIncome,
            @JsonProperty("totalAssets") final BigDecimal totalAssets,
            @JsonProperty("totalLiabilities") final BigDecimal totalLiabilities,
            @JsonProperty("stockholderEquity") final BigDecimal stockholderEquity,
            @JsonProperty("companyDescription") final String companyDescription,
            @JsonProperty("businessDescription") final String businessDescription,
            @JsonProperty("useOfProceeds") final String useOfProceeds,
            @JsonProperty("competition") final String competition,
            @JsonProperty("amount") final BigDecimal amount,
            @JsonProperty("percentOffered") final BigDecimal percentOffered) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.expectedDate = expectedDate;
        this.leadUnderwriters = immutableList(leadUnderwriters);
        this.underwriters = immutableList(underwriters);
        this.companyCounsel = immutableList(companyCounsel);
        this.underwriterCounsel = immutableList(underwriterCounsel);
        this.auditor = auditor;
        this.market = market;
        this.cik = cik;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.ceo = ceo;
        this.employees = employees;
        this.url = url;
        this.status = status;
        this.sharesOffered = sharesOffered;
        this.priceLow = priceLow;
        this.priceHigh = priceHigh;
        this.offerAmount = offerAmount;
        this.totalExpenses = totalExpenses;
        this.sharesOverAlloted = sharesOverAlloted;
        this.shareholderShares = shareholderShares;
        this.sharesOutstanding = sharesOutstanding;
        this.lockupPeriodExpiration = lockupPeriodExpiration;
        this.quietPeriodExpiration = quietPeriodExpiration;
        this.revenue = revenue;
        this.netIncome = netIncome;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.stockholderEquity = stockholderEquity;
        this.companyDescription = companyDescription;
        this.businessDescription = businessDescription;
        this.useOfProceeds = useOfProceeds;
        this.competition = competition;
        this.amount = amount;
        this.percentOffered = percentOffered;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public List<String> getLeadUnderwriters() {
        return leadUnderwriters;
    }

    public List<String> getUnderwriters() {
        return underwriters;
    }

    public List<String> getCompanyCounsel() {
        return companyCounsel;
    }

    public List<String> getUnderwriterCounsel() {
        return underwriterCounsel;
    }

    public String getAuditor() {
        return auditor;
    }

    public String getMarket() {
        return market;
    }

    public String getCik() {
        return cik;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getCeo() {
        return ceo;
    }

    public BigDecimal getEmployees() {
        return employees;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getSharesOffered() {
        return sharesOffered;
    }

    public BigDecimal getPriceLow() {
        return priceLow;
    }

    public BigDecimal getPriceHigh() {
        return priceHigh;
    }

    public BigDecimal getOfferAmount() {
        return offerAmount;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public BigDecimal getSharesOverAlloted() {
        return sharesOverAlloted;
    }

    public BigDecimal getShareholderShares() {
        return shareholderShares;
    }

    public BigDecimal getSharesOutstanding() {
        return sharesOutstanding;
    }

    public LocalDate getLockupPeriodExpiration() {
        return lockupPeriodExpiration;
    }

    public LocalDate getQuietPeriodExpiration() {
        return quietPeriodExpiration;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public BigDecimal getStockholderEquity() {
        return stockholderEquity;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public String getUseOfProceeds() {
        return useOfProceeds;
    }

    public String getCompetition() {
        return competition;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPercentOffered() {
        return percentOffered;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ipo ipo = (Ipo) o;
        return Objects.equal(symbol, ipo.symbol) &&
                Objects.equal(companyName, ipo.companyName) &&
                Objects.equal(expectedDate, ipo.expectedDate) &&
                Objects.equal(leadUnderwriters, ipo.leadUnderwriters) &&
                Objects.equal(underwriters, ipo.underwriters) &&
                Objects.equal(companyCounsel, ipo.companyCounsel) &&
                Objects.equal(underwriterCounsel, ipo.underwriterCounsel) &&
                Objects.equal(auditor, ipo.auditor) &&
                Objects.equal(market, ipo.market) &&
                Objects.equal(cik, ipo.cik) &&
                Objects.equal(address, ipo.address) &&
                Objects.equal(city, ipo.city) &&
                Objects.equal(state, ipo.state) &&
                Objects.equal(zip, ipo.zip) &&
                Objects.equal(phone, ipo.phone) &&
                Objects.equal(ceo, ipo.ceo) &&
                Objects.equal(employees, ipo.employees) &&
                Objects.equal(url, ipo.url) &&
                Objects.equal(status, ipo.status) &&
                Objects.equal(sharesOffered, ipo.sharesOffered) &&
                Objects.equal(priceLow, ipo.priceLow) &&
                Objects.equal(priceHigh, ipo.priceHigh) &&
                Objects.equal(offerAmount, ipo.offerAmount) &&
                Objects.equal(totalExpenses, ipo.totalExpenses) &&
                Objects.equal(sharesOverAlloted, ipo.sharesOverAlloted) &&
                Objects.equal(shareholderShares, ipo.shareholderShares) &&
                Objects.equal(sharesOutstanding, ipo.sharesOutstanding) &&
                Objects.equal(lockupPeriodExpiration, ipo.lockupPeriodExpiration) &&
                Objects.equal(quietPeriodExpiration, ipo.quietPeriodExpiration) &&
                Objects.equal(revenue, ipo.revenue) &&
                Objects.equal(netIncome, ipo.netIncome) &&
                Objects.equal(totalAssets, ipo.totalAssets) &&
                Objects.equal(totalLiabilities, ipo.totalLiabilities) &&
                Objects.equal(stockholderEquity, ipo.stockholderEquity) &&
                Objects.equal(companyDescription, ipo.companyDescription) &&
                Objects.equal(businessDescription, ipo.businessDescription) &&
                Objects.equal(useOfProceeds, ipo.useOfProceeds) &&
                Objects.equal(competition, ipo.competition) &&
                Objects.equal(amount, ipo.amount) &&
                Objects.equal(percentOffered, ipo.percentOffered);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, companyName, expectedDate, leadUnderwriters, underwriters,
                companyCounsel, underwriterCounsel, auditor, market, cik, address, city, state, zip,
                phone, ceo, employees, url, status, sharesOffered, priceLow, priceHigh, offerAmount,
                totalExpenses, sharesOverAlloted, shareholderShares, sharesOutstanding, lockupPeriodExpiration,
                quietPeriodExpiration, revenue, netIncome, totalAssets, totalLiabilities, stockholderEquity,
                companyDescription, businessDescription, useOfProceeds, competition, amount, percentOffered);
    }

    @Override
    public String toString() {
        return "Ipo{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", expectedDate=" + expectedDate +
                ", leadUnderwriters=" + leadUnderwriters +
                ", underwriters=" + underwriters +
                ", companyCounsel=" + companyCounsel +
                ", underwriterCounsel=" + underwriterCounsel +
                ", auditor='" + auditor + '\'' +
                ", market='" + market + '\'' +
                ", cik='" + cik + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", ceo='" + ceo + '\'' +
                ", employees=" + employees +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", sharesOffered=" + sharesOffered +
                ", priceLow=" + priceLow +
                ", priceHigh=" + priceHigh +
                ", offerAmount=" + offerAmount +
                ", totalExpenses=" + totalExpenses +
                ", sharesOverAlloted=" + sharesOverAlloted +
                ", shareholderShares=" + shareholderShares +
                ", sharesOutstanding=" + sharesOutstanding +
                ", lockupPeriodExpiration=" + lockupPeriodExpiration +
                ", quietPeriodExpiration=" + quietPeriodExpiration +
                ", revenue=" + revenue +
                ", netIncome=" + netIncome +
                ", totalAssets=" + totalAssets +
                ", totalLiabilities=" + totalLiabilities +
                ", stockholderEquity=" + stockholderEquity +
                ", companyDescription='" + companyDescription + '\'' +
                ", businessDescription='" + businessDescription + '\'' +
                ", useOfProceeds='" + useOfProceeds + '\'' +
                ", competition='" + competition + '\'' +
                ", amount=" + amount +
                ", percentOffered=" + percentOffered +
                '}';
    }

}
