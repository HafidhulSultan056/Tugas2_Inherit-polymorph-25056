package soal3;

public class Titik {
    private double x;
    private double y;

    public Titik() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x;}
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double jarakKe(Titik lain) {
        double dx = this.x - lain.getX();
        double dy = this.y - lain.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    @Override 
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
