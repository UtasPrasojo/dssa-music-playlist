// Nama dan NIM Team Assignment 1 DSSA (LEC)
// CHRISTIAN HOTASI VICCARE HUTAGAOL - 2902804014
// FAIZA KURNIAWATI - 2902807880
// ARI JUNIANTO - 2902828701
// UTAS PRASOJO - 2902809551
// HANDSON PANGGABEAN - 2902820005

public class Admin extends User {

    // Constructor Admin
    public Admin(String nama) {
        super(nama, "Admin");
    }

    // Menambahkan lagu ke playlist
    public int tambahLagu(Lagu[] playlist, int jumlahLagu, Lagu laguBaru) {

        if (jumlahLagu < playlist.length) {
            playlist[jumlahLagu] = laguBaru;

            System.out.println("Lagu berhasil ditambahkan!");

            return jumlahLagu + 1;
        }

        System.out.println("Playlist sudah penuh!");
        return jumlahLagu;
    }

    // Polymorphism: override method dari User
    @Override
    public void tampilkanAkses() {
        System.out.println("Admin dapat menambahkan lagu ke playlist.");
    }
}