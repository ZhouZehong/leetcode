import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreakIi {
    public ArrayList<String> wordBreak(String s, Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        int len = s.length();
        dfs(s, len, dict, res, strings);
        return res;
    }

    private void dfs(String s, int len, Set<String> dict,
                            ArrayList<String> res, ArrayList<String> strings){
        if (len <= 0){
            int size = strings.size() - 1;
            StringBuilder sb = new StringBuilder();
            for (int i = size; i >= 0; i--) {
                sb.append(strings.get(i));
                if (i != 0)
                    sb.append(" ");
            }
            res.add(sb.toString());
        }

        for (int i = len - 1; i >= 0; i--) {
            if (dict.contains(s.substring(i, len))){
                strings.add(s.substring(i, len));
                dfs(s, i, dict, res, strings);
                strings.remove(strings.size() - 1);
            }
        }
    }

}
