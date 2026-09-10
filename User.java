// Nama dan NIM Team Assignment 1 DSSA (LEC)
// CHRISTIAN HOTASI VICCARE HUTAGAOL - 2902804014
// FAIZA KURNIAWATI - 2902807880
// ARI JUNIANTO - 2902828701
// UTAS PRASOJO - 2902809551
// HANDSON PANGGABEAN - 2902820005

public class User {
    // private atribut untuk menerapkan enkapsulasi
    private String nama;
    private String role; // Admin / Member

    // constructor untuk inisialisasi data user
    public User(String nama, String role) {
        this.nama = nama;
        this.role = role;
    }

    // getter & setter untuk nama dan role
    public String getNama() {
        return nama;
    }
    public String getRole() {
        return role;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setRole(String role) {
        this.role = role;
    }

    // method untuk mendapatkan User details
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Role: " + role);
    }

    // Method dasar yang akan di-override oleh Admin & Member (polymorphism)
    public void tampilkanAkses() {
        System.out.println("User memiliki akses umum.");
    }
}