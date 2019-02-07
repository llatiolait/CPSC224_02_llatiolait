import javax.swing.JOptionPane;

import com.sun.tools.javac.util.StringUtils;

import java.lang.String;
import java.lang.Integer;

public class HangManMain {

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        /*
         * asks user what they want to do: 1. random word 2. user selected word 3. exit
         * 
         * call setWord or setRandWord and sets output
         * 
         * call playGame function
         */
        int choice;
        String input;
        input = JOptionPane
                .showInputDialog("What do you want to do:" + "\n" + "1. Play game from a randomly chosen word in a list"
                        + "\n" + "2. Play game from a word entered by another user" + "\n" + "3. Exit");
        choice = Integer.parseInt(input);
        if (choice == 1) {
            Hangman currentGame = new Hangman();
            String word = setRandWord();
            setWord(word);
            setOutput(StringUtils.repeat("_", (word.length() + 1)));
            playGame();
        }
        if (choice == 2) {
            Hangman currentGame = new Hangman();
            String word = JOptionPane.showInputDialog("Player 2 enter a word:");
            setWord(word);
            setOutput(StringUtils.repeat("_", (word.length() + 1)));
            playGame();
        }
        if (choice == 3) {
            System.exit(0);
        } else {
            Menu();
        }
    }

    public static void playGame() {

        /*
         * runs game until 6 strikes or no _ in output
         * 
         * use function to check if input letter has been used yet, use function to
         * check if guessed letter is in the word, use function to update output if
         * guessed letter is in word
         */

    }

}