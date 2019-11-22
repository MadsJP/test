package data;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class Type {
    private String AftaleType;
    private Long Varighed;

    public String getAftaleType() {
        return AftaleType;
    }

    public void setAftaleType(String aftaleType) {
        AftaleType = aftaleType;
    }

    public Long getVarighed() {
        return Varighed;
    }

    public void setVarighed(Long varighed) {
        Varighed = varighed;
    }
}
