import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FloodFill {

    static void printMat(char mat[][], int r, int c) throws IOException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

    }

    static void floodFill(char mat[][], int i, int j, char ch, char color) throws InterruptedException, IOException {

        // System.out.println(i + " " + j + " " + ch + " " + color);
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return;
        if (mat[i][j] != ch)
            return;

        mat[i][j] = color;
        printMat(mat, mat.length, mat[0].length);
        Thread.sleep(100);

        floodFill(mat, i - 1, j, ch, color);
        floodFill(mat, i + 1, j, ch, color);
        floodFill(mat, i, j - 1, ch, color);
        floodFill(mat, i, j + 1, ch, color);

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, NumberFormatException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        String rc[] = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]), c = Integer.parseInt(rc[1]);
        char mat[][] = new char[r][c];

        for (int i = 0; i < r; i++) {
            String inp = br.readLine();
            for (int j = 0; j < c; j++) {
                mat[i][j] = inp.charAt(j);
            }
        }

        // printMat(mat, r, c);
        System.out.println("Enter i j space separated");
        String ij = br.readLine();
        System.out.println("Enter char to replace and char to be replaced with ");
        String charInp = br.readLine();
        floodFill(mat, Integer.parseInt(String.valueOf(ij.charAt(0))), Integer.parseInt(String.valueOf(ij.charAt(2))),
                charInp.charAt(0), charInp.charAt(2));
        printMat(mat, r, c);

    }

}
