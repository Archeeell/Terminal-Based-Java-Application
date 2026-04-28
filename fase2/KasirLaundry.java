package fase2;

import java.util.ArrayList;
import java.util.List;

public class KasirLaundry {

    private List<Pesanan> daftarPesanan;
    private int counterID;

    public KasirLaundry() {
        this.daftarPesanan = new ArrayList<>();
        this.counterID = 1;
    }

    public void tambahPesanan(Pelanggan pelanggan, JenisLayanan jenisLayanan, double beratCucian) {
        String id = String.format("LDR-%03d", counterID);
        counterID++;
        Pesanan pesananBaru = new Pesanan(id, pelanggan, jenisLayanan, beratCucian);
        daftarPesanan.add(pesananBaru);
        System.out.println("\n[✓] Pesanan berhasil ditambahkan!");
        System.out.println("    ID Pesanan : " + id);
        System.out.printf ("    Total Biaya: Rp %,.0f%n", pesananBaru.getTotalBiaya());
    }

    public void updateStatus(String idPesanan, String statusBaru) {
        Pesanan pesanan = cariPesanan(idPesanan);
        if (pesanan != null) {
            pesanan.setStatus(statusBaru);
            System.out.println("[✓] Status pesanan " + idPesanan + " berhasil diubah menjadi: " + statusBaru);
        } else {
            System.out.println("[!] ID Pesanan '" + idPesanan + "' tidak ditemukan.");
        }
    }

    public void tampilSemuaPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("[i] Belum ada pesanan yang tercatat.");
            return;
        }
        System.out.println("\n=== DAFTAR SEMUA PESANAN (" + daftarPesanan.size() + " pesanan) ===");
        for (Pesanan p : daftarPesanan) {
            p.tampilPesanan();
        }
    }

    public Pesanan cariPesanan(String idPesanan) {
        for (Pesanan p : daftarPesanan) {
            if (p.getIdPesanan().equals(idPesanan)) {
                return p;
            }
        }
        return null;
    }

    public void tampilPesananByStatus(String status) {
        System.out.println("\n=== PESANAN DENGAN STATUS: " + status.toUpperCase() + " ===");
        boolean ada = false;
        for (Pesanan p : daftarPesanan) {
            if (p.getStatus().equalsIgnoreCase(status)) {
                p.tampilPesanan();
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("[i] Tidak ada pesanan dengan status tersebut.");
        }
    }

    public void tampilRingkasan() {
        double total = 0;
        int jumlahSelesai = 0;
        for (Pesanan p : daftarPesanan) {
            total += p.getTotalBiaya();
            if (p.getStatus().equals(Pesanan.STATUS_SIAP)) {
                jumlahSelesai++;
            }
        }
        System.out.println("\n=== RINGKASAN LAUNDRY ===");
        System.out.println("Total Pesanan     : " + daftarPesanan.size());
        System.out.println("Pesanan Selesai   : " + jumlahSelesai);
        System.out.printf ("Total Pendapatan  : Rp %,.0f%n", total);
    }
}
