// Nama dan NIM Team Assignment 1 DSSA (LEC)
// CHRISTIAN HOTASI VICCARE HUTAGAOL - 2902804014
// FAIZA KURNIAWATI - 2902807880
// ARI JUNIANTO - 2902828701
// UTAS PRASOJO - 2902809551
// HANDSON PANGGABEAN - 2902820005

public class Lagu {
    // private atribut untuk menerapkan enkapsulasi
    private String judul;
    private String artis;
    private double durasi; // satuan = menit

    // constructor untuk inisialisasi data lagu
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // getter & setter judul, artis, dan durasi
    public String getJudul() {
        return judul;
    }
    public String getArtis() {
        return artis;
    }
    public double getDurasi() {
        return durasi;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setArtis(String artis) {
        this.artis = artis;
    }
    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    public void tampilkanInfo() {
        System.out.println("Judul : " + judul);
        System.out.println("Artis : " + artis);
        System.out.println("Durasi : " + durasi + " menit");
    }
}