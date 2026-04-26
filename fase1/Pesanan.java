// Fase 1 - Kode Mandiri (belum disempurnakan)
public class Pesanan {
    String idPesanan;
    Pelanggan pelanggan;
    String jenisLayanan; // jenis: reguler, express
    double beratCucian; // dalam kg
    String status; // status: masuk, dicuci, disetrika, siap
    double totalBiaya;

    // harga per kg
    static double HARGA_REGULER = 10000;
    static double HARGA_EXPRESS = 20000;

    public Pesanan(String idPesanan, Pelanggan pelanggan, String jenisLayanan, double beratCucian) {
        this.idPesanan = idPesanan;
        this.pelanggan = pelanggan;
        this.jenisLayanan = jenisLayanan;
        this.beratCucian = beratCucian;
        this.status = "masuk";
        hitungBiaya();
    }

    // hitung biaya berdasarkan jenis layanan
    void hitungBiaya() {
        if (jenisLayanan == "express") {
            totalBiaya = beratCucian * HARGA_EXPRESS;
        } else {
            totalBiaya = beratCucian * HARGA_REGULER;
        }
    }

    public String getIdPesanan() { return idPesanan; }
    public String getStatus() { return status; }
    public double getTotalBiaya() { return totalBiaya; }
    public double getBeratCucian() { return beratCucian; }
    public String getJenisLayanan() { return jenisLayanan; }
    public Pelanggan getPelanggan() { return pelanggan; }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilPesanan() {
        System.out.println("=== Detail Pesanan ===");
        System.out.println("ID Pesanan   : " + idPesanan);
        System.out.println("Pelanggan    : " + pelanggan.getNama());
        System.out.println("Telepon      : " + pelanggan.getNomorTelepon());
        System.out.println("Jenis        : " + jenisLayanan);
        System.out.println("Berat        : " + beratCucian + " kg");
        System.out.println("Status       : " + status);
        System.out.println("Total Biaya  : Rp " + totalBiaya);
    }
}