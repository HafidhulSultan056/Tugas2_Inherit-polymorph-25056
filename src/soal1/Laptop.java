package soal1;

public class Laptop extends Perangkat {
    private int ramGb;
    private double ukuranLayarInci;

    /**
     * Constructor untuk membuat objek Laptop baru.
     * Wajib memanggil constructor superclass di baris pertama.
     * 
     * @param merek           merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    lama garansi dalam bulan
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar diagonal dalam inci
     */

    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga setelah diberikan diskon.
     * Mendemonstrasikan akses langsung ke atribut protected 'harga' milik superclass.
     * 
     * @param diskonPersen persentase diskon yang diberikan
     * @return harga akhir setelah dipotong diskon
     */

    public double hitungHargaPromo(double diskonPersen) {
        double nominalDiskon = harga * (diskonPersen / 100.0);
        return harga - nominalDiskon;
    }

    /**
     * Mengembalikan informasi singkat laptop dengan menambahkan spesifikasi RAM dan layar.
     * Menggunakan method infoSingkat() dari superclass.
     * 
     * @return string informasi laptop
     */

    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}
