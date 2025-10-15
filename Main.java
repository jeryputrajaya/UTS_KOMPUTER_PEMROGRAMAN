import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        perpustakaan perpustakaan = new perpustakaan();

        System.out.println("==== SISTEM PERPUSTAKAAN ====");
        System.out.print("Masukkan jumlah buku yang ingin ditambahkan: ");
        int jumlahBuku = input.nextInt();
        input.nextLine(); // bersihkan buffer

        // Input data buku dari pengguna
        for (int i = 1; i <= jumlahBuku; i++) {
            System.out.println("\nMasukkan data buku ke-" + i + ":");
            System.out.print("Judul buku: ");
            String judul = input.nextLine();
            System.out.print("Penulis: ");
            String penulis = input.nextLine();
            System.out.print("Kategori: ");
            String kategori = input.nextLine();
            System.out.print("Stok: ");
            int stok = input.nextInt();
            input.nextLine(); // bersihkan buffer

            perpustakaan.tambahBuku(new Buku(judul, penulis, kategori, stok));
        }

        // Tampilkan daftar buku yang sudah dimasukkan
        perpustakaan.tampilkanBuku();

        // Pilih kategori untuk rekomendasi
        System.out.print("\nMASUKKAN KATEGORI YANG INGIN ANDA PILIH: ");
        String kategoriFavorit = input.nextLine();
        perpustakaan.rekomendasiBuku(kategoriFavorit);

        // Peminjaman buku
        System.out.print("\nBerapa jumlah buku yang ingin Anda pinjam? ");
        int jumlahPinjam = input.nextInt();
        input.nextLine(); // bersihkan buffer

        for (int i = 1; i <= jumlahPinjam; i++) {
            System.out.print("Masukkan judul buku ke-" + i + " yang ingin Anda pinjam: ");
            String judulPinjam = input.nextLine();
            perpustakaan.kurangiStok(judulPinjam);
        }

        input.close();
    }
}
