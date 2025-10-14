import java.util.ArrayList;
import java.util.Scanner;

//  CLASS BUKU 
class Buku {
    private String judul;
    private String penulis;
    private String kategori;
    private int stok;

    // Constructor
    public Buku(String judul, String penulis, String kategori, int stok) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

// CLASS PERPUSTAKAAN 
class Perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    // Menambah buku ke daftar
    public void tambahBuku(Buku b) {
        daftarBuku.add(b);
    }

    // Menampilkan semua buku
    public void tampilkanBuku() {
        System.out.println(" DAFTAR BUKU");
        for (Buku b : daftarBuku) {
            System.out.println("Judul: " + b.getJudul()
                    + ", Penulis: " + b.getPenulis()
                    + ", Kategori: " + b.getKategori()
                    + ", Stok: " + b.getStok());
        }
    }

    // Rekomendasi buku berdasarkan kategori
    public void rekomendasiBuku(String kategori) {
        System.out.println(" REKOMENDASI BUKU UNTUK KATEGORI: " + kategori + "");
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
                    System.out.println("v Buku \"" + judul + "\" berhasil dipinjam. Sisa stok: " + b.getStok());
                } else {
                    System.out.println("x Stok buku \"" + judul + "\" habis!");
                }
                return;
            }
        }
        System.out.println(" Buku dengan judul \"" + judul + "\" tidak ditemukan.");
    }
}

// CLASS MAIN
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan();

        // Tambahkan beberapa buku ke perpustakaan
        perpustakaan.tambahBuku(new Buku("Pemrograman Java", "Andi", "Teknologi", 5));
        perpustakaan.tambahBuku(new Buku("Sejarah Dunia", "Budi", "Sejarah", 3));
        perpustakaan.tambahBuku(new Buku("Matematika Dasar", "Citra", "Pendidikan", 7));
        perpustakaan.tambahBuku(new Buku("Teknologi AI", "Dewi", "Teknologi", 4));
        perpustakaan.tambahBuku(new Buku("Fiksi Petualangan", "Eko", "Fiksi", 6));
        perpustakaan.tambahBuku(new Buku("Game Development dan Algoritma", "ETR", "Teknologi", 2));
        perpustakaan.tambahBuku(new Buku("Mekanisme Psikologi Gamers", "ETR", "Teknologi", 1));

        // Tampilkan daftar buku
        perpustakaan.tampilkanBuku();

        // Pilih kategori
        System.out.print("MASUKKAN KATEGORI YANG INGIN ANDA PILIH: ");
        String kategoriFavorit = input.nextLine();

        // Tampilkan rekomendasi berdasarkan kategori
        perpustakaan.rekomendasiBuku(kategoriFavorit);

        // Peminjaman beberapa buku
        System.out.print("Berapa jumlah buku yang ingin Anda pinjam (1-7)? ");
        int jumlahPinjam = input.nextInt();
        input.nextLine(); // membersihkan buffer

        if (jumlahPinjam < 1 || jumlahPinjam > 7) {
            System.out.println("Jumlah pinjam harus antara 1 hingga 7!");
        } else {
            for (int i = 1; i <= jumlahPinjam; i++) {
                System.out.print("Masukkan judul buku ke-" + i + " yang ingin Anda pinjam: ");
                String judulPinjam = input.nextLine();
                perpustakaan.kurangiStok(judulPinjam);
            }
        }

        input.close();
    }
}