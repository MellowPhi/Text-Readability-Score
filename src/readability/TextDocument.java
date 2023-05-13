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
        // List<String> tokens = getTokens("[^ .,!?]+");
        List<String> tokens = getTokens("\\b\\d+,\\d+\\b|\\b\\w+\\b");
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

    public void readabilityLevel() {
        int numSentences = this.getNumSentences();
        int numWords = this.getNumWords();
        int numChars = this.getNumChars();
        System.out.println("Words: " + numWords);
        System.out.println("Sentences: " + numSentences);
        System.out.println("Characters: " + numChars);
        System.out.println("The score is: " + String.format("%.2f", this.automatedReadabilityScore()));
        System.out.println("This text should be understood by " + this.readingLevel((int) Math.ceil(this.automatedReadabilityScore())) +" year-olds.");
        double avgWords = numWords / (double) numSentences;
//        if (avgWords <= 10) {
//            return "EASY";
//        } else {
//            return "HARD";
//        }
    }
}
