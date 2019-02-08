public class Hangman {
    private String word;
    private String output;
    private List lettersGuessed;

    public void setWord(String word) {
        word = inputName;
    }

    public void setOutput(String outputStr) {
        output = outputStr;
    }

    public void addLettersGuessed(char letter) {
        lettersGuessed.add(letter);
    }

    public String getWord() {
        return word;
    }

    public String getOutput() {
        return output;
    }

    public List getLettersGuessed() {
        return lettersGuessed;
    }

}