import java.security.SecureRandom;
import java.util.Random;

public class Revisao {
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    private static enum Status {
        CONTINUE, WON, LOST
    };

    public static int rollDice() {
        Random randomNumbers = new Random();
        int dice1 = 1 + randomNumbers.nextInt(6);
        int dice2 = 1 + randomNumbers.nextInt(6);
        System.out.printf("Dado 1: %d\tDado 2: %d\tA soma: %d%n", dice1, dice2, dice1 + dice2);
        return dice1 + dice2;
    }

    public static void main(String[] args) {
        int myPoint = 0;
        Status gameStatus;
        int sumOfDice = rollDice();

        switch (sumOfDice) {

            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;

            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
                
            default:
                myPoint = sumOfDice;
                gameStatus = Status.CONTINUE;
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();

            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
                myPoint = sumOfDice;
            } else if (sumOfDice == SEVEN) {
                gameStatus = Status.LOST;
            } 
        }

        if (gameStatus.equals(Status.WON)) {
            System.out.println("Você ganhou!");
        } else {
            System.out.println("Você perdeu!");
        }
    }
}