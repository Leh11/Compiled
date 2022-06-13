import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsultaString {
    public static int matchString(String query, String text){
        int M = query.length();
        int N = text.length();
        int indexT;
        int indexQ = 0;
        for (indexT = 0; indexT <= N - M; indexT++) {
            for (indexQ = 0; indexQ < M; indexQ++) {
                if (query.charAt(indexQ) != text.charAt(indexT + indexQ)){
                    break;
                }
            }
            if (indexQ == M){
                System.out.println("Existe");
                return indexT;
            }
        }
        System.out.println("Não Existe");
        return indexQ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //int n = Integer.parseInt(reader.readLine());

        String dataOf = reader.readLine();
        String query = reader.readLine();

        System.out.println(matchString(query, dataOf));
    }
}
