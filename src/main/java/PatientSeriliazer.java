import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.Aftale;
import data.Patient;

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
        aftale.setFritekst("Spændende fritekst");
        patient.setAftale(aftale);
        System.out.println(PatientSeriliazer.ptToXML(patient));

    }
}
