import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void merge(Integer[] arrayOfInt, Integer begin, Integer mid, Integer end) {
        Integer[] dir = new Integer[end - mid];
        Integer[] esq = new Integer[mid - begin + 1];


        int sizeEsq = esq.length;
        int sizeDir = dir.length;

        for (int i = 0; i < sizeEsq; i++) {
            esq[i] = arrayOfInt[begin + i];
        }
        for (int j = 0; j < sizeDir; j++){
            dir[j] = arrayOfInt[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        Integer k = begin;
        while ((i < sizeEsq)  && (j < sizeDir)) {
            if (esq[i] <= dir[j]) {
                arrayOfInt[k] = esq[i];
                i++;
            }else {
                arrayOfInt[k] = dir[j];
                j++;
            }
            k++;
        }

        while (i < sizeEsq) {
            arrayOfInt[k] = esq[i];
            i++;
            k++;
        }
        while (j < sizeDir) {
            arrayOfInt[k] = dir[j];
            j++;
            k++;
        }
    }

    public static void sort(Integer[] arrayOfInt, Integer begin, Integer end) {
        if (begin < end) {
            Integer mid = begin + (end - begin) / 2;
            sort(arrayOfInt, begin, mid);
            sort(arrayOfInt, mid + 1, end);

            merge(arrayOfInt, begin, mid, end);
        }
    }
    public static void closetNumber(Integer[] arrayOfInt){
        int minimum = Integer.MAX_VALUE;
        int differ;

        int size = arrayOfInt.length;
        sort(arrayOfInt, 0, size - 1);

        for(int index = 0; index < arrayOfInt.length - 1; index++)
        {
            if((arrayOfInt[index] < 0 && arrayOfInt[index + 1] < 0) ||
                    (arrayOfInt[index] > 0 && arrayOfInt[index + 1] > 0)){
                differ = Math.abs(arrayOfInt[index] - arrayOfInt[index + 1]);
            } else{
                differ = Math.abs(arrayOfInt[index]) + Math.abs(arrayOfInt[index + 1]);
            }

            if(differ < minimum){
                minimum = differ;
                System.out.println("(" + arrayOfInt[index]+ "," +arrayOfInt[index + 1]+")");
            }else if(differ == minimum){
                System.out.println("("+arrayOfInt[index]+ "," +arrayOfInt[index + 1]+")");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Integer[] arrayOfInt = new Integer[n];
        String[] dataOf = reader.readLine().replaceAll("\\s+$ ", "").split(" ");

        for (int index = 0; index < dataOf.length; index++) {
            arrayOfInt[index] = (Integer.parseInt(dataOf[index]));
        }

        closetNumber(arrayOfInt);
    }
}
