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

        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        while (rs.next()) {
            System.out.println("Read from DB: " + rs.getTimestamp("tick"));
        }
    }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        HttpURLConnection con = (HttpURLConnection) url.openConnection();
////        con.setRequestMethod("GET");
//        resp.getWriter().write("Hello, world!");
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
//            IOException {
//        //database.write(location, req.body.frontBacksTATE)
 //   }

    //Ref 1: code from https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
    //end of reference 1
}
