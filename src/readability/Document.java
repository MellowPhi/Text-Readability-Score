package readability;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Document {
    private String text;

    /**
     * Create a new document from a given text
     * @param text The text content of the document
     */
    protected Document(String text) {
        this.text = text;
    }

    /**
     * Returns a tokens of a text document that match the regex pattern
     * @param pattern The regex specifying the desired token pattern
     * @return List of tokens from the documents text that match the regex pattern
     */

    protected List<String> getTokens(String pattern) {
        ArrayList<String> tokens = new ArrayList<String>();
        Pattern tokenSplitter = Pattern.compile(pattern);
        Matcher m = tokenSplitter.matcher(text);

        while (m.find()) {
            tokens.add(m.group());
        }

        return tokens;
    }

    protected double automatedReadabilityScore() {
        return 4.71 * getNumChars() / getNumWords()
                + 0.5 * getNumWords() / getNumSentences() - 21.43;
    }

    protected String readingLevel(int readScore) {
        int ageLow = readScore + 4;
        int ageHigh;
        if (readScore < 14) {
            ageHigh = ageLow + 1;
        } else {
            ageHigh = ageLow + 4;
        }
        return new String(ageLow + "-" + ageHigh);
    }

    /**
     * @return Return the entire document text
     */
    public String getText() {
        return this.text;
    }

    public abstract int getNumSentences();

    public abstract int getNumWords();

    public abstract int getNumChars();

    public abstract int getNumSyllables();

}
