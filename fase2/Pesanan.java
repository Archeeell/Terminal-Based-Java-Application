package fase2;

public class Pesanan {

    private final String idPesanan;
    private final Pelanggan pelanggan;
    private final JenisLayanan jenisLayanan;
    private final double beratCucian;
    private String status;
    private final double totalBiaya;

    // Status yang valid
    public static final String STATUS_MASUK       = "Masuk";
    public static final String STATUS_DICUCI      = "Dicuci";
    public static final String STATUS_DISETRIKA   = "Disetrika";
    public static final String STATUS_SIAP        = "Siap Diambil";

    public Pesanan(String idPesanan, Pelanggan pelanggan, JenisLayanan jenisLayanan, double beratCucian) {
        this.idPesanan    = idPesanan;
        this.pelanggan    = pelanggan;
        this.jenisLayanan = jenisLayanan;
        this.beratCucian  = beratCucian;
        this.status       = STATUS_MASUK;
        this.totalBiaya   = hitungBiaya();
    }

    private double hitungBiaya() {
        double berat = Math.max(beratCucian, 1.0); // minimum 1 kg
        return berat * jenisLayanan.getHargaPerKg();
    }

    // getter
    public String getIdPesanan()        { return idPesanan; }
    public Pelanggan getPelanggan()     { return pelanggan; }
    public JenisLayanan getJenisLayanan() { return jenisLayanan; }
    public double getBeratCucian()      { return beratCucian; }
    public String getStatus()           { return status; }
    public double getTotalBiaya()       { return totalBiaya; }

    // setter
    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilPesanan() {
        System.out.println("================================");
        System.out.println("  Detail Pesanan");
        System.out.println("================================");
        System.out.println("ID Pesanan   : " + idPesanan);
        System.out.println("Pelanggan    : " + pelanggan.getNama());
        System.out.println("Telepon      : " + pelanggan.getNomorTelepon());
        System.out.println("Jenis        : " + jenisLayanan.getLabel());
        System.out.printf ("Berat        : %.1f kg%n", beratCucian);
        System.out.println("Status       : " + status);
        System.out.printf ("Total Biaya  : Rp %,.0f%n", totalBiaya);
        System.out.println("================================");
    }
}
