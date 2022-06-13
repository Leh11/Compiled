import java.security.SecureRandom;

public class RoleDice {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();

        int val[] = {2, 3, 5, 1, 2, 5, 2, 6, 4, 2, 1, 2, 1, 3, 5};
        int[] frequency = new int[15]; 
        for (int roll = 0; roll < 1; roll++) {
            ++frequency[val[roll]];
        }

        System.out.printf("%s%10s%n", "Face", "Frequency");
        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d%n", face, frequency[face]);
        }

    }
}
