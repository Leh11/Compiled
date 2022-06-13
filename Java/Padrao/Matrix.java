import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {
    public static void invertLineX(Integer arrayOfInt[][], int n){
        int cInverted = n / 2;
        int[] aux = new int[n];

        for (int index = n-1; index >= 0; index--) {
            aux[index] = arrayOfInt[index][cInverted];
        }
        System.out.println();

        for (int index = 0; index < n; index++) {
            System.out.printf("aux: %d, index: %d", aux[index], index);
            arrayOfInt[index][cInverted] = aux[index];
        }

//        for (int indexX = 0; indexX < n; indexX++) {
//            for (int indexY = 0; indexY < n; indexY++) {
//                System.out.print(arrayOfInt[indexX][indexY]);
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Integer[][] arrayOfInt = new Integer[n][n];
//
//        for (int indexX = 0; indexX < n; indexX++) {
//            for (int indexY = 0; indexY < n; indexY++) {
//                arrayOfInt[indexX][indexY] = Integer.parseInt(reader.readLine());
//            }
//        }

        invertLineX(arrayOfInt, n);


    }
}
