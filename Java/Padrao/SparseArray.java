import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class SparseArray {

    public static void matchingString(Map<String, Integer> inputString, List<String> queries){
        int[] result = new int[queries.size()];


        for (int index = 0; index < queries.size(); index++) {
            if (inputString.containsKey(queries.get(index))){
                result[index] = inputString.get(queries.get(index));
            }
        }

        IntStream.of(result).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> queries = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String string;

        int sizeString = Integer.parseInt(reader.readLine());

        for (int index = 0; index < sizeString; index++) {
            string = reader.readLine();
            if (map.containsKey(string)){
                map.put(string, map.get(string) + 1);
            }else {
                map.put(string, 1);
            }
        }

        int sizeQueries = Integer.parseInt(reader.readLine());
        for (int index = 0; index < sizeQueries; index++) {
            queries.add(reader.readLine());
        }
        matchingString(map, queries);
        reader.close();
    }
}
