import java.util.Scanner;

public class Criptografia {

    public static char[] shift3(String inputString) {
        char auxString[] = new char[inputString.length()];
        for (int index = 0; index < inputString.length(); index++) {

            if (Character.isAlphabetic(inputString.charAt(index))) {
                auxString[index] = (char) (inputString.charAt(index) + 3);
            } else{
                auxString[index] = inputString.charAt(index);
            }
        }

        return auxString;
    }

    public static char[] reverse(char[] inputChar) {
        char[] auxString = new char[inputChar.length];

        for (int index = auxString.length - 1, i = 0; index >= 0; index--, i++) {
            auxString[i] = inputChar[index];
        }

        return auxString;
    }

    public static String midShift(char[] inputChar){
        char[] auxString = new char[inputChar.length];
        int mid = inputChar.length / 2;

        for (int index = 0; index < mid; index++) {
            auxString[index] = inputChar[index];
        }
        for (int index = mid; index < auxString.length; index++) {
            auxString[index] = (char) (inputChar[index] - 1);
        }
        return String.valueOf(auxString);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lineNumbers;
        int lenWords;
        String inputString;

        lineNumbers = scanner.nextInt();
        if (lineNumbers > Math.pow(10, 4)) {
            return;
        }
        scanner.nextLine();
        System.out.println(lineNumbers);
        for (int i = 0; i < lineNumbers; i++) {

            inputString = scanner.nextLine();

            char aux0[] = shift3(inputString);
            char aux1[] = reverse(aux0);
            System.out.printf("%s%n", midShift(aux1));
            
        }
        scanner.close();
    }
}
