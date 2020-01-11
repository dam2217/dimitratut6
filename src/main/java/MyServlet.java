import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@WebServlet(urlPatterns={"/eczemadatabase"}, loadOnStartup = 1)

public class MyServlet extends HttpServlet {

    private static final Logger log =Logger.getLogger(MyServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("Hello, world!");


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println("BODY: " + reqBody);
        Gson gson = new Gson();
        LogEntrySerial test = gson.fromJson(reqBody, LogEntrySerial.class);
        LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        resp.setContentType("text/html");
        resp.getWriter().write("Thank you client!");
        req.getServletPath();
        log.info(reqBody);
        System.out.println(test.location);
        try {
            Connection conn= getConnection();
            Statement s=conn.createStatement();
            String sqlStr = "INSERT INTO userdata (location) values('+ test.location +')";
            s.execute (sqlStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws Exception {

        Connection conn= getConnection();

        try {
            Statement s=conn.createStatement();
            String sqlStr = "CREATE TABLE test_tiger (will VARCHAR(8), joon INT)";
            s.execute (sqlStr);

        }       catch (Exception e){
            e.printStackTrace();
        }

    }


//    //Ref 1: code from https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private static Connection getConnection() throws URISyntaxException, SQLException {

        //URI dbUri = new URI(System.getenv("DATABASE_URL"));
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
        System.out.println(dbUri.getPath());
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() +
                "?&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&user=" + username + "&password=" + password;
        System.out.println("help");
        System.out.println(dbUrl);

        return DriverManager.getConnection(dbUrl, username, password);
    }
    private void WritetoDatabase(){


    }


//    //end of reference 1
}
