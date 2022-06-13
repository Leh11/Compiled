import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinMaxSum {

    public static void minMax(List<Integer> arrayOfInt){
        long min = 0;
        long max = 0;
        long small = arrayOfInt.get(0);
        long biggest = small;
        long sum = 0;

        for (int index = 0; index < arrayOfInt.size() ; index++) {
            if (arrayOfInt.get(index) < small){
                small = arrayOfInt.get(index);
            }
            if (arrayOfInt.get(index) > biggest) {
                biggest = arrayOfInt.get(index);
            }
            sum += arrayOfInt.get(index);

        }
        max = sum - small;
        min = sum - biggest;

        System.out.printf("%d %d", max, min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrayOfInt = new ArrayList<>();

        String[] dataOf = reader.readLine().replaceAll("\\s+$ ", "").split(" ");
        for (int index = 0; index < dataOf.length; index++) {
            arrayOfInt.add(Integer.parseInt(dataOf[index]));
        }
        minMax(arrayOfInt);
    }
}
