import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main {
//    try {     // Registers the driver
//            Class.forName("org.postgresql.Driver");
//        }
//    catch{ Exception e}


    public static void main(String[] args) throws Exception {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {     // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        Connection connection = DriverManager.getConnection(dbUrl);
        Statement stmt = connection.createStatement();

        String sqlStr = "INSERT INTO logdata (headfront, headback, legfront) values ('test','test','test')";
        stmt.execute(sqlStr);

    }

}


