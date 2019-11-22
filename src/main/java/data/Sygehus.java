package data;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class Sygehus {
    private String Navn;
    private String Afdeling;

    public String getNavn() {
        return Navn;
    }

    public void setNavn(String navn) {
        Navn = navn;
    }

    public String getAfdeling() {
        return Afdeling;
    }

    public void setAfdeling(String afdeling) {
        Afdeling = afdeling;
    }
}
