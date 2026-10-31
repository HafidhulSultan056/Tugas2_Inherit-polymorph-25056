package soal1;

public class LaptopGaming extends Laptop {
    private static final int TAMBAHAN_GARANSI = 6;

    private String kartuGrafis;

    /**
     * Constructor untuk membuat objek LaptopGaming baru.
     * Menambahkan garansi ekstra secara otomatis saat memanggil super().
     * 
     * @param merek           merek laptop gaming
     * @param harga           harga laptop gaming
     * @param garansiBulan    lama garansi dasar dalam bulan
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar diagonal dalam inci
     * @param kartuGrafis     model kartu grafis (GPU)
     */

    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci,
            String kartuGrafis) {
        super(merek, harga, garansiBulan + TAMBAHAN_GARANSI, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}
