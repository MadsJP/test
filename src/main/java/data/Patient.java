package data;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class Patient {
    private String CPR;
    private String Fornavn;
    private Aftale Aftale;

    public String getEfternavn() {
        return Efternavn;
    }

    public void setEfternavn(String efternavn) {
        Efternavn = efternavn;
    }

    private String Efternavn;

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getFornavn() {
        return Fornavn;
    }

    public void setFornavn(String fornavn) {
        Fornavn = fornavn;
    }

    public data.Aftale getAftale() {
        return Aftale;
    }

    public void setAftale(data.Aftale aftale) {
        Aftale = aftale;
    }
}