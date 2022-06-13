import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RepeatValue {

    public static void lonelyInteger(List<Integer> integerList){
        int aux = 0;
        for (Integer l: integerList) {
            aux ^= l;
            System.out.printf("%d ", aux);
        }
        System.out.printf("%d%n", aux);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(reader.readLine());
        List<Integer> lonInteger = Stream.of(reader.readLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        lonelyInteger(lonInteger);
    }
}
