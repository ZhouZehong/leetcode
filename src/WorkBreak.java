import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 *
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class WorkBreak {

    /**
     * f(i) = f(j) & f(j+1,i)
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return true;
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i)) && flags[j]) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }


}
