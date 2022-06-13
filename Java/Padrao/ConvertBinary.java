import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertBinary {
    private static void convertBinary(String binary) {
        long sum = 0;
        int aux;

        for (int index = binary.length() - 1 ; index >= 0 ; index--) {
            aux = Integer.parseInt(String.valueOf(binary.charAt(index)));

            if (aux == 0){
                sum += Math.round(Math.pow(2, index + 1));
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String binary;
        int n = Integer.parseInt(reader.readLine());

        for (int index = 0; index < n; index++) {
            binary = reader.readLine();
            convertBinary(binary);
        }
    }

}
