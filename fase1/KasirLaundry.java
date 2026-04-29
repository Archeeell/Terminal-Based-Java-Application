import java.util.ArrayList;

public class KasirLaundry {
    ArrayList<Pesanan> daftarPesanan = new ArrayList<Pesanan>();
    int counterID = 1;

    // tambah pesanan baru
    public void tambahPesanan(Pelanggan pelanggan, String jenisLayanan, double berat) {
        String id = "LDR-" + counterID;
        counterID++;
        Pesanan p = new Pesanan(id, pelanggan, jenisLayanan, berat);
        daftarPesanan.add(p);
        System.out.println("Pesanan berhasil ditambahkan! ID: " + id);
    }

    // update status pesanan
    public void updateStatus(String idPesanan, String statusBaru) {
        boolean ketemu = false;
        for (int i = 0; i < daftarPesanan.size(); i++) {
            if (daftarPesanan.get(i).getIdPesanan() == idPesanan) {
                daftarPesanan.get(i).setStatus(statusBaru);
                System.out.println("Status berhasil diubah!");
                ketemu = true;
            }
        }
        if (ketemu == false) {
            System.out.println("ID Pesanan tidak ditemukan!");
        }
    }

    // tampilkan semua pesanan
    public void tampilSemuaPesanan() {
        if (daftarPesanan.size() == 0) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        for (int i = 0; i < daftarPesanan.size(); i++) {
            daftarPesanan.get(i).tampilPesanan();
            System.out.println("---------------------");
        }
    }

    // cari pesanan by id
    public Pesanan cariPesanan(String idPesanan) {
        for (int i = 0; i < daftarPesanan.size(); i++) {
            if (daftarPesanan.get(i).getIdPesanan() == idPesanan) {
                return daftarPesanan.get(i);
            }
        }
        return null;
    }
}