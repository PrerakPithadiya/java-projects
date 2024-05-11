package Tisha_Hirpara;

import java.util.Arrays;
import java.util.Scanner;

class TicTacToc {
    static int r1 = 3;
    static int r2 = 3;
    static int r3 = 3;
    static int c1 = 3;
    static int c2 = 3;
    static int c3 = 3;
    static int d1 = 3;
    static int d2 = 3;
    static String Green = "\u001b[32m";
    static String Reset = "\u001b[32;1m";
    static String Red = "\u001b[31;1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] mat = new char[3][3];
        insertSpaces(mat);
        do {
            System.out.print("Player 1 turn (X): ");
            int xtern = sc.nextInt();
            inputData(mat, xtern, 'X');
            System.out.println();
            printMatrix(mat);
            System.out.println();
            if (isComplete(mat, 'X')) {
                System.out.println(Green + "\nPlayer 1 is winner..!" + Reset);
                break;
            }
            if (allDataContains()) {
                System.out.println(Red + "\nNeither Player 1 nor Player 2 is Winner!" + Reset);
                break;
            }

            System.out.print("Player 2 turn (O): ");
            int ytern = sc.nextInt();
            inputData(mat, ytern, 'O');
            System.out.println();
            printMatrix(mat);
            System.out.println();
            if (isComplete(mat, 'O')) {
                System.out.println(Green + "\nPlayer 2 is winner..!" + Reset);
                break;
            }
            if (allDataContains()) {
                System.out.println(Red + "\nNeither Player 1 nor Player 2 is Winner!" + Reset);
                break;
            }

        } while (true);
    }

    public static boolean allDataContains() {
        return (r1 == 0 && r2 == 0 && r3 == 0 && c1 == 0 && c2 == 0 && c3 == 0 && d1 == 0 && d2 == 0);
    }

    public static void inputData(char[][] mat, int pos, char value) {
        int r, c;
        if (pos == 1) {
            r = 0;
            c = 0;
            r1--;
            c1--;
            d1--;
        } else if (pos == 2) {
            r = 0;
            c = 1;
            r1--;
            c2--;
        } else if (pos == 3) {
            r = 0;
            c = 2;
            r1--;
            c3--;
            d2--;
        } else if (pos == 4) {
            r = 1;
            c = 0;
            r2--;
            c1--;
        } else if (pos == 5) {
            r = 1;
            c = 1;
            r2--;
            c2--;
            d1--;
            d2--;
        } else if (pos == 6) {
            r = 1;
            c = 2;
            r2--;
            c3--;
        } else if (pos == 7) {
            r = 2;
            c = 0;
            r3--;
            c1--;
            d2--;
        } else if (pos == 8) {
            r = 2;
            c = 1;
            r3--;
            c2--;
        } else if (pos == 9) {
            r = 2;
            c = 2;
            r3--;
            c3--;
            d1--;
        } else {
            System.out.println("You have entered invalid position!!!");
            return;
        }
        if (mat[r][c] != ' ') {
            System.out.println("In the given position, data already exist...");
            return;
        }
        mat[r][c] = value;
    }

    public static boolean isComplete(char[][] m, char v) {
        return (m[0][0] == v && m[0][1] == v && m[0][2] == v) || (m[1][0] == v && m[1][1] == v && m[1][2] == v) || (m[2][0] == v && m[2][1] == v && m[2][2] == v) || (m[0][0] == v && m[1][0] == v && m[2][0] == v) || (m[0][1] == v && m[1][1] == v && m[2][1] == v) || (m[0][2] == v && m[1][2] == v && m[2][2] == v) || (m[0][0] == v && m[1][1] == v && m[2][2] == v) || (m[0][2] == v && m[1][1] == v && m[2][0] == v);
    }

    public static void printMatrix(char[][] mat) {
        for (char[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void insertSpaces(char[][] mat) {
        int r = mat.length, c = mat[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = ' ';
            }
        }
    }
}
