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

    //Getting Data from database and sending it across
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String datasend = "";           //creating string to send across
        try{
            Connection conn =  getConnection();     //getting the connection
            Statement s=conn.createStatement();
            String sqlStr = "SELECT * FROM usersdata WHERE id>=1";        //SQL command
            ResultSet rset=s.executeQuery(sqlStr);              //executing SQL command
            while(rset.next()){ //creating string with all the column values for each row
                datasend = datasend+"\"date\":\""+rset.getString("date")+
                       "\",\"hb\":\""+rset.getString("hb")+
                        "\",\"hbTreated\":\""+rset.getString("hbtreated")+
                        "\",\"hf\":\""+rset.getString("hf") +
                        "\",\"hfTreated\":\""+ rset.getString("hftreated") +
                        "\",\"humidity\":\""+ rset.getString("humidity") +
                        "\",\"lab\":\""+ rset.getString("lab") +
                        "\",\"labTreated\":\""+ rset.getString("labtreated") +
                        "\",\"laf\":\""+ rset.getString("laf") +
                        "\",\"lafTreated\":\""+ rset.getString("laftreated") +
                        "\",\"llb\":\""+ rset.getString("llb") +
                        "\",\"llbTreated\":\""+ rset.getString("llbtreated") +
                        "\",\"llf\":\""+ rset.getString("llf") +
                        "\",\"llfTreated\":\""+ rset.getString("llftreated") +
                        "\",\"location\":\""+ rset.getString("location") +
                        "\",\"notes\":\""+ rset.getString("notes") +
                        "\",\"pollenLevel\":\""+ rset.getString("pollenlevel") +
                        "\",\"pollutionLevel\":\""+ rset.getString("pollutionlevel") +
                        "\",\"rab\":\""+ rset.getString("rab") +
                        "\",\"rabTreated\":\""+ rset.getString("rabtreated") +
                        "\",\"raf\":\""+ rset.getString("raf") +
                        "\",\"rafTreated\":\""+ rset.getString("raftreated") +
                        "\",\"rlb\":\""+ rset.getString("rlb") +
                        "\",\"rlbTreated\":\""+ rset.getString("rlbtreated") +
                        "\",\"rlf\":\""+ rset.getString("rlf") +
                        "\",\"rlfTreated\":\""+ rset.getString("rlftreated") +
                        "\",\"tb\":\""+ rset.getString("tb") +
                        "\",\"tbTreated\":\""+ rset.getString("tbtreated") +
                        "\",\"tf\":\""+ rset.getString("tf") +
                        "\",\"tfTreated\":\""+ rset.getString("tftreated") +
                        "\",\"time\":\""+ rset.getString("time") +
                        "\",\"treatmentUsed\":\""+ rset.getString("treatmentused") +
                        "\",\"treatmentYorN\":\""+ rset.getString("treatmentyorn") +
                        "\"split";
            }
            rset.close();
            s.close();
            conn.close();           //closing connections
        }catch (Exception e){
            System.out.println("doesn't print");    //error message
        }
        resp.getWriter().write(datasend);           //sending string as a response to App's GET request
    }


    //Receiving data from App and putting it into the database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));     //reading in the request
        Gson gson = new Gson();         //creating new GSON object to pass request into
        LogEntrySerial test = gson.fromJson(reqBody, LogEntrySerial.class);     //passing JSON into LogEntrySerial
        LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        resp.setContentType("text/html");           //setting response type to HTML
        req.getServletPath();                       //returning path of local host
        log.info(reqBody);                          //logging the request in Logs (viewed on Heroku logs)
        try {
            Connection conn= getConnection();           //making the connection to database
            Statement s=conn.createStatement();         //creating a query
            //inserting values from request into database in the according columns (table already created)
            String sqlStr = "INSERT INTO usersdata (date, time, hf, hb, tf, tb, raf, rab, laf, lab, " +
                    "rlf, rlb, llf, llb, treatmentyorn, treatmentused, location, temperature, humidity, " +
                    "pollutionlevel, pollenlevel, hftreated, hbtreated, tftreated, tbtreated, " +
                    "raftreated, rabtreated, laftreated, labtreated, rlftreated, rlbtreated, " +
                    "llftreated, llbtreated, notes) values('"+ test.date+ "','"+ test.time +"','"+ test.hf + "','"+ test.hb + "','"+ test.tf +"'," +
                    "'"+ test.tb +"','"+ test.raf +"','"+ test.rab +"','"+ test.laf +"','"+ test.lab +"'," +
                    "'"+ test.rlf +"','"+ test.rlb +"','"+ test.llf +"','"+ test.llb +"','"+ test.treatmentYorN +"'" +
                    ",'"+ test.treatmentUsed +"','"+ test.location +"','"+ test.temperature +"','"+test.humidity+"','"+ test.pollutionLevel +"'," +
                    "'"+ test.pollenLevel +"','"+ test.hfTreated +"','"+ test.hbTreated +"','"+ test.tfTreated +"','"+ test.tbTreated +"'," +
                    "'"+ test.rafTreated +"','"+ test.rabTreated +"','"+ test.lafTreated +"','"+ test.labTreated +"','"+ test.rlfTreated +"'" +
                    ",'"+ test.rlbTreated +"','"+ test.llfTreated +"','"+ test.llbTreated +"','"+ test.notes +"')";
            s.execute (sqlStr);         //executing query
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("Log saved!");           //sending message to app when log has been saved
    }


//    //Ref 1: code from https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java
    private static Connection getConnection() throws URISyntaxException, SQLException {
       //Below is the link to the database, supposed to use DATABASE_URL, but code wouldn't recognize it
        URI dbUri = new URI("postgres://jhwkfsqyvfessl:fd84735e59925c6062e8d5f7e866afa2b029a4a61a4519e7a0ebf59b3e1b197a@ec2-54-247-82-14.eu-west-1.compute.amazonaws.com:5432/d4a6ke5jmf5tsm");
        //Getting necessary credentials from link
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        //turning link into jdbc link
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() +
                "?&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&user=" + username + "&password=" + password;
        //returning the correct link for the database
        return DriverManager.getConnection(dbUrl, username, password);
    }
//    //end of reference 1
}
