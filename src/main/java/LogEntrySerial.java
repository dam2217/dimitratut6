import java.io.Serializable;

//mimics class in app - used for sending JSON across
//contains all the information from the log user inputs

public class LogEntrySerial implements Serializable {
    public String date;
    public String time;
    public String hf;
    public String hb;
    public String tf;
    public String tb;
    public String raf;
    public String rab;
    public String laf;
    public String lab;
    public String rlf;
    public String rlb;
    public String llf;
    public String llb;
    public String treatmentYorN;
    public String treatmentUsed;
    public String temperature;
    public String humidity;
    public String pollutionLevel;
    public String pollenLevel;
    public String location;
    public String hfTreated;
    public String hbTreated;
    public String tfTreated;
    public String tbTreated;
    public String rafTreated;
    public String rabTreated;
    public String lafTreated;
    public String labTreated;
    public String rlfTreated;
    public String rlbTreated;
    public String llfTreated;
    public String llbTreated;
    public String notes;

    //constructor
    public LogEntrySerial(String datenow, String timenow, String headf, String headb, String torsof,
                          String torsob, String rarmf,
                          String rarmb, String larmf, String larmb,
                          String rlegf, String rlegb,
                          String llegf, String llegb,String treatmentyesorno,
                          String treatmentu, String temp, String hum, String pollution,
                          String pollen, String loc, String hft, String hbt, String tft, String tbt,
                          String raft, String rabt, String laft, String labt, String rlft,
                          String rlbt, String llft, String llbt, String n){
        this.date = datenow;
        this.time = timenow;
        this.hf = headf;
        this.hb = headb;
        this.tf = torsof;
        this.tb = torsob;
        this.raf = rarmf;
        this.rab = rarmb;
        this.laf = larmf;
        this.lab = larmb;
        this.rlf = rlegf;
        this.rlb = rlegb;
        this.llf = llegf;
        this.llb = llegb;
        this.treatmentYorN = treatmentyesorno;
        this.treatmentUsed = treatmentu;
        this.temperature = temp;
        this.humidity = hum;
        this.pollutionLevel = pollution;
        this.pollenLevel = pollen;
        this.location = loc;
        this.hfTreated = hft;
        this.hbTreated = hbt;
        this.tfTreated = tft;
        this.tbTreated = tbt;
        this.rafTreated = raft;
        this.rabTreated = rabt;
        this.lafTreated = laft;
        this.labTreated = labt;
        this.rlfTreated = rlft;
        this.rlbTreated = rlbt;
        this.llfTreated = llft;
        this.llbTreated = llbt;
        this.notes = n;
    }
}

