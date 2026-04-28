package fase2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KasirLaundry kasir = new KasirLaundry();

        tampilHeader();

        boolean berjalan = true;
        while (berjalan) {
            tampilMenu();
            int pilihan = bacaAngka(scanner, "Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahPesananBaru(scanner, kasir);
                    break;
                case 2:
                    kasir.tampilSemuaPesanan();
                    break;
                case 3:
                    updateStatusPesanan(scanner, kasir);
                    break;
                case 4:
                    cariPesananMenu(scanner, kasir);
                    break;
                case 5:
                    filterStatusMenu(scanner, kasir);
                    break;
                case 6:
                    kasir.tampilRingkasan();
                    break;
                case 0:
                    System.out.println("\nTerima kasih telah menggunakan Aplikasi Laundry.");
                    System.out.println("Sampai jumpa!");
                    berjalan = false;
                    break;
                default:
                    System.out.println("[!] Pilihan tidak valid. Masukkan angka 0-6.");
            }
        }

        scanner.close();
    }

    // ===== METHOD PEMBANTU =====

    private static void tampilHeader() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     SISTEM MANAJEMEN LAUNDRY     ║");
        System.out.println("║     Bersih Cepat Terpercaya      ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    private static void tampilMenu() {
        System.out.println("\n┌─── MENU UTAMA ───────────────────┐");
        System.out.println("│  1. Tambah Pesanan Baru          │");
        System.out.println("│  2. Lihat Semua Pesanan          │");
        System.out.println("│  3. Update Status Pesanan        │");
        System.out.println("│  4. Cari Pesanan by ID           │");
        System.out.println("│  5. Filter Pesanan by Status     │");
        System.out.println("│  6. Ringkasan & Pendapatan       │");
        System.out.println("│  0. Keluar                       │");
        System.out.println("└──────────────────────────────────┘");
    }

    private static void tambahPesananBaru(Scanner scanner, KasirLaundry kasir) {
        System.out.println("\n--- Tambah Pesanan Baru ---");
        System.out.print("Nama pelanggan  : ");
        String nama = scanner.nextLine().trim();
        System.out.print("Nomor telepon   : ");
        String telepon = scanner.nextLine().trim();
        System.out.print("Alamat          : ");
        String alamat = scanner.nextLine().trim();

        Pelanggan pelanggan = new Pelanggan(nama, telepon, alamat);

        System.out.println("\nPilih jenis layanan:");
        JenisLayanan[] layanan = JenisLayanan.values();
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("  " + (i + 1) + ". " + layanan[i]);
        }
        int pilihanLayanan = bacaAngka(scanner, "Pilih (1-" + layanan.length + "): ");
        if (pilihanLayanan < 1 || pilihanLayanan > layanan.length) {
            System.out.println("[!] Pilihan layanan tidak valid.");
            return;
        }
        JenisLayanan jenisLayanan = layanan[pilihanLayanan - 1];

        double berat = bacaDesimal(scanner, "Berat cucian (kg): ");
        if (berat <= 0) {
            System.out.println("[!] Berat cucian harus lebih dari 0.");
            return;
        }

        kasir.tambahPesanan(pelanggan, jenisLayanan, berat);
    }

    private static void updateStatusPesanan(Scanner scanner, KasirLaundry kasir) {
        System.out.println("\n--- Update Status Pesanan ---");
        System.out.print("ID Pesanan : ");
        String id = scanner.nextLine().trim().toUpperCase();

        System.out.println("Pilih status baru:");
        System.out.println("  1. " + Pesanan.STATUS_MASUK);
        System.out.println("  2. " + Pesanan.STATUS_DICUCI);
        System.out.println("  3. " + Pesanan.STATUS_DISETRIKA);
        System.out.println("  4. " + Pesanan.STATUS_SIAP);
        int pil = bacaAngka(scanner, "Pilih (1-4): ");

        String statusBaru;
        switch (pil) {
            case 1: statusBaru = Pesanan.STATUS_MASUK;     break;
            case 2: statusBaru = Pesanan.STATUS_DICUCI;    break;
            case 3: statusBaru = Pesanan.STATUS_DISETRIKA; break;
            case 4: statusBaru = Pesanan.STATUS_SIAP;      break;
            default:
                System.out.println("[!] Pilihan tidak valid.");
                return;
        }
        kasir.updateStatus(id, statusBaru);
    }

    private static void cariPesananMenu(Scanner scanner, KasirLaundry kasir) {
        System.out.print("\nMasukkan ID Pesanan: ");
        String id = scanner.nextLine().trim().toUpperCase();
        Pesanan hasil = kasir.cariPesanan(id);
        if (hasil != null) {
            hasil.tampilPesanan();
        } else {
            System.out.println("[!] Pesanan dengan ID '" + id + "' tidak ditemukan.");
        }
    }

    private static void filterStatusMenu(Scanner scanner, KasirLaundry kasir) {
        System.out.println("\nFilter berdasarkan status:");
        System.out.println("  1. " + Pesanan.STATUS_MASUK);
        System.out.println("  2. " + Pesanan.STATUS_DICUCI);
        System.out.println("  3. " + Pesanan.STATUS_DISETRIKA);
        System.out.println("  4. " + Pesanan.STATUS_SIAP);
        int pil = bacaAngka(scanner, "Pilih (1-4): ");
        String status;
        switch (pil) {
            case 1: status = Pesanan.STATUS_MASUK;     break;
            case 2: status = Pesanan.STATUS_DICUCI;    break;
            case 3: status = Pesanan.STATUS_DISETRIKA; break;
            case 4: status = Pesanan.STATUS_SIAP;      break;
            default:
                System.out.println("[!] Pilihan tidak valid.");
                return;
        }
        kasir.tampilPesananByStatus(status);
    }

    /**
     * Membaca input angka bulat dengan penanganan error.
     */
    private static int bacaAngka(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            int nilai = scanner.nextInt();
            scanner.nextLine();
            return nilai;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // buang input tidak valid
            return -1;
        }
    }

    /**
     * Membaca input angka desimal dengan penanganan error.
     */
    private static double bacaDesimal(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            double nilai = scanner.nextDouble();
            scanner.nextLine();
            return nilai;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }
}
