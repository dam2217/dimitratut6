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

    public static void main(String[] args) throws Exception {


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

//            sqlStr = "INSERT INTO test_tiger (will, joon) values('flome', 4)";
//            s.execute (sqlStr);

            //s.close();
            //conn.close();
        }       catch (Exception e){
            e.printStackTrace();
        }

    }

//
//    {
//        try {
//            sqlStr = \
//            stmt.execute(sqlStr);
//        } catch (Exception e) {
//        }
//    }

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
////
// //   }
//
//    //Ref 1: code from https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private static Connection getConnection() throws URISyntaxException, SQLException {

        URI dbUri = new URI("postgres://jhwkfsqyvfessl:fd84735e59925c6062e8d5f7e866afa2b029a4a61a4519e7a0ebf59b3e1b197a@ec2-54-247-82-14.eu-west-1.compute.amazonaws.com:5432/d4a6ke5jmf5tsm");
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
        System.out.println("help");
        System.out.println(dbUrl);

        return DriverManager.getConnection(dbUrl, username, password);
    }


//    //end of reference 1
}
