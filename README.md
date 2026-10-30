Pertanyaan Tambahan Soal 1: Jika atribut harga diubah menjadi private, muncul pesan error "The field Perangkat.harga is not visible" atau "harga has private access in Perangkat".
Alasan: Hak akses private membatasi akses suatu atribut hanya di dalam kelas tempat atribut itu dideklarasikan (yaitu kelas Perangkat). Akibatnya, subclass seperti Laptop tidak mewarisi dan tidak bisa lagi mengakses atribut harga secara langsung dari dalam method hitungHargaPromo miliknya. Untuk membagikan akses ke subclass tanpa membukanya untuk umum (public), kita harus menggunakan hak akses protected.

### Jawaban Soal 2: Analisis Output, Error, dan Polimorfisme

**Bagian A**
1. **Output Program:**
   Hewan dibuat: Tom
   Kucing dibuat
   Tom makan
   meong
   Tom memanjat
   Hewan dibuat: Generik
   Exception in thread "main" java.lang.ClassCastException...
2. **Error `h.panjat();`:** Jika komentar dihapus, akan terjadi **error kompilasi (compile-time error)**. Alasannya, tipe statis variabel `h` adalah `Hewan`, dan Java hanya mengecek tipe statis saat kompilasi. Karena kelas `Hewan` tidak memiliki method `panjat()`, kompilator akan menolaknya meskipun tipe dinamisnya (objek aslinya) adalah `Kucing`.
3. **Penyebab ClassCastException:** Terjadi pada baris `Kucing k2 = (Kucing) h2;`. Objek `h2` murni dibuat sebagai `Hewan`, bukan `Kucing`, sehingga tidak bisa di-downcast.
   *Perbaikan:* 
   `if (h2 instanceof Kucing) { Kucing k2 = (Kucing) h2; k2.panjat(); }`
4. **Analisis `h.makan()`:** Method `suara()` yang dijalankan adalah milik kelas `Kucing` (mencetak "meong"). Meskipun `h` memiliki tipe statis `Hewan`, tipe dinamisnya adalah `Kucing`. Dalam polimorfisme Java, method yang di-override selalu dieksekusi berdasarkan tipe dinamisnya (objek aslinya) saat runtime.

**Bagian B**
5. **Output `new B();`:**
   A dibuat
   init B, nilai=0
   B dibuat, nilai=5
   *Penjelasan:* Saat constructor `A` dipanggil via `super()`, ia langsung menjalankan method `init()`. Karena `init()` di-override oleh `B`, versi `B` yang berjalan. Namun, atribut `nilai` di kelas `B` belum sempat diinisialisasi (masih bernilai default `0`). Memanggil method yang bisa di-override dari dalam constructor sangat berisiko karena subclass bisa saja menggunakan variabel yang nilainya belum siap.

**Bagian C**
6. **Analisis `l3.luas()` dan relasi is-a:** `l3.luas()` menghasilkan `0.0` karena tipe dinamis `l3` adalah `Titik`, sehingga method `luas()` milik `Titik` yang tereksekusi. Relasi "Titik adalah sebuah Lingkaran" sebenarnya **kurang masuk akal (dipaksakan)**. Konsekuensinya, jika ada kode yang berasumsi bahwa semua objek `Lingkaran` pasti memiliki luas lebih dari 0, program tersebut akan mengalami *bug*/error logika saat disusupi objek `Titik`.

### Analisis Konsep
1. **Perbedaan Overriding dan Overloading:**
   *Overriding* adalah menulis ulang method dari superclass di subclass dengan nama dan parameter yang persis sama, berkaitan erat dengan *inheritance* dan menjadi dasar terbentuknya polimorfisme (contoh: method `infoSingkat()` di `Laptop` menimpa versi di `Perangkat`). *Overloading* adalah membuat beberapa method dengan nama sama tetapi parameter berbeda di dalam satu kelas yang sama, dan tidak berkaitan dengan polimorfisme saat *runtime* (contoh: dua *constructor* di kelas `Garis` dengan jumlah parameter berbeda).

2. **Kapan Memilih Inheritance vs Composition:**
   *Inheritance* dipilih ketika ada hubungan logis "adalah sebuah" (*is-a*), di mana subclass memperluas fungsi dasar superclass (contoh di tugas: `Ponsel` adalah sebuah `Perangkat`). *Composition* dipilih ketika ada hubungan "memiliki" (*has-a*), di mana sebuah kelas dirakit menggunakan objek dari kelas lain sebagai komponennya (contoh di tugas: `Garis` memiliki dua titik ujung dari objek `Titik`, dan `Keranjang` memiliki daftar `Produk`).

3. **Instanceof pada cetakStruk() vs hitungPerJenis():**
   Method `cetakStruk()` tidak memerlukan `instanceof` karena menggunakan polimorfisme; Java otomatis memanggil method `deskripsi()` dan `hitungHargaAkhir()` milik objek aslinya (dinamik) tanpa perlu dicek manual. Sebaliknya, `hitungPerJenis()` butuh `instanceof` karena tugasnya mengklasifikasikan dan menghitung jumlah spesifik masing-masing *subclass*. *Downcasting* tidak selalu aman karena jika kita memaksa *cast* objek ke tipe yang bukan tipe aslinya (misal memaksa `ProdukFisik` menjadi `Langganan`), program akan *crash* dan melempar `ClassCastException`.