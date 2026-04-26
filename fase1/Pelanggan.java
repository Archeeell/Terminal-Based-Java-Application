// Fase 1 - Kode Mandiri (belum disempurnakan)
public class Pelanggan {
    String nama;
    String nomorTelepon;
    String alamat;

    // constructor
    public Pelanggan(String nama, String nomorTelepon, String alamat) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
    }

    // getter
    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    // setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void tampilInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Telepon: " + nomorTelepon);
        System.out.println("Alamat: " + alamat);
    }
}