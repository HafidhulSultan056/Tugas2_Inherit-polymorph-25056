package soal4;

public class ProdukDigital extends Produk {
    private static final double DISKON_DIGITAL = 0.10;
    private double ukuranMb;

    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);
        this.ukuranMb = ukuranMb;
    }
    
    @Override 
    public double hitungHargaAkhir() {
        return hargaDasar - (hargaDasar * DISKON_DIGITAL);
    }

    @Override 
    public String deskripsi() {
        return "digital " + ukuranMb + " MB";
    }
}
