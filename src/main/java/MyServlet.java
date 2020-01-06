import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;


@WebServlet(urlPatterns={"/eczemadatabase"}, loadOnStartup = 1)

public class MyServlet extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello, world!");
        try {
            CreateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws Exception {
//
//
//        try {     // Registers the driver
//            Class.forName("org.postgresql.Driver");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Connection conn= getConnection();
//
//        try {
//            Statement s=conn.createStatement();
//            String sqlStr = "CREATE TABLE test_tiger (will VARCHAR(8), joon INT)";
//            s.execute (sqlStr);
//
////            sqlStr = "INSERT INTO test_tiger (will, joon) values('flome', 4)";
////            s.execute (sqlStr);
//
//            //s.close();
//            //conn.close();
//        }       catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }


//   // public static void main(String[] args) throws Exception {
//   {
//       try {     // Registers the driver
//           Class.forName("org.postgresql.Driver");
//       } catch (Exception e) {
//       }
//   }
//        Connection connection;
//    {
//        try {
//            connection = getConnection();
//        } catch (URISyntaxException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//        Statement stmt;
//    {
//        try {
//            stmt = connection.createStatement();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public String sqlStr;
//
//    {
//        try {
//            sqlStr = "CREATE TABLE appdata (id SERIAL PRIMARY  KEY, " +
//                    "hf varchar(16), hb varchar(16), tf varchar(16), tb varchar(16)," +
//                    "raf varchar(16), rab varchar(16), laf varchar(16), lab varchar(16)," +
//                    "rlf varchar(16), rlb varchar(16), llf varchar(16), llb varchar(16)," +
//                    "treatmentYorN varchar(6), treatmentUsed varchar(128), temperature varchar(6)," +
//                    "pollutionLevel varchar(20), pollenLevel varchar(20), hfTreated varchar(20)," +
//                    "hbTreated varchar(20), tfTreated varchar(20), tbTreated varchar(20)," +
//                    "rafTreated varchar(20), rabTreated varchar(20), lafTreated varchar(20)," +
//                    "labTreated varchar(20), rlfTreated varchar(20), rlbTreated varchar(20)," +
//                    "llfTreated varchar(20), llbTreated varchar(20), notes varchar(200))";
//            stmt.execute(sqlStr);
//        } catch (Exception e) {
//        }
//    }
////        try{
////            sqlStr = "INSERT INTO appdata (hf,llf,raf) values('Mild', 'Severe', 'Moderate') ";
////            stmt.execute(sqlStr);
////        }catch (Exception e){
////        }
//
////        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
////        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
////        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
////        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
////        while (rs.next()) {
////            System.out.println("Read from DB: " + rs.getTimestamp("tick"));
////        }
//    //}
//
//
//
//
//
//   @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("Hello, world!");
//    }
////    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
////            IOException {
////        //database.write(location, req.body.frontBacksTATE)
// //   }
//
//    //Ref 1: code from https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private static Connection getConnection() throws URISyntaxException, SQLException {

        URI dbUri = new URI("DATABASE_URL");
        System.out.println(dbUri);

        String username = dbUri.getUserInfo().split(":")[0];
        System.out.println("useramme: ");
        System.out.println(username);
        String password = dbUri.getUserInfo().split(":")[1];
        System.out.println("password");
        System.out.println(password);
        System.out.println("host");
        System.out.println(dbUri.getHost());
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public static void CreateTable() throws Exception {

        try {     // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection conn= getConnection();

        try {
            Statement s=conn.createStatement();
            String sqlStr = "CREATE TABLE test_tiger (will VARCHAR(8), joon INT)";
            s.execute (sqlStr);

            s.close();
            conn.close();
        }       catch (Exception e){
            e.printStackTrace();
        }
    }
//    //end of reference 1
}
