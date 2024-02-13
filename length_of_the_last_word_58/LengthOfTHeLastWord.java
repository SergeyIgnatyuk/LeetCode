package length_of_the_last_word_58;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfTHeLastWord {
    public static void main(String[] args) {
        System.out.println(defineLengthOfTHeLastWord("Hello "));
    }

    private static int defineLengthOfTHeLastWord(String s) {
        int index = s.trim().lastIndexOf("\s") + 1;
        String lastWord = "";
        if (index > 0 && index < s.trim().length()) {
            lastWord = s.trim().substring(s.trim().lastIndexOf("\s") + 1);
        } else {
            lastWord = s.trim();
        }
        return lastWord.length();
    }
}
