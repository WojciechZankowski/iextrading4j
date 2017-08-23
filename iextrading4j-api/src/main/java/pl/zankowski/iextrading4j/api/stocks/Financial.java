package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class Financial {

    private final String reportDate;
    private final double grossProfit;
    private final double costOfRevenue;
    private final double operatingRevenue;
    private final double totalRevenue;
    private final double operatingIncome;
    private final double netIncome;
    private final double researchAndDevelopment;
    private final double operatingExpense;
    private final double currentAssets;
    private final double totalAssets;
    private final double totalLiabilities;
    private final double currentCash;
    private final double currentDebt;
    private final double totalCash;
    private final double totalDebt;
    private final double shareholderEquity;
    private final double cashChange;
    private final double cashFlow;
    private final String operatingGainsLosses;

    @JsonCreator
    public Financial(@JsonProperty("reportDate") String reportDate,
                     @JsonProperty("grossProfit") double grossProfit,
                     @JsonProperty("costOfRevenue") double costOfRevenue,
                     @JsonProperty("operatingRevenue") double operatingRevenue,
                     @JsonProperty("totalRevenue") double totalRevenue,
                     @JsonProperty("operatingIncome") double operatingIncome,
                     @JsonProperty("netIncome") double netIncome,
                     @JsonProperty("researchAndDevelopment") double researchAndDevelopment,
                     @JsonProperty("operatingExpense") double operatingExpense,
                     @JsonProperty("currentAssets") double currentAssets,
                     @JsonProperty("totalAssets") double totalAssets,
                     @JsonProperty("totalLiabilities") double totalLiabilities,
                     @JsonProperty("currentCash") double currentCash,
                     @JsonProperty("currentDebt") double currentDebt,
                     @JsonProperty("totalCash") double totalCash,
                     @JsonProperty("totalDebt") double totalDebt,
                     @JsonProperty("shareholderEquity") double shareholderEquity,
                     @JsonProperty("cashChange") double cashChange,
                     @JsonProperty("cashFlow") double cashFlow,
                     @JsonProperty("operatingGainsLosses") String operatingGainsLosses) {
        this.reportDate = reportDate;
        this.grossProfit = grossProfit;
        this.costOfRevenue = costOfRevenue;
        this.operatingRevenue = operatingRevenue;
        this.totalRevenue = totalRevenue;
        this.operatingIncome = operatingIncome;
        this.netIncome = netIncome;
        this.researchAndDevelopment = researchAndDevelopment;
        this.operatingExpense = operatingExpense;
        this.currentAssets = currentAssets;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
        this.currentCash = currentCash;
        this.currentDebt = currentDebt;
        this.totalCash = totalCash;
        this.totalDebt = totalDebt;
        this.shareholderEquity = shareholderEquity;
        this.cashChange = cashChange;
        this.cashFlow = cashFlow;
        this.operatingGainsLosses = operatingGainsLosses;
    }

    public String getReportDate() {
        return reportDate;
    }

    public double getGrossProfit() {
        return grossProfit;
    }

    public double getCostOfRevenue() {
        return costOfRevenue;
    }

    public double getOperatingRevenue() {
        return operatingRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public double getOperatingIncome() {
        return operatingIncome;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public double getResearchAndDevelopment() {
        return researchAndDevelopment;
    }

    public double getOperatingExpense() {
        return operatingExpense;
    }

    public double getCurrentAssets() {
        return currentAssets;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public double getTotalLiabilities() {
        return totalLiabilities;
    }

    public double getCurrentCash() {
        return currentCash;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public double getShareholderEquity() {
        return shareholderEquity;
    }

    public double getCashChange() {
        return cashChange;
    }

    public double getCashFlow() {
        return cashFlow;
    }

    public String getOperatingGainsLosses() {
        return operatingGainsLosses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Financial financial = (Financial) o;

        if (Double.compare(financial.grossProfit, grossProfit) != 0) return false;
        if (Double.compare(financial.costOfRevenue, costOfRevenue) != 0) return false;
        if (Double.compare(financial.operatingRevenue, operatingRevenue) != 0) return false;
        if (Double.compare(financial.totalRevenue, totalRevenue) != 0) return false;
        if (Double.compare(financial.operatingIncome, operatingIncome) != 0) return false;
        if (Double.compare(financial.netIncome, netIncome) != 0) return false;
        if (Double.compare(financial.researchAndDevelopment, researchAndDevelopment) != 0) return false;
        if (Double.compare(financial.operatingExpense, operatingExpense) != 0) return false;
        if (Double.compare(financial.currentAssets, currentAssets) != 0) return false;
        if (Double.compare(financial.totalAssets, totalAssets) != 0) return false;
        if (Double.compare(financial.totalLiabilities, totalLiabilities) != 0) return false;
        if (Double.compare(financial.currentCash, currentCash) != 0) return false;
        if (Double.compare(financial.currentDebt, currentDebt) != 0) return false;
        if (Double.compare(financial.totalCash, totalCash) != 0) return false;
        if (Double.compare(financial.totalDebt, totalDebt) != 0) return false;
        if (Double.compare(financial.shareholderEquity, shareholderEquity) != 0) return false;
        if (Double.compare(financial.cashChange, cashChange) != 0) return false;
        if (Double.compare(financial.cashFlow, cashFlow) != 0) return false;
        if (reportDate != null ? !reportDate.equals(financial.reportDate) : financial.reportDate != null) return false;
        return operatingGainsLosses != null ? operatingGainsLosses.equals(financial.operatingGainsLosses) : financial.operatingGainsLosses == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = reportDate != null ? reportDate.hashCode() : 0;
        temp = Double.doubleToLongBits(grossProfit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(costOfRevenue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(operatingRevenue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalRevenue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(operatingIncome);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(netIncome);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(researchAndDevelopment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(operatingExpense);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentAssets);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalAssets);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalLiabilities);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentCash);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentDebt);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalCash);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalDebt);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shareholderEquity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cashChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cashFlow);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (operatingGainsLosses != null ? operatingGainsLosses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Financial{" +
                "reportDate='" + reportDate + '\'' +
                ", grossProfit=" + grossProfit +
                ", costOfRevenue=" + costOfRevenue +
                ", operatingRevenue=" + operatingRevenue +
                ", totalRevenue=" + totalRevenue +
                ", operatingIncome=" + operatingIncome +
                ", netIncome=" + netIncome +
                ", researchAndDevelopment=" + researchAndDevelopment +
                ", operatingExpense=" + operatingExpense +
                ", currentAssets=" + currentAssets +
                ", totalAssets=" + totalAssets +
                ", totalLiabilities=" + totalLiabilities +
                ", currentCash=" + currentCash +
                ", currentDebt=" + currentDebt +
                ", totalCash=" + totalCash +
                ", totalDebt=" + totalDebt +
                ", shareholderEquity=" + shareholderEquity +
                ", cashChange=" + cashChange +
                ", cashFlow=" + cashFlow +
                ", operatingGainsLosses='" + operatingGainsLosses + '\'' +
                '}';
    }

}
