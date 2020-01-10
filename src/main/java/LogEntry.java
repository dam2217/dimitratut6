

public abstract class LogEntry implements java.io.Serializable{
    public CharSequence hf;
    public CharSequence hb;
    public CharSequence tf;
    public CharSequence tb;
    public CharSequence raf;
    public CharSequence rab;
    public CharSequence laf;
    public CharSequence lab;
    public CharSequence rlf;
    public CharSequence rlb;
    public CharSequence llf;
    public CharSequence llb;
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

    public LogEntry(){
        this.hf = "";
        this.hb = "";
        this.tf = "";
        this.tb = "";
        this.raf = "";
        this.rab = "";
        this.laf = "";
        this.lab = "";
        this.rlf = "";
        this.rlb = "";
        this.llf = "";
        this.llb = "";
        this.treatmentYorN = "";
        this.treatmentUsed = "";
        this.temperature = "";
        this.humidity = "";
        this.pollutionLevel = "";
        this.pollenLevel = "";
        this.location = "";
        this.hfTreated = "";
        this.hbTreated = "";
        this.tfTreated = "";
        this.tbTreated = "";
        this.rafTreated = "";
        this.rabTreated = "";
        this.lafTreated = "";
        this.labTreated = "";
        this.rlfTreated = "";
        this.rlbTreated = "";
        this.llfTreated = "";
        this.llbTreated = "";
        this.notes = "";
    }
    public void setHf(CharSequence hf){
        this.hf = hf;
    }
}
