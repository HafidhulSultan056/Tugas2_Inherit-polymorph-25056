package soal4;

public class Produk {
    private String kode;
    private String nama;
    protected double hargaDasar;

    /**
 * Constructor utama untuk semua jenis produk di toko digital.
 * Melakukan validasi untuk memastikan harga tidak negatif dan kode tidak kosong.
 * 
 * @param nama  nama atau judul produk yang dijual
 * @param harga harga dasar produk sebelum kalkulasi diskon/pajak (tidak boleh negatif)
 * @param kode  kode unik identifikasi produk (tidak boleh kosong atau null)
 * @throws IllegalArgumentException jika parameter harga negatif atau kode kosong
 */
    public Produk(String kode, String nama, double hargaDasar) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif");
        }
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double hitungHargaAkhir() {
        return hargaDasar;
    }

    public String deskripsi() {
        return "produk umum";
    }
}
