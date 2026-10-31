package soal1;

/**
 * Superclass yang merepresentasikan perangkat elektronik dasar.
 */

public class Perangkat {
    // Tarif pajak disimpan sebagai konstanta untuk menghindari magic number
    private static final double TARIF_PAJAK = 0.10;

    private String merek;
    protected double harga;
    private int garansiBulan;

    /**
     * Constructor untuk membuat objek Perangkat baru.
     * 
     * @param merek        merek perangkat
     * @param harga        harga perangkat dasar
     * @param garansiBulan lama garansi dalam bulan
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */

    public Perangkat(String merek, double harga, int garansiBulan) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    /**
     * Mengambil nama merek perangkat.
     * @return merek perangkat
     */

    public String getMerek() {
        return merek;
    }

    /**
     * Mengambil lama garansi perangkat.
     * @return lama garansi dalam bulan
     */

    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Menghitung nilai pajak berdasarkan harga dan tarif pajak tetap.
     * @return nominal pajak perangkat
     */

    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    /**
     * Mengembalikan informasi dasar perangkat.
     * @return string berisi merek dan lama garansi
     */

    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}