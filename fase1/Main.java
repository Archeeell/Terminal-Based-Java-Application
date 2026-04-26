// Fase 1 - Kode Mandiri (belum disempurnakan)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KasirLaundry kasir = new KasirLaundry();
        int pilihan = 0;

        System.out.println("============================");
        System.out.println("   APLIKASI LAUNDRY SEDERHANA");
        System.out.println("============================");

        while (pilihan != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Pesanan Baru");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Update Status Pesanan");
            System.out.println("4. Cari Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {
                System.out.print("Nama pelanggan: ");
                String nama = sc.nextLine();
                System.out.print("Nomor telepon: ");
                String telepon = sc.nextLine();
                System.out.print("Alamat: ");
                String alamat = sc.nextLine();
                Pelanggan pel = new Pelanggan(nama, telepon, alamat);

                System.out.print("Jenis layanan (reguler/express): ");
                String jenis = sc.nextLine();
                System.out.print("Berat cucian (kg): ");
                double berat = sc.nextDouble();
                sc.nextLine();

                kasir.tambahPesanan(pel, jenis, berat);

            } else if (pilihan == 2) {
                kasir.tampilSemuaPesanan();

            } else if (pilihan == 3) {
                System.out.print("Masukkan ID Pesanan: ");
                String id = sc.nextLine();
                System.out.println("Pilih status baru:");
                System.out.println("1. dicuci");
                System.out.println("2. disetrika");
                System.out.println("3. siap diambil");
                System.out.print("Pilih: ");
                int pil = sc.nextInt();
                sc.nextLine();
                String statusBaru = "";
                if (pil == 1) statusBaru = "dicuci";
                else if (pil == 2) statusBaru = "disetrika";
                else if (pil == 3) statusBaru = "siap diambil";
                kasir.updateStatus(id, statusBaru);

            } else if (pilihan == 4) {
                System.out.print("Masukkan ID Pesanan: ");
                String id = sc.nextLine();
                Pesanan p = kasir.cariPesanan(id);
                if (p != null) {
                    p.tampilPesanan();
                } else {
                    System.out.println("Pesanan tidak ditemukan!");
                }

            } else if (pilihan == 5) {
                System.out.println("Terima kasih! Sampai jumpa.");

            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        sc.close();
    }
}