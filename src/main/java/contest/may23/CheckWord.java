package contest.may23;

/**
 * @author Heng Yu
 * @date 5/23/20 10:30 PM
 */


public class CheckWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int res = -1;

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word.startsWith(searchWord)) {
                res = i + 1;
                break;
            }
        }

        return res;
    }
}
