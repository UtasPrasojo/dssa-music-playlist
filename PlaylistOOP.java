// Nama dan NIM Team Assignment 1 DSSA (LEC)
// CHRISTIAN HOTASI VICCARE HUTAGAOL - 2902804014
// FAIZA KURNIAWATI - 2902807880
// ARI JUNIANTO - 2902828701
// UTAS PRASOJO - 2902809551
// HANDSON PANGGABEAN - 2902820005
//
// PlaylistOOP.java - Program utama (integrasi) yang memanggil class
// User, Admin, Member, dan Lagu dari file masing-masing (Admin.java,
// Lagu.java, Member.java, User.java) untuk menjalankan menu interaktif
// dan mode testing/demo.

import java.util.Scanner;

public class PlaylistOOP {

    private static final int MAX_LAGU = 50;
    private static Lagu[] playlist = new Lagu[MAX_LAGU];
    private static int jumlahLagu = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut = true;

        System.out.println("=====================================");
        System.out.println(" SELAMAT DATANG DI PLAYLIST MANAGER ");
        System.out.println("=====================================");

        while (lanjut) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("3. Jalankan Testing / Demo Program");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    loginAdmin();
                    break;
                case "2":
                    loginMember();
                    break;
                case "3":
                    jalankanTesting();
                    break;
                case "4":
                    lanjut = false;
                    System.out.println("Terima kasih telah menggunakan Playlist Manager!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        sc.close();
    }

    // -----------------------------------------------------------------
    // Sesi Admin (memanggil method dari class Admin di Admin.java)
    // -----------------------------------------------------------------
    private static void loginAdmin() {
        System.out.print("\nMasukkan nama Admin: ");
        String nama = sc.nextLine().trim();
        Admin admin = new Admin(nama);

        boolean logout = false;
        while (!logout) {
            System.out.println("\n--- MENU ADMIN (" + admin.getNama() + ") ---");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Semua Lagu");
            System.out.println("3. Lihat Info Akun");
            System.out.println("4. Lihat Hak Akses");
            System.out.println("5. Logout");
            System.out.print("Pilih menu (1-5): ");

            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    System.out.print("Judul lagu   : ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Artis        : ");
                    String artis = sc.nextLine().trim();
                    double durasi = bacaDouble("Durasi (menit): ");
                    jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu(judul, artis, durasi));
                    break;
                case "2":
                    tampilkanSemuaLagu();
                    break;
                case "3":
                    admin.tampilkanInfo();
                    break;
                case "4":
                    admin.tampilkanAkses();
                    break;
                case "5":
                    logout = true;
                    System.out.println("Logout dari akun Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    // -----------------------------------------------------------------
    // Sesi Member (memanggil method dari class Member di Member.java)
    // -----------------------------------------------------------------
    private static void loginMember() {
        System.out.print("\nMasukkan nama Member: ");
        String nama = sc.nextLine().trim();
        Member member = new Member(nama);

        boolean logout = false;
        while (!logout) {
            System.out.println("\n--- MENU MEMBER (" + member.getNama() + ") ---");
            System.out.println("1. Lihat Daftar Lagu");
            System.out.println("2. Cari Lagu");
            System.out.println("3. Hitung Rata-rata Durasi");
            System.out.println("4. Lihat Info Akun");
            System.out.println("5. Lihat Hak Akses");
            System.out.println("6. Logout");
            System.out.print("Pilih menu (1-6): ");

            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    member.lihatDaftarLagu(playlist, jumlahLagu);
                    break;
                case "2":
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String judul = sc.nextLine().trim();
                    member.cariLagu(playlist, jumlahLagu, judul);
                    break;
                case "3":
                    double rata = member.hitungRataRataDurasi(playlist, jumlahLagu);
                    System.out.printf("Rata-rata durasi lagu: %.2f menit%n", rata);
                    break;
                case "4":
                    member.getUserDetails();
                    break;
                case "5":
                    member.tampilkanAkses();
                    break;
                case "6":
                    logout = true;
                    System.out.println("Logout dari akun Member.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    // -----------------------------------------------------------------
    // Mode Testing / Demo
    // Menjalankan skenario otomatis untuk membuktikan seluruh fitur
    // (enkapsulasi, inheritance, polymorphism) berjalan dengan benar,
    // dengan memanggil method dari class Admin, Member, Lagu, dan User.
    // -----------------------------------------------------------------
    private static void jalankanTesting() {
        System.out.println("\n=====================================");
        System.out.println("         MODE TESTING / DEMO        ");
        System.out.println("=====================================");

        Admin admin = new Admin("Admin Uji");
        Member member = new Member("Member Uji");

        System.out.println("\n[1] Menambahkan lagu ke playlist melalui Admin...");
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Bohemian Rhapsody", "Queen", 5.55));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Imagine", "John Lennon", 3.03));
        jumlahLagu = admin.tambahLagu(playlist, jumlahLagu, new Lagu("Shape of You", "Ed Sheeran", 3.53));

        System.out.println("\n[2] Menampilkan seluruh lagu...");
        tampilkanSemuaLagu();

        System.out.println("\n[3] Menampilkan daftar lagu (via Member)...");
        member.lihatDaftarLagu(playlist, jumlahLagu);

        System.out.println("\n[4] Mencari lagu \"Imagine\" (via Member)...");
        member.cariLagu(playlist, jumlahLagu, "Imagine");

        System.out.println("\n[5] Mencari lagu yang tidak ada (\"Halo\")...");
        member.cariLagu(playlist, jumlahLagu, "Halo");

        System.out.println("\n[6] Menghitung rata-rata durasi lagu (via Member)...");
        double rata = member.hitungRataRataDurasi(playlist, jumlahLagu);
        System.out.printf("Rata-rata durasi: %.2f menit%n", rata);

        System.out.println("\n[7] Demonstrasi Polymorphism (User[] berisi Admin & Member)...");
        User[] users = { admin, member };
        for (User u : users) {
            System.out.print("- " + u.getNama() + " (" + u.getRole() + "): ");
            u.tampilkanAkses(); // method yang dipanggil berbeda tergantung objek asli (Admin/Member)
        }

        System.out.println("\nTesting selesai. Data lagu di atas ikut tersimpan pada playlist utama.");
    }

    // -----------------------------------------------------------------
    // Utility: menampilkan seluruh isi playlist (memanggil Lagu.tampilkanInfo())
    // -----------------------------------------------------------------
    private static void tampilkanSemuaLagu() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.println("--- Lagu " + (i + 1) + " ---");
            playlist[i].tampilkanInfo();
        }
    }

    // -----------------------------------------------------------------
    // Utility: membaca input angka desimal dengan validasi sederhana
    // -----------------------------------------------------------------
    private static double bacaDouble(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka (contoh: 3.45).");
            }
        }
    }
}
