package soal4;

public class ProdukFisik extends Produk {
    private static final double ONGKIR_PER_KG = 10000;
    private double beratKg;

    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        this.beratKg = beratKg;
    }

    @Override
    public double hitungHargaAkhir() {
        return hargaDasar + (beratKg * ONGKIR_PER_KG);
    }

    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }

}
