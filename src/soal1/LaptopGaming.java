package soal1;

public class LaptopGaming extends Laptop {
    private static final int TAMBAHAN_GARANSI = 6;

    private String kartuGrafis;

    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci, String kartuGrafis) {
        super (merek, harga, garansiBulan + TAMBAHAN_GARANSI, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}
