// NAMA  : PRANATA PUTRANDANA
// NIM   : 244107060114
// ABSEN : 19
// KELAS : SIB - 1B

import java.util.Scanner;

public class UAS1B19 {
    static Scanner input = new Scanner(System.in);
    static int jumlahTim19 = (14 % 3) + 4;
    static String[][] dataTim19 = new String[jumlahTim19][3];
    static int hitungan19 = 0;
    public static void main(String[] args) {
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.println("=======================================");
            System.out.print("Pilih menu (1-4): ");
            int menu19 = input.nextInt();
            input.nextLine();

            switch (menu19) {
                case 1:
                    InputSkor19();
                    break;
                case 2:
                    TampilkanTabelPemain19();
                    break;
                case 3:
                    TentukanJuara19();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("\nMaaf Menu Tidak Tersedia, Masukkan Ulang Menu");
                    break;
            }
        } while (true);
    }

    //Ini Fungsi Untuk Menginput Skor Tim 
    public static void InputSkor19() {
        if (hitungan19 >= dataTim19.length) {
            System.out.println("Data tim sudah penuh, tidak bisa menambah lagi.");
            return;
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("\nMasukkan data untuk tim ke-" + (i + 1));
            System.out.print("Masukkan nama tim: ");
            dataTim19[i][0] = input.nextLine(); 
            while (true) {
                System.out.print("Masukkan skor untuk Level 1: ");
                int skorLevel1 = input.nextInt();
                if (skorLevel1 >= 0) { 
                    if (skorLevel1 < 35) { 
                        dataTim19[i][1] = "0";
                    } else {
                        dataTim19[i][1] = String.valueOf(skorLevel1); 
                    }
                    input.nextLine(); 
                    break;
                } else { 
                    System.out.println("Input salah. Skor harus bilangan positif / nol.");
                }
            }
            
            while (true) {
                System.out.print("Masukkan skor untuk Level 2: ");
                int skorLevel2 = input.nextInt();
                if (skorLevel2 >= 0) { 
                    dataTim19[i][2] = String.valueOf(skorLevel2); 
                    input.nextLine(); 
                    break;
                } else {
                    System.out.println("Input tidak valid. Skor harus bilangan positif atau nol.");
                }
            }
            hitungan19++;
        }
    }

    // Ini Fungsi untuk Menampilkan Skor dengan Tabel
    public static void TampilkanTabelPemain19() {
        if (hitungan19 == 0) {
            System.out.println("Blud, Tolong Input Dulu di Menu 1! Untuk bisa menampilkan data");
            return;
        }

        System.out.println("\n=== TABEL SKOR TIM ===");
        System.out.printf("%-15s%-10s%-10s%-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        for (int i = 0; i < hitungan19; i++) {
            int totalskor19 = Integer.parseInt(dataTim19[i][1]) + Integer.parseInt(dataTim19[i][2]);
            if (totalskor19 % 2 == 0) {
                totalskor19 -= 15;
            }
            if (Integer.parseInt(dataTim19[i][1]) > 50 && Integer.parseInt(dataTim19[i][2]) > 50) {
                totalskor19 += 19; 
            }
            System.out.printf("%-15s%-10s%-10s%-10s\n", dataTim19[i][0], dataTim19[i][1], dataTim19[i][2], totalskor19);    
        }
    } 

    // Dan ini untuk menentukan dan menampilkan Pemenangnya!
    public static void TentukanJuara19() {
        if (hitungan19 == 0) { 
            System.out.println("Blud, Tolong Input Dulu di Menu 1! Untuk menentukan juara.");
            return;
        }
    
        int maxSkor19 = 0;
        String juaraTim19 = "";
    
        for (int i = 0; i < hitungan19; i++) {
            int totalskor19 = Integer.parseInt(dataTim19[i][1]) + Integer.parseInt(dataTim19[i][2]); 
            if (totalskor19 > maxSkor19) {
                maxSkor19 = totalskor19;
                juaraTim19 = dataTim19[i][0];
            }
        }
    
        int jumlahTimSamaSkor19 = 0;
        String timSamaSkor19 = "";
        for (int i = 0; i < hitungan19; i++) {
            int totalskor19 = Integer.parseInt(dataTim19[i][1]) + Integer.parseInt(dataTim19[i][2]); 
            if (totalskor19 == maxSkor19) {
                jumlahTimSamaSkor19++;
                timSamaSkor19 = dataTim19[i][0];
            }
        }
    
        if (jumlahTimSamaSkor19 > 1) {
            System.out.println("Pertandingan seri pemenangnya PRANATA PUTRANDANA GANTENG SEDUNIA");
            return;
        }
    
        int maxSkorLevel219 = 0;
        String juaraTimLevel219 = "";
    
        for (int i = 0; i < hitungan19; i++) {
            int totalskor19 = Integer.parseInt(dataTim19[i][1]) + Integer.parseInt(dataTim19[i][2]); 
            if (totalskor19 == maxSkor19) {
                int skorLevel219 = Integer.parseInt(dataTim19[i][2]); 
                if (skorLevel219 > maxSkorLevel219) {
                    maxSkorLevel219 = skorLevel219;
                    juaraTimLevel219 = dataTim19[i][0];
                }
            }
        }
        juaraTim19 = juaraTimLevel219; 
    
        System.out.println("\n=== JUARA PERTANDINGAN ===");
        System.out.println("Nama Tim : " + juaraTim19);
        System.out.println("Total Skor : " + maxSkor19);
    }    
}