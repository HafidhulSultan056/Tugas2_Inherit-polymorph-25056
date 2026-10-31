package soal4;

import java.util.ArrayList;

public class Keranjang {
    private ArrayList<Produk> daftarProduk;

    public Keranjang() {
        daftarProduk = new ArrayList<>();
    }

    /**
     * Menambahkan produk ke keranjang.
     * @param p objek produk yang akan ditambahkan
     * @throws IllegalStateException jika kode produk sudah ada di keranjang
     */
    public void tambah(Produk p) {
        for (Produk yangAda : daftarProduk) {
            if (yangAda.getKode().equals(p.getKode())) {
                throw new IllegalStateException("Kode produk " + p.getKode() + " sudah ada!");
            }
        }
        daftarProduk.add(p);
    }

    public double hitungTotal() {
        double total = 0;
        for (Produk p : daftarProduk) {

            total += p.hitungHargaAkhir();
        }
        return total;
    }

    public void cetakStruk() {
        for (Produk p : daftarProduk) {
            System.out.printf("%s | %s | %s | Rp%.0f%n",
                    p.getKode(), p.getNama(), p.deskripsi(), p.hitungHargaAkhir());
        }
        System.out.printf("TOTAL: Rp%.0f%n", hitungTotal());
    }

    public void hitungPerJenis() {
        int fisik = 0;
        int digital = 0;
        int langganan = 0;

        for (Produk p : daftarProduk) {

            if (p instanceof Langganan) {
                langganan++;
            } else if (p instanceof ProdukDigital) {
                digital++;
            } else if (p instanceof ProdukFisik) {
                fisik++;
            }
        }
        System.out.println("Fisik: " + fisik + ", Digital: " + digital + ", Langganan: " + langganan);
    }
}
