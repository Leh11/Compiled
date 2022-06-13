import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mediana {

    public static void merge(Integer[] dados, Integer inicio, Integer medio, Integer fim) {
        Integer[] dir = new Integer[fim - medio];
        Integer[] esq = new Integer[medio - inicio + 1];


        int sizeEsq = esq.length;
        int sizeDir = dir.length;

        for (int i = 0; i < sizeEsq; i++) {
            esq[i] = dados[inicio + i];
        }
        for (int j = 0; j < sizeDir; j++){
            dir[j] = dados[medio + 1 + j];
        }

        int i = 0;
        int j = 0;
        Integer k = inicio;
        while ((i < sizeEsq)  && (j < sizeDir)) {
            if (esq[i] <= dir[j]) {
                dados[k] = esq[i];
                i++;
            }else {
                dados[k] = dir[j];
                j++;
            }
            k++;
        }

        while (i < sizeEsq) {
            dados[k] = esq[i];
            i++;
            k++;
        }
        while (j < sizeDir) {
            dados[k] = dir[j];
            j++;
            k++;
        }
    }

    public static void sort(Integer[] dados, Integer inicio, Integer fim) {
        if (inicio < fim) {
            Integer medio = inicio + (fim - inicio) / 2;
            sort(dados, inicio, medio);
            sort(dados, medio + 1, fim);

            merge(dados, inicio, medio, fim);
        }
    }

    public static void median(Integer[] arrayOfInt){
        int mediana;
        int size = arrayOfInt.length;
        int index = (size - 1) / 2;
        sort(arrayOfInt, 0, size - 1);

        if (size % 2 == 0) {
            mediana = ((arrayOfInt[index] + arrayOfInt[index + 1]) / 2);
        } else {
            mediana = arrayOfInt[index];
        }

        System.out.println(mediana);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Integer[] arrayOfInt = new Integer[n];

        String[] dataOf = reader.readLine().replaceAll("\\s+$ ", "").split(" ");
        for (int index = 0; index < dataOf.length; index++) {
            arrayOfInt[index] = (Integer.parseInt(dataOf[index]));

            //System.out.println(arrayOfInt[index]);
        }

        median(arrayOfInt);
    }
}
