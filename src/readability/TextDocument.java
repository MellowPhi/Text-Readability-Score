package readability;

import java.util.List;

public class TextDocument extends Document
{
    public TextDocument(String text) {
        super(text);
    }

    @Override
    public int getNumSentences() {
        List<String> tokens = getTokens("[^.!?]+");
        return tokens.size();
    }

    @Override
    public int getNumWords() {
        List<String> tokens = getTokens("[^ .,!?]+");
        return tokens.size();
    }

    @Override
    public int getNumChars() {
        List<String> tokens = getTokens("\\S");
        return tokens.size();
    }

    @Override
    public int getNumSyllables() {
        return 0;
    }

    public String readabilityLevel() {
        int numSentences = this.getNumSentences();
        int numWords = this.getNumWords();
        int numChars = this.getNumChars();
        System.out.println(numWords);
        System.out.println(numSentences);
        System.out.println(numChars);
        double avgWords = numWords / (double) numSentences;
        if (avgWords <= 10) {
            return "EASY";
        } else {
            return "HARD";
        }
    }
}
