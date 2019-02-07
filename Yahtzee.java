
/*
Homework 1
1/31/19
Luc Latiolait
CPSC 224 02
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Yahtzee {
    public static void main(String[] args) {
        int DiceInPlay = 5;
        int[] hand = new int[DiceInPlay];
        String playAgain = "y";

        while (playAgain == "y") {
            String keep = "nnnnn";
            int turn = 1;
            while (turn < 4 && keep != "yyyyy") {
                for (int dieNumber = 0; dieNumber < DiceInPlay; dieNumber++) {
                    if (keep.charAt(dieNumber) != 'y')
                        hand[dieNumber] = rollDie();
                }
                System.out.println("Your roll was: ");
                for (int dieNumber = 0; dieNumber < DiceInPlay; dieNumber++) {
                    System.out.println(hand[dieNumber]);
                }
                if (turn < 3) {
                    System.out.println("enter dice to keep (y or n) ");
                    Scanner scnr = new Scanner(System.in);
                    keep = scnr.nextLine();
                }
                turn++;
            }
            Arrays.sort(hand);
            System.out.println("sorted hand: " + hand);

            for (int dieValue = 1; dieValue <= 6; dieValue++) {
                int currentCount = 0;
                for (int diePosition = 0; diePosition < 5; diePosition++) {
                    if (hand[diePosition] == dieValue)
                        currentCount++;
                }
                System.out.println("Score " + (dieValue * currentCount) + " on the " + dieValue + " line");
            }
            if (maxOfAKindFound(hand) >= 3) {
                System.out.println("Score " + totalAllDice(hand) + " on the " + "3 of a Kind line");
            } else
                System.out.println("Score 0 on the 3 of a Kind line");

            if (maxOfAKindFound(hand) >= 4) {
                System.out.println("Score " + totalAllDice(hand) + " on the " + "4 of a Kind line");
            } else
                System.out.println("Score 0 on the 4 of a Kind line");

            if (fullHouseFound(hand))
                System.out.println("Score 25 on full house line");
            else
                System.out.println("Score 0 on full house line");

            if (maxStraightFound(hand) >= 4)
                System.out.println("Score 30 on the small straight line");
            else
                System.out.println("Score 0 on the small straight line");

            if (maxStraightFound(hand) >= 5)
                System.out.println("Score 40 on the large straight line");
            else
                System.out.println("Score 0 on the large straight line");

            if (maxOfAKindFound(hand) >= 5)
                System.out.println("Score 50 on the Yahtzee line");
            else
                System.out.println("Score 0 on the Yahtzee line");

            System.out.println("Score " + totalAllDice(hand) + " on the chance line");
            System.out.println("Enter y to play again");
            Scanner scnr = new Scanner(System.in);
            playAgain = scnr.nextLine();
        }

    }

    public static int rollDie() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public static int maxOfAKindFound(int hand[]) {
        int maxCount = 0;
        int currentCount;
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }

    public static int totalAllDice(int hand[]) {
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++) {
            total += hand[diePosition];
        }
        return total;
    }

    public static int maxStraightFound(int hand[]) {
        int maxLength = 1;
        int curLength = 1;
        for (int counter = 0; counter < 4; counter++) {
            if (hand[counter] + 1 == hand[counter + 1]) {
                curLength++;
            } else if (hand[counter] + 1 < hand[counter + 1]) {
                curLength = 1;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }

    public static boolean fullHouseFound(int hand[]) {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;
        for (int dieValue = 1; dieValue <= 6; dieValue++) {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++) {
                if (hand[diePosition] == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K == true && found3K == true) {
            foundFH = true;
        }
        return foundFH;
    }
}
