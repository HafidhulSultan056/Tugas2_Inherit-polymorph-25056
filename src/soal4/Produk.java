package soal4;

public class Produk {
    private String kode;
    private String nama;
    protected double hargaDasar;

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

    public String getKode() { return kode; }
    public String getNama() { return nama; }

    public double hitungHargaAkhir() {
        return hargaDasar;
    }

    public String deskripsi() {
        return "produk umum";
    }
}
