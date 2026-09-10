public class Member extends User {

    public Member(String nama) {
        super(nama, "Member");
    }

    // Menampilkan daftar lagu
    public void lihatDaftarLagu(Lagu[] playlist, int jumlahLagu) {
        for (int i = 0; i < jumlahLagu; i++) {
            playlist[i].tampilkanInfo();
        }
    }

    // Mencari lagu berdasarkan judul
    public void cariLagu(Lagu[] playlist, int jumlahLagu, String judul) {
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Lagu ditemukan:");
                playlist[i].tampilkanInfo();
                return;
            }
        }
        System.out.println("Lagu tidak ditemukan.");
    }

    // Menghitung rata-rata durasi lagu
    public double hitungRataRataDurasi(Lagu[] playlist, int jumlahLagu) {
        if (jumlahLagu == 0) {
            return 0;
        }

        double total = 0;

        for (int i = 0; i < jumlahLagu; i++) {
            total += playlist[i].getDurasi();
        }

        return total / jumlahLagu;
    }

    // Menampilkan akses Member
    @Override
    public void tampilkanAkses() {
        System.out.println("Member bisa melihat, mencari lagu, dan menghitung rata-rata durasi.");
    }

    public void getUserDetails() {
        System.out.println("Nama: " + getNama());
        System.out.println("Role: " + getRole());
    }
}