package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
     public static void main (String[] args) {
        try {
            //getPatients();
            getAftale("");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Patient getPatient(String cpr) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su6.eduhost.dk:3306/server1?user=christoffer&password=zaq12wsx");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient WHERE cpr='"+cpr+"';");
        connection.close();
        Patient patient = null;
        while (resultSet.next()) {
            patient = new Patient();
            String cPR = resultSet.getString("CPR");
            String fornavn = resultSet.getString("Fornavn");
            patient.setCPR(cpr);
            patient.setFornavn(fornavn);
            System.out.println("Patient " + fornavn + " " + cpr);
        }
        return patient;
    }

    public static List<Aftale> getAftale(String cpr) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Aftale WHERE Patient = '" + cpr + "';");
        connection.close();
        List<Aftale> aftaler = parseResultsetToAftaler(resultSet);
        System.out.println("Der er Aftaler");
        return aftaler;
    }

    public static Boolean validering(String cpr, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient WHERE CPR ='"+ cpr +"';");
        resultSet.next();
        String c = resultSet.getString("CPR");
        String p = resultSet.getString("Password");
        connection.close();
        //System.out.println("Jeg validerer");
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
            String fornavn = resultSet.getString("Fornavn");
            patient.setCPR(cpr);
            patient.setFornavn(fornavn);
            patients.add(patient);
            System.out.println("Patient " + fornavn + " " + cpr);
        }
        return patients;
    }
    private static List<Aftale> parseResultsetToAftaler(ResultSet resultSet) throws SQLException {
        List<Aftale> aftaler = new ArrayList<>();
        while (resultSet.next()) {
            Aftale aftale = new Aftale();
            String patient = resultSet.getString("Patient");
            String sygehus = resultSet.getString("Sygehus");
            String type = resultSet.getString("Type");
            String dato = resultSet.getString("Dato");
            String fritekst = resultSet.getString("Fritekst");
            //TODO fix!
        //    aftale.setPatient(patient);
          //  aftale.setSygehus(sygehus);
          //  aftale.setType(type);
            aftale.setDato(dato);
            aftale.setFritekst(fritekst);
            aftaler.add(aftale);
            System.out.println(patient + " har en aftale på sygehus " + sygehus + " til undersøgelse i " + type + " den "+ dato);
        }
        return aftaler;
    }
}
