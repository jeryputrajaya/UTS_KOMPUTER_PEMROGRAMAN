import java.util.ArrayList;

class perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    // Menambah buku ke daftar
    public void tambahBuku(Buku b) {
        daftarBuku.add(b);
    }

    // Menampilkan semua buku
    public void tampilkanBuku() {
        System.out.println("\n=-=-= DAFTAR BUKU =-=-=");
        for (Buku b : daftarBuku) {
            System.out.println("Judul: " + b.getJudul()
                    + ", Penulis: " + b.getPenulis()
                    + ", Kategori: " + b.getKategori()
                    + ", Stok: " + b.getStok());
        }
    }

    // Rekomendasi buku berdasarkan kategori
    public void rekomendasiBuku(String kategori) {
        System.out.println("\n=-=-= REKOMENDASI BUKU UNTUK KATEGORI: " + kategori + " =-=-=");
        boolean ditemukan = false;

        for (Buku b : daftarBuku) {
            if (b.getKategori().equalsIgnoreCase(kategori)) {
                System.out.println("- " + b.getJudul() + " (Penulis: " + b.getPenulis() + ", Stok: " + b.getStok() + ")");
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada buku dengan kategori tersebut.");
        }
    }

    // Mengurangi stok buku saat dipinjam
    public void kurangiStok(String judul) {
        for (Buku b : daftarBuku) {
            if (b.getJudul().equalsIgnoreCase(judul)) {
                if (b.getStok() > 0) {
                    b.setStok(b.getStok() - 1);
                    System.out.println("✅ Buku \"" + judul + "\" berhasil dipinjam. Sisa stok: " + b.getStok());
                } else {
                    System.out.println("❌ Stok buku \"" + judul + "\" habis!");
                }
                return;
            }
        }
        System.out.println("⚠ Buku dengan judul \"" + judul + "\" tidak ditemukan.");
    }
}
