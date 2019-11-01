import data.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    public List<Patient> getPatients() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient;");

        List<Patient> patients = parseResultsetToPatient(resultSet);
        System.out.println("Der er forbindelse");
        return patients;
    }

    public Boolean validering(String cpr, String password)throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient WHERE CPR ='"+cpr+"';");
        resultSet.next();
        String c = resultSet.getString("CPR");
        if(password == c){
            return true;
        }


        return false;
    }

    private List<Patient> parseResultsetToPatient(ResultSet resultSet) throws SQLException {
        List<Patient> patients = new ArrayList<>();
        while (resultSet.next()){
            Patient patient = new Patient();
            String cpr = resultSet.getString("CPR");
            patient.setCPR(cpr);
            patients.add(patient);

        }
        return patients;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new DBHandler().getPatients();

    }
}
