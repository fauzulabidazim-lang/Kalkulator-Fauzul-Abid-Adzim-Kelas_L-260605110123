import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            System.out.println();

            switch (pilihan) {
                case 1:
                    menuFaktorial(input);
                    break;
                case 2:
                    menuPerpangkatan(input);
                    break;
                case 3:
                    menuPerkalianMatriks(input);
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }

        input.close();
    }

    static void tampilkanMenu() {
        System.out.println("=======================================");
        System.out.println("  KALKULATOR OPERASI MATEMATIKA & MATRIKS");
        System.out.println("=======================================");
        System.out.println("1. Hitung Faktorial (n!)");
        System.out.println("2. Hitung Perpangkatan (a^b)");
        System.out.println("3. Perkalian Matriks 2 x 2");
        System.out.println("0. Keluar");
        System.out.println("---------------------------------------");
    }

        static void menuFaktorial(Scanner input) {
        System.out.println("--- Hitung Faktorial (n!) ---");
        System.out.print("Masukkan bilangan bulat n: ");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif.");
        } else if (n > 20) {
            System.out.println("Nilai n terlalu besar. Maksimal n = 20 agar tidak melebihi batas tipe long.");
        } else {
            long hasil = faktorial(n);
            System.out.println(n + "! = " + hasil);
        }
    }

    
    static long faktorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }

    
    static void menuPerpangkatan(Scanner input) {
        System.out.println("--- Hitung Perpangkatan (a^b) ---");
        System.out.print("Masukkan bilangan pokok (a): ");
        double a = input.nextDouble();
        System.out.print("Masukkan bilangan pangkat (b, bilangan bulat >= 0): ");
        int b = input.nextInt();

        if (b < 0) {
            System.out.println("Pangkat negatif tidak didukung pada program ini.");
        } else {
            double hasil = pangkat(a, b);
            System.out.println(a + " ^ " + b + " = " + hasil);
        }
    }

    
    static double pangkat(double a, int b) {
        double hasil = 1;
        for (int i = 1; i <= b; i++) {
            hasil *= a;
        }
        return hasil;
    }

    
    static void menuPerkalianMatriks(Scanner input) {
        System.out.println("--- Perkalian Matriks 2 x 2 ---");

        int[][] matriksA = new int[2][2];
        int[][] matriksB = new int[2][2];

        System.out.println("Masukkan elemen Matriks A:");
        isiMatriks(input, matriksA, "A");

        System.out.println("Masukkan elemen Matriks B:");
        isiMatriks(input, matriksB, "B");

        int[][] hasil = kalikanMatriks(matriksA, matriksB);

        System.out.println("\nMatriks A:");
        tampilkanMatriks(matriksA);
        System.out.println("Matriks B:");
        tampilkanMatriks(matriksB);
        System.out.println("Hasil A x B:");
        tampilkanMatriks(hasil);
    }

    static void isiMatriks(Scanner input, int[][] matriks, String nama) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(nama + "[" + (i + 1) + "][" + (j + 1) + "] = ");
                matriks[i][j] = input.nextInt();
            }
        }
    }

    static int[][] kalikanMatriks(int[][] a, int[][] b) {
        int[][] hasil = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    hasil[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return hasil;
    }

    static void tampilkanMatriks(int[][] matriks) {
        for (int i = 0; i < 2; i++) {
            System.out.print("| ");
            for (int j = 0; j < 2; j++) {
                System.out.printf("%6d ", matriks[i][j]);
            }
            System.out.println("|");
        }
        System.out.println();
    }
}