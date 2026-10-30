# Tugas 2 Praktikum PBO: Inheritance, Composition, dan Polymorphism

## Judul dan Identitas
- **Nama Tugas:** Tugas 2 Praktikum PBO - Inheritance, Composition, dan Polymorphism
- **Nama Lengkap:** Muhammad Hafidhul Sultan
- **NPM:** 250810701100056
- **Kelas Praktikum:** Praktikum PBO Kelas A
- **Tautan Repository:** https://github.com/HafidhulSultan056/Tugas2_Inherit-polymorph-25056

## Deskripsi Singkat
Proyek ini merupakan penyelesaian Tugas 2 Praktikum Pemrograman Berbasis Objek (PBO) yang berfokus pada implementasi paradigma OOP di Java. Proyek ini mendemonstrasikan penyelesaian masalah menggunakan *Inheritance* (pewarisan), *Polymorphism* (polimorfisme), *Composition* (komposisi), serta teknik *Defensive Programming* (penanganan Exception) dalam skenario dunia nyata seperti hierarki elektronik dan sistem keranjang toko digital.

## Fitur Utama
- **Soal 1:** Pengguna dapat melihat informasi detail spesifikasi berbagai perangkat elektronik (Laptop, Ponsel, Laptop Gaming) sekaligus menghitung besaran pajak dan harga setelah promo.
- **Soal 2:** Menyajikan simulasi pewarisan sifat pada hewan dan membuktikan konsep tipe statis vs dinamis (*polymorphism*) pada kelas Titik dan Lingkaran.
- **Soal 3:** Pengguna dapat membentuk sebuah garis dari dua buah koordinat titik dan menghitung panjangnya secara akurat tanpa khawatir terjadinya kebocoran memori (*aliasing*).
- **Soal 4:** Toko Digital dapat menambahkan berbagai jenis produk (Fisik, Digital, Langganan) ke dalam satu keranjang belanja, menolak duplikasi kode barang, mencetak struk belanja, dan menghitung rekapitulasi jumlah per jenis produk.

## Konsep OOP yang Diterapkan

| Konsep | Lokasi Penerapan | Alasan Pemilihan |
|---|---|---|
| **Inheritance** | `Laptop extends Perangkat`, `Ponsel extends Perangkat` | Memanfaatkan kembali atribut dasar (merek, harga) dari kelas Induk tanpa harus repot menulis ulang kode dari nol. |
| **Polymorphism** | `Keranjang.java` (method `hitungTotal` & `cetakStruk`) | Memungkinkan perulangan pada satu senarai tipe `Produk` secara umum, tetapi Java secara dinamis menjalankan perhitungan harga yang spesifik pada tiap-tiap sub-kelas. |
| **Composition** | `Garis.java` (menyimpan 2 objek `Titik`) | Sebuah Garis tidak akan eksis tanpa adanya dua entitas Titik (relasi *has-a* yang kuat). |
| **Exception Handling** | `Produk.java` (constructor), `Keranjang.java` | Mencegah instansiasi produk yang tidak masuk akal (harga negatif/nama kosong) dan menolak penginputan kode produk ganda. |
| **Encapsulation** | Semua kelas (penggunaan akses `private`) | Menyembunyikan data sensitif seperti atribut koordinat dan harga agar tidak dimodifikasi secara sembarangan dari luar kelas. |

## 5. Struktur Project

    Tugas2_Inherit-polymorph-25056/
    ├── src/
    │   ├── soal1/ (Berisi Laptop, Ponsel, Perangkat, dll)
    │   ├── soal2/ (Berisi Hewan, Kucing, Lingkaran, A, B, dll)
    │   ├── soal3/ (Berisi Titik, Garis, TesSoal3)
    │   └── soal4/ (Berisi Produk, Keranjang, ProdukFisik, Langganan, dll)
    ├── img/ (Menyimpan tangkapan layar contoh output)
    ├── .gitignore
    └── README.md

## Prasyarat
- **JDK:** Java Development Kit (JDK) 17 atau yang lebih baru.
- **IDE yang Disarankan:** IntelliJ IDEA, Visual Studio Code (dengan ekstensi Java), atau Eclipse.

## Cara Menjalankan Program
**Lewat IDE (IntelliJ / VS Code):**
Buka salah satu file kelas uji (misalnya `TesSoal4.java`), lalu tekan tombol **Run** (ikon *play* berwarna hijau) yang terletak di atas deklarasi `public static void main` atau jalankan lewat menu Run Configuration.

**Lewat Command Line (Terminal):**
1. Buka terminal dan arahkan direktori aktif ke dalam folder `src`: `cd src`
2. Kompilasi kelas dalam paket: `javac soal4/*.java`
3. Eksekusi kelas utama: `java soal4.TesSoal4`

## Contoh Output
*(Ganti tautan di bawah ini dengan nama file screenshot yang sesuai di folder img)*
- Output Soal 1: `![Output 1](img/Cuplikan layar 2026-10-31 002537)`
- Output Soal 2: `![Output 2](img/Cuplikan layar 2026-10-31 002215)`
- Output Soal 3: `![Output 3](img/Cuplikan layar 2026-10-31 002405)`
- Output Soal 4: `![Output 4](img/Cuplikan layar 2026-10-31 002439)`

## Jawaban Soal dan Analisis Konsep
**Pertanyaan Tambahan Soal 1:**
Jika atribut `harga` diubah menjadi `private`, muncul pesan error *"The field Perangkat.harga is not visible"*. Ini terjadi karena hak akses `private` membatasi atribut hanya untuk kelas `Perangkat`. Subclass `Laptop` tidak mewarisinya dan gagal mengaksesnya pada method diskon.

**Jawaban Soal 2:**
1. Error pada `h.panjat();` terjadi karena tipe statis `h` adalah `Hewan`, dan kompilator menolaknya karena `Hewan` tidak punya method `panjat()`.
2. `ClassCastException` terjadi karena objek murni `Hewan` dipaksa di-downcast menjadi `Kucing`. Solusinya adalah memvalidasinya menggunakan `if (h2 instanceof Kucing)`.
3. Konstruktor `A` secara prematur memanggil `init()` versi `B` padahal atribut `nilai` di `B` belum tuntas diinisialisasi (mengembalikan nilai *default* 0).
4. Pemaksaan relasi `Titik extends Lingkaran` memicu bug logika karena `Titik` secara sepihak merombak luas menjadi 0, merusak ekspektasi bahwa semua Lingkaran memiliki luas.

**Pertanyaan Tambahan Soal 3 (Aliasing):**
*Aliasing* terjadi karena konstruktor 1 mengikat langsung referensi memori dari parameter. Saat titik di luar diubah, garis di dalam ikut terpengaruh. Solusinya adalah menggunakan *Defensive Copy* (membuat objek `new Titik` baru di dalam kelas `Garis`).

**Analisis Konsep Utama:**
1. **Perbedaan Overriding dan Overloading:** *Overriding* mengganti perilaku method superclass di subclass dengan parameter yang identik (berkaitan dengan *runtime polymorphism*). *Overloading* adalah membuat banyak method bernama sama di satu kelas namun dengan parameter yang berbeda.
2. **Inheritance vs Composition:** *Inheritance* dipakai jika ada relasi logis *is-a* (contoh: Ponsel adalah Perangkat). *Composition* dipakai jika ada relasi rakitan *has-a* (contoh: Keranjang memiliki Produk).
3. **Instanceof:** `cetakStruk()` otomatis menyeleksi versi method yang tepat berkat tipe dinamis polimorfisme. Namun, `hitungPerJenis()` wajib menggunakan `instanceof` untuk mendata jumlah masing-masing tipe kelas secara akurat untuk hindari *ClassCastException*.

## Batasan dan Pengembangan Lanjutan
- **Batasan:** Program toko digital saat ini bersifat *volatile*. Data keranjang belanja hanya mengandalkan RAM (`ArrayList`) dan akan musnah seluruhnya apabila siklus eksekusi program dihentikan.
- **Pengembangan Lanjutan:** Program ini sangat potensial untuk ditingkatkan dengan mengintegrasikan sistem basis data (seperti MySQL lewat JDBC) agar transaksi menjadi persisten, serta menambahkan antarmuka GUI (misalnya menggunakan JavaFX atau CustomTkinter) agar interaksi pengguna menjadi jauh lebih mulus dibandingkan terminal.