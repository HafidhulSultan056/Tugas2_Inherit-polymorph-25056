package soal1;

public class Laptop extends Perangkat {
    private int ramGb;
    private double ukuranLayarInci;

    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }
    public double hitungHargaPromo(double diskonPersen) {
        double nominalDiskon = harga * (diskonPersen / 100.0);
        return harga - nominalDiskon;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }  
}
