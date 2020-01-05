import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
//    try {     // Registers the driver
//            Class.forName("org.postgresql.Driver");
//        }
//    catch{ Exception e}


    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();

        String sqlStr;
//        try {
            sqlStr = "CREATE TABLE appdata (id SERIAL PRIMARY  KEY, " +
                    "hf varchar(16), hb varchar(16), tf varchar(16), tb varchar(16)," +
                    "raf varchar(16), rab varchar(16), laf varchar(16), lab varchar(16)," +
                    "rlf varchar(16), rlb varchar(16), llf varchar(16), llb varchar(16)," +
                    "treatmentYorN varchar(6), treatmentUsed varchar(128), temperature varchar(6)," +
                    "pollutionLevel varchar(20), pollenLevel varchar(20), hfTreated varchar(20)," +
                    "hbTreated varchar(20), tfTreated varchar(20), tbTreated varchar(20)," +
                    "rafTreated varchar(20), rabTreated varchar(20), lafTreated varchar(20)," +
                    "labTreated varchar(20), rlfTreated varchar(20), rlbTreated varchar(20)," +
                    "llfTreated varchar(20), llbTreated varchar(20), notes varchar(200))";
            stmt.execute(sqlStr);
//        } catch (Exception e) {
//        }
    }
    //Ref 1: code from https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        //  String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        return DriverManager.getConnection(dbUrl, username,password);
    }
    //end of reference 1
}


