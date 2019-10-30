import java.sql.*;

public class DBHandler {

    public String getSomedata() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://su1.eduhost.dk:3306/server1?user=gruppe6&password=gruppe6");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient;");
        System.out.println("Det virkede");
        return "Den hemmelige data";
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new DBHandler().getSomedata();


    }
}
