package soal3;

public class Garis {
    private Titik awal;
    private Titik akhir;

    /**
     * Constructor untuk membentuk garis dari dua titik ujung menggunakan defensive copy 
     * untuk mencegah terjadinya aliasing atau kebocoran referensi memori.
     * 
     * @param awal  koordinat objek titik awal garis
     * @param akhir koordinat objek titik akhir garis
     */
    public Garis(Titik awal, Titik akhir) {
        this.awal = awal;
        this.akhir = akhir;
    }

    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    public Titik getAwal() {
        return awal;
    }

    public void setAwal(Titik awal) {
        this.awal = awal;
    }

    public Titik getAkhir() {
        return akhir;
    }

    public void setAkhir(Titik akhir) {
        this.akhir = akhir;
    }

    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    @Override
    public String toString() {
        return awal.toString() + " - " + akhir.toString();
    }
}
