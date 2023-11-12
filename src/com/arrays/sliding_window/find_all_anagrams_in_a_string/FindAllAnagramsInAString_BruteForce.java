import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        int pLength = p.length();

        for (int i = 0; i <= s.length() - pLength; i++) {
            String substring = s.substring(i, i + pLength);
            if (isAnagram(substring, p)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26]; // Assuming only lowercase English letters

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println("Indices of Anagrams: " + result);
    }
}
