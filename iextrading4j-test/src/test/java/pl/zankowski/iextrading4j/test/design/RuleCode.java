package pl.zankowski.iextrading4j.test.design;

import com.google.common.base.MoreObjects;

public class RuleCode {

    public static RuleCode API_SERIALIZABLE = new RuleCode("API_SERIALIZABLE");
    public static RuleCode API_ONE_CONSTRUCTOR = new RuleCode("API_ONE_CONSTRUCTOR");
    public static RuleCode API_ANNOTATED = new RuleCode("API_ANNOTATED");
    public static RuleCode API_OVERRIDDEN = new RuleCode("API_OVERRIDDEN");

    private final String codeName;

    public RuleCode(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeName() {
        return codeName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("codeName", codeName)
                .toString();
    }
}
