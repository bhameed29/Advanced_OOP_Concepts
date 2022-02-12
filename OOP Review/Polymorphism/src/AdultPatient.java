import java.util.ArrayList;

public class AdultPatient extends Person implements Diagnosable,Employable
{
    double temperature;
    int systolic;
    int diastolic;
    ArrayList<String> previousjobs;

    @Override
    public double getTemperature() {return temperature;}

    @Override
    public int getSystolic() {return systolic;}

    @Override
    public int getDiastolic() {return diastolic;}

    @Override
    public void setTemperature(double t) {temperature = t;}

    @Override
    public void setSystolic(int s) {systolic = s;}

    @Override
    public void setDiastolic(int d) {diastolic = d;}

    @Override
    public ArrayList<String> getPreviousJobs(){return this.previousjobs;}

    @Override
    public void addJob(String job)
    {
        if(this.previousjobs== null)
            this.previousjobs = new ArrayList<String>();
        this.previousjobs.add(job);
    }
}