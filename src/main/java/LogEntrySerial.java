import java.io.Serializable;

public class LogEntrySerial implements Serializable {
//    public CharSequence hf;
//    public CharSequence hb;
//    public CharSequence tf;
//    public CharSequence tb;
//    public CharSequence raf;
//    public CharSequence rab;
//    public CharSequence laf;
//    public CharSequence lab;
//    public CharSequence rlf;
//    public CharSequence rlb;
//    public CharSequence llf;
//    public CharSequence llb;
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

    public LogEntrySerial(String treatmentyesorno,
                          String treatmentu, String temp, String hum, String pollution,
                          String pollen, String loc, String hft, String hbt, String tft, String tbt,
                          String raft, String rabt, String laft, String labt, String rlft,
                          String rlbt, String llft, String llbt, String n){
//        this.hf = headf;
//        this.hb = headb;
//        this.tf = torsof;
//        this.tb = torsob;
//        this.raf = rarmf;
//        this.rab = rarmb;
//        this.laf = larmf;
//        this.lab = larmb;
//        this.rlf = rlegf;
//        this.rlb = rlegb;
//        this.llf = llegf;
//        this.llb = llegb;
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

//    CharSequence headf, CharSequence headb, CharSequence torsof,
//        CharSequence torsob, CharSequence rarmf,
//        CharSequence rarmb, CharSequence larmf, CharSequence larmb,
//        CharSequence rlegf, CharSequence rlegb,
//        CharSequence llegf, CharSequence llegb,