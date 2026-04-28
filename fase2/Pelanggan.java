package fase2;

public class Pelanggan {

    private String nama;
    private String nomorTelepon;
    private String alamat;

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

    //setter+validasi

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama tidak boleh kosong.");
        }
    }

    public void setNomorTelepon(String nomorTelepon) {
        if (nomorTelepon != null && !nomorTelepon.trim().isEmpty()) {
            this.nomorTelepon = nomorTelepon;
        } else {
            System.out.println("Nomor telepon tidak boleh kosong.");
        }
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