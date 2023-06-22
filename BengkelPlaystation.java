import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class PlayStation {
    String serialNumber;
    String problem;
    boolean repaired;

    public PlayStation(String serialNumber, String problem) {
        this.serialNumber = serialNumber;
        this.problem = problem;
        this.repaired = false;
    }
}

public class BengkelPlaystation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<PlayStation> repairQueue = new LinkedList<>();
        LinkedList<PlayStation> repairList = new LinkedList<>();
        HashMap<String, PlayStation> repairTable = new HashMap<>();

        int choice;
        do {
            System.out.println("~~~~~~~~~~~~ BENK Bengkel Servis PlayStation Lugonto ~~~~~~~~~~~~");
            System.out.println("1. Masukkan PlayStation ke dalam antrian");
            System.out.println("2. Keluarkan PlayStation dari antrian");
            System.out.println("3. Informasi servis PlayStation");
            System.out.println("4. Cek jumlah antrian");
            System.out.println("5. Keluar dari program");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan serial number PlayStation: ");
                    String serialNumber = scanner.nextLine();
                    System.out.print("Masukkan jenis kerusakan: ");
                    String problem = scanner.nextLine();
                    PlayStation ps = new PlayStation(serialNumber, problem);
                    repairQueue.add(ps);
                    repairList.add(ps);
                    repairTable.put(serialNumber, ps);
                    System.out.println("PlayStation telah dimasukkan ke dalam antrian.");
                    break; //menghentikan eksekusi dari swith-case

                case 2:
                    PlayStation removedPs = repairQueue.poll();
                    if (removedPs != null) {
                        repairList.remove(removedPs);
                        repairTable.remove(removedPs.serialNumber);
                        System.out.println("PlayStation dengan serial number " + removedPs.serialNumber + " telah dikeluarkan dari antrian.");
                    } else {
                        System.out.println("Antrian kosong.");
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Masukkan serial number PlayStation yang ingin diperiksa: ");
                    String searchSerialNumber = scanner.nextLine();
                    PlayStation searchedPs = repairTable.get(searchSerialNumber);
                    if (searchedPs != null) {
                        System.out.println("Informasi servis PlayStation:");
                        System.out.println("Serial Number: " + searchedPs.serialNumber);
                        System.out.println("Jenis Kerusakan: " + searchedPs.problem);
                        System.out.println("Status Perbaikan: " + (searchedPs.repaired ? "Sudah diperbaiki" : "Belum diperbaiki"));
                    } else {
                        System.out.println("PlayStation dengan serial number " + searchSerialNumber + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Jumlah antrian saat ini: " + repairQueue.size());
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan program BENK Bengkel Servis PlayStation Lugonto.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
