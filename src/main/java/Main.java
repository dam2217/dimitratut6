import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
        switch(args[0]) {
            case("c"):
                CreateTable();
                break;
            case("i"):
                AddWillJoon();
                break;
            case("d"):
                DeleteTable();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + args[1]);
        }
    }

        public static void CreateTable() throws Exception {
            String dbUrl = "jdbc:postgresql://localhost:5432/postgres";

            try {     // Registers the driver
                Class.forName("org.postgresql.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String password = "Hate456?!";
            Connection conn= DriverManager.getConnection(dbUrl, "postgres", password);

            try {
                Statement s=conn.createStatement();
                String sqlStr = "CREATE TABLE test_tiger (will VARCHAR(8), joon INT)";
                s.execute (sqlStr);

//            sqlStr = "INSERT INTO test_tiger (will, joon) values('flome', 4)";
//            s.execute (sqlStr);

                s.close();
                conn.close();
            }       catch (Exception e){
                e.printStackTrace();
            }
        }

    public static void AddWillJoon() throws Exception {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";

        try {     // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = "Hate456?!";
        Connection conn = DriverManager.getConnection(dbUrl, "postgres", password);

        try {
            Statement s = conn.createStatement();

            String sqlStr = "INSERT INTO test_tiger (will, joon) values('flome', 4)";
            s.execute(sqlStr);

            s.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteTable() throws Exception {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";

        try {     // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String password = "Hate456?!";
        Connection conn= DriverManager.getConnection(dbUrl, "postgres", password);

        try {
            Statement s=conn.createStatement();
            String sqlStr = "DROP TABLE test_tiger";
            s.execute (sqlStr);

//            sqlStr = "INSERT INTO test_tiger (will, joon) values('flome', 4)";
//            s.execute (sqlStr);

            s.close();
            conn.close();
        }       catch (Exception e){
            e.printStackTrace();
        }
    }


}


