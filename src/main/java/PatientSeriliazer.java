import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.Aftale;
import data.Patient;
import data.Sygehus;
import data.Type;

public class PatientSeriliazer {

    public static String ptToXML(Patient pt) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(pt);
    }

    //Test main
    public static void main(String[] args) throws JsonProcessingException {
        Patient patient = new Patient();
        Aftale aftale = new Aftale();
        Sygehus sygehus = new Sygehus();
        Type type = new Type();

            aftale.setFritekst("Husk at faste i 12 timer før operationen");
            aftale.setDato("22-11-2019");
            patient.setCPR("123456789");
            patient.setFornavn("Anonym");
            patient.setEfternavn("Hansen");
            patient.setAftale(aftale);
            aftale.setType(type);
            aftale.setSygehus(sygehus);
            sygehus.setNavn("Hvidovre");
            sygehus.setAfdeling("Kriguisk afdeling");
            type.setAftaleType("Operation");
            type.setVarighed((long) 1200);
        System.out.println(PatientSeriliazer.ptToXML(patient));

    }
}
