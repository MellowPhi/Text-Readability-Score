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
        // List<String> tokens = getTokens("\\b\\w+\\b");
        return tokens.size();
    }

    @Override
    public int getNumChars() {
        List<String> tokens = getTokens("\\S");
        return tokens.size();
    }

    @Override
    public int[] getNumSyllables() {
        List<String>tokenWords = getTokens("\\b\\d+,\\d+\\b|\\b\\w+\\b");
        int totalSyllables = 0;
        int totalPolySyllables = 0;
        for (String word : tokenWords) {
            int count = countSyllables(word);
            totalSyllables += count;
            if (count > 2) {
                totalPolySyllables += 1;
            }
//			System.out.println("Total vowels found so far " + totalSyllables);
        }
        return new int[] {totalSyllables, totalPolySyllables};

    }

    public void readabilityLevel() {
        int numSentences = this.getNumSentences();
        int numWords = this.getNumWords();
        int numChars = this.getNumChars();
        int[] totalSyllables = this.getNumSyllables();
        int numSyllables = totalSyllables[0];
        int numPolySyllables = totalSyllables[1];
        System.out.println("Words: " + numWords);
        System.out.println("Sentences: " + numSentences);
        System.out.println("Characters: " + numChars);
        System.out.println("Syllables: " + numSyllables);
        System.out.println("Polysyllables: " + numPolySyllables);
        System.out.println("Automated Readability Index: " + String.format("%.2f", this.automatedReadabilityScore()));
        System.out.println("Flesch–Kincaid readability tests: " + String.format("%.2f", this.fleshScore()));
        System.out.println("Simple Measure of Gobbledygook: " + String.format("%.2f", this.smogScore()));
        // System.out.println("Simple Measure of Gobbledygook: " + this.smogScore());
        System.out.println("This text should be understood by " + this.readingLevel((int) Math.ceil(this.automatedReadabilityScore())) +" year-olds.");
        double avgWords = numWords / (double) numSentences;
//        if (avgWords <= 10) {
//            return "EASY";
//        } else {
//            return "HARD";
//        }
    }
}
