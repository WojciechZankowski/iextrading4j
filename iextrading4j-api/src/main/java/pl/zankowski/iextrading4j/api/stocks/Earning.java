package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Wojciech Zankowski
 */
public class Earning {

    private final double actualEPS;
    private final double consensusEPS;
    private final double estimatedEPS;
    private final String announceTime;
    private final double numberOfEstimates;
    private final double EPSSurpriseDollar;
    private final String EPSReportDate;
    private final String fiscalPeriod;
    private final String fiscalEndDate;

    @JsonCreator
    public Earning(@JsonProperty("actualEPS") double actualEPS,
                   @JsonProperty("consensusEPS") double consensusEPS,
                   @JsonProperty("estimatedEPS") double estimatedEPS,
                   @JsonProperty("announceTime") String announceTime,
                   @JsonProperty("numberOfEstimates") double numberOfEstimates,
                   @JsonProperty("EPSSurpriseDollar") double EPSSurpriseDollar,
                   @JsonProperty("EPSReportDate") String EPSReportDate,
                   @JsonProperty("fiscalPeriod") String fiscalPeriod,
                   @JsonProperty("fiscalEndDate") String fiscalEndDate) {
        this.actualEPS = actualEPS;
        this.consensusEPS = consensusEPS;
        this.estimatedEPS = estimatedEPS;
        this.announceTime = announceTime;
        this.numberOfEstimates = numberOfEstimates;
        this.EPSSurpriseDollar = EPSSurpriseDollar;
        this.EPSReportDate = EPSReportDate;
        this.fiscalPeriod = fiscalPeriod;
        this.fiscalEndDate = fiscalEndDate;
    }

    public double getActualEPS() {
        return actualEPS;
    }

    public double getConsensusEPS() {
        return consensusEPS;
    }

    public double getEstimatedEPS() {
        return estimatedEPS;
    }

    public String getAnnounceTime() {
        return announceTime;
    }

    public double getNumberOfEstimates() {
        return numberOfEstimates;
    }

    public double getEPSSurpriseDollar() {
        return EPSSurpriseDollar;
    }

    public String getEPSReportDate() {
        return EPSReportDate;
    }

    public String getFiscalPeriod() {
        return fiscalPeriod;
    }

    public String getFiscalEndDate() {
        return fiscalEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Earning earning = (Earning) o;

        if (Double.compare(earning.actualEPS, actualEPS) != 0) return false;
        if (Double.compare(earning.consensusEPS, consensusEPS) != 0) return false;
        if (Double.compare(earning.estimatedEPS, estimatedEPS) != 0) return false;
        if (Double.compare(earning.numberOfEstimates, numberOfEstimates) != 0) return false;
        if (Double.compare(earning.EPSSurpriseDollar, EPSSurpriseDollar) != 0) return false;
        if (announceTime != null ? !announceTime.equals(earning.announceTime) : earning.announceTime != null)
            return false;
        if (EPSReportDate != null ? !EPSReportDate.equals(earning.EPSReportDate) : earning.EPSReportDate != null)
            return false;
        if (fiscalPeriod != null ? !fiscalPeriod.equals(earning.fiscalPeriod) : earning.fiscalPeriod != null)
            return false;
        return fiscalEndDate != null ? fiscalEndDate.equals(earning.fiscalEndDate) : earning.fiscalEndDate == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(actualEPS);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(consensusEPS);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(estimatedEPS);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (announceTime != null ? announceTime.hashCode() : 0);
        temp = Double.doubleToLongBits(numberOfEstimates);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(EPSSurpriseDollar);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (EPSReportDate != null ? EPSReportDate.hashCode() : 0);
        result = 31 * result + (fiscalPeriod != null ? fiscalPeriod.hashCode() : 0);
        result = 31 * result + (fiscalEndDate != null ? fiscalEndDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Earning{" +
                "actualEPS=" + actualEPS +
                ", consensusEPS=" + consensusEPS +
                ", estimatedEPS=" + estimatedEPS +
                ", announceTime='" + announceTime + '\'' +
                ", numberOfEstimates=" + numberOfEstimates +
                ", EPSSurpriseDollar=" + EPSSurpriseDollar +
                ", EPSReportDate='" + EPSReportDate + '\'' +
                ", fiscalPeriod='" + fiscalPeriod + '\'' +
                ", fiscalEndDate='" + fiscalEndDate + '\'' +
                '}';
    }

}
