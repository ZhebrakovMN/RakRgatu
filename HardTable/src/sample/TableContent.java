package sample;
public class TableContent {
    private double ki;
    private double yi;
    public TableContent() { }
    public TableContent(double ki, double yi) {
        this.ki = ki;
        this.yi = yi;
    }
    public double getKi() { return ki; }
    public void setKi(double ki) { this.ki = ki; }
    public double getYi() { return yi; }
    public void setYi(double yi) {
        this.yi = yi;
    }
}
