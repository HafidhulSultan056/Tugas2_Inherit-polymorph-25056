package soal1;

public class Ponsel extends Perangkat {
    private int kapasitasGb;
    private int jumlahKamera;

    /**
     * Constructor untuk membuat objek Ponsel baru.
     * 
     * @param merek        merek ponsel
     * @param harga        harga ponsel
     * @param garansiBulan lama garansi dalam bulan
     * @param kapasitasGb  kapasitas penyimpanan internal dalam GB
     * @param jumlahKamera jumlah kamera yang dimiliki ponsel
     */

    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    /**
     * Mengembalikan informasi singkat ponsel dengan spesifikasi tambahan.
     * Menggunakan method infoSingkat() dari superclass.
     * 
     * @return string informasi ponsel
     */

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}
