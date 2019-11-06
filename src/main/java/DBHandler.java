import data.Aftale;
import data.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    public static void main (String[] args) {
        try {
            getPatients();
            getAftale();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static List<Patient> getPatients() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient;");
        connection.close();
        List<Patient> patients = parseResultsetToPatient(resultSet);
        System.out.println("Der er forbindelse");
        return patients;
    }

    public static List<Aftale> getAftale() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Aftale;");
        connection.close();
        List<Aftale> aftaler = parseResultsetToAftaler(resultSet);
        System.out.println("Der er Aftaler");
        return aftaler;
    }

    public static Boolean validering(String cpr, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient WHERE CPR ='" + cpr + "';");
        resultSet.next();
        String c = resultSet.getString("CPR");
        String p = resultSet.getString("Password");
        connection.close();
        if (cpr.equals(c) && password.equals(p)) {
            return true;
        }
        return false;
    }

    private static List<Patient> parseResultsetToPatient(ResultSet resultSet) throws SQLException {
        List<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {
            Patient patient = new Patient();
            String cpr = resultSet.getString("CPR");
            patient.setCPR(cpr);
            patients.add(patient);
            System.out.println("CPR " + cpr);
        }
        return patients;
    }
    private static List<Aftale> parseResultsetToAftaler(ResultSet resultSet) throws SQLException {
        List<Aftale> aftaler = new ArrayList<>();
        while (resultSet.next()) {
            Aftale aftale = new Aftale();
            String patient = resultSet.getString("Patient");
            aftale.setPatient(patient);
            aftaler.add(aftale);
            System.out.println("Aftale " + patient);
        }
        return aftaler;
    }
}
