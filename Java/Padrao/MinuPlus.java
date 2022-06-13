import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinuPlus {
    static int sizeArray;
    static int inputNumber;
    static int rateZero = 0;
    static int ratePositive = 0;
    static int rateNegative = 0;

    public static void plusMinus(List<Integer> data){
        for (int index = 0; index < data.size(); index++) {
            if (data.get(index) > 0){
                ratePositive++;
            } else if (data.get(index) < 0) {
                rateNegative++;
            }else {
                rateZero++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dataOfInt = new ArrayList<>();

        sizeArray = Integer.parseInt(reader.readLine().trim());
        String[] dataOf = reader.readLine().replaceAll("\\s+$ ", "").split(" ");

        for (int index = 0; index < dataOf.length; index++) {
            dataOfInt.add(Integer.parseInt(dataOf[index]));
        }
        plusMinus(dataOfInt);
        System.out.printf("%.6f %.6f %.6f",
                (float)ratePositive/sizeArray,
                (float)rateNegative/sizeArray,
                (float)rateZero/sizeArray);
    }
}
