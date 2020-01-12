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
        String datasend = "dick";
        try{ Connection conn =  getConnection();
            System.out.println("b");
            Statement s=conn.createStatement();
            System.out.println("c");
            String sqlStr = "SELECT * FROM userdata WHERE id=1";
            System.out.println("d");
            ResultSet rset=s.executeQuery(sqlStr);
            System.out.println("e");

            System.out.println("sql"+sqlStr);
            boolean isItTrue;
            while((isItTrue = rset.next()) == true){
                System.out.println("f");
                System.out.println();
                datasend = datasend + "\"date\":\""+rset.getString("date")+
                        "\",\"hb\":\""+ rset.getString("hb")+
                        "\",\"hbTreated\":\""+ rset.getString("hbTreated")+
                        "\",\"hf\":\""+ rset.getString("hf") +
                        "\",\"hfTreated\":\""+ rset.getString("hfTreated") +
                        "\",\"humidity\":\""+ rset.getString("humidity") +
                        "\",\"lab\":\""+ rset.getString("lab") +
                        "\",\"labTreated\":\""+ rset.getString("labTreated") +
                        "\",\"laf\":\""+ rset.getString("laf") +
                        "\",\"lafTreated\":\""+ rset.getString("lafTreated") +
                        "\",\"llb\":\""+ rset.getString("llb") +
                        "\",\"llbTreated\":\""+ rset.getString("llbTreated") +
                        "\",\"llf\":\""+ rset.getString("llf") +
                        "\",\"llfTreated\":\""+ rset.getString("llfTreated") +
                        "\",\"location\":\""+ rset.getString("location") +
                        "\",\"notes\":\""+ rset.getString("notes") +
                        "\",\"pollenLevel\":\""+ rset.getString("pollenLevel") +
                        "\",\"pollutionLevel\":\""+ rset.getString("pollutionLevel") +
                        "\",\"rab\":\""+ rset.getString("rab") +
                        "\",\"rabTreated\":\""+ rset.getString("rabTreated") +
                        "\",\"raf\":\""+ rset.getString("raf") +
                        "\",\"rafTreated\":\""+ rset.getString("rafTreated") +
                        "\",\"rlb\":\""+ rset.getString("rlb") +
                        "\",\"rlbTreated\":\""+ rset.getString("rlbTreated") +
                        "\",\"rlf\":\""+ rset.getString("rlf") +
                        "\",\"rlfTreated\":\""+ rset.getString("rlfTreated") +
                        "\",\"tb\":\""+ rset.getString("tb") +
                        "\",\"tbTreated\":\""+ rset.getString("tbTreated") +
                        "\",\"tf\":\""+ rset.getString("tf") +
                        "\",\"tfTreated\":\""+ rset.getString("tfTreated") +
                        "\",\"time\":\""+ rset.getString("time") +
                        "\",\"treatmentUsed\":\""+ rset.getString("treatmentUsed") +
                        "\",\"treatmentYorN\":\""+ rset.getString("treatmentYorN") +
                        "split ";
                System.out.println("A");
                System.out.println(datasend);
                //System.out.println(rset.getInt("id")+" "+ rset.getString("location"));
            }
            System.out.println(datasend);
            rset.close();
            s.close();
            conn.close();
        }catch (Exception e){
            System.out.println("doesn't print");
        }
        resp.getWriter().write(datasend);

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

        req.getServletPath();
        log.info(reqBody);
        System.out.println(test.location);
        try {
            Connection conn= getConnection();
            Statement s=conn.createStatement();
            String sqlStr = "INSERT INTO userdata (date, time, hf, hb, tf, tb, raf, rab, laf, lab, " +
                    "rlf, rlb, llf, llb, treatmentyorn, treatmentused, location, temperature, " +
                    "pollutionlevel, pollenlevel, hftreated, hbtreated, tftreated, tbtreated, " +
                    "raftreated, rabtreated, laftreated, labtreated, rlftreated, rlbtreated, " +
                    "llftreated, llbtreated, notes) values('"+ test.date+ "','"+ test.time +"','"+ test.hf + "','"+ test.hb + "','"+ test.tf +"'," +
                    "'"+ test.tb +"','"+ test.raf +"','"+ test.rab +"','"+ test.laf +"','"+ test.lab +"'," +
                    "'"+ test.rlf +"','"+ test.rlb +"','"+ test.llf +"','"+ test.llb +"','"+ test.treatmentYorN +"'" +
                    ",'"+ test.treatmentUsed +"','"+ test.location +"','"+ test.temperature +"','"+ test.pollutionLevel +"'," +
                    "'"+ test.pollenLevel +"','"+ test.hfTreated +"','"+ test.hbTreated +"','"+ test.tfTreated +"','"+ test.tbTreated +"'," +
                    "'"+ test.rafTreated +"','"+ test.rabTreated +"','"+ test.lafTreated +"','"+ test.labTreated +"','"+ test.rlfTreated +"'" +
                    ",'"+ test.rlbTreated +"','"+ test.llfTreated +"','"+ test.llbTreated +"','"+ test.notes +"')";
            s.execute (sqlStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Log saved!");
        }
//        try{ Connection conn =  getConnection();
//            Statement s=conn.createStatement();
//            String sqlStr = "SELECT * FROM userdata WHERE id>1";
//
//
//            ResultSet rset=s.executeQuery(sqlStr);
//            String datasend = "{";
//            System.out.println("sql"+sqlStr);
//            while(rset.next()){
//                datasend = datasend + "\"date\":\""+rset.getString("date")+"\",\"time\":\""+
//                        rset.getString("time")+"\" split ";
//
//                //System.out.println(rset.getInt("id")+" "+ rset.getString("location"));
//            }
//            datasend = datasend + "}";
//            System.out.println(datasend);
//            rset.close();
//            s.close();
//            conn.close();
//        }catch (Exception e){
//            System.out.println("doesn't print");
//        }
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
