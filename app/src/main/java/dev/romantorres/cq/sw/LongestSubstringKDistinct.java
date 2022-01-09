package dev.romantorres.cq.sw;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct
 * characters.
 */
public class LongestSubstringKDistinct {

    /**
     * Finds the length of the longest substring, in the given {@code string}, with no more than
     * {@code k} distinct characters.
     */
    public static int findLongestLength(String string, int k) {
        int i = 0, longestLength = 0;
        Map<Character, Integer> charOccurrences = new HashMap<>();
        for (int j = 0; j < string.length(); j++) {
            char rightChar = string.charAt(j);
            charOccurrences.merge(rightChar, 1, (a, b) -> a + b);

            while (charOccurrences.size() > k) {
                char leftChar = string.charAt(i++);
                charOccurrences.put(leftChar, charOccurrences.get(leftChar) - 1);
                if (charOccurrences.get(leftChar) == 0) {
                    charOccurrences.remove(leftChar);
                }
            }
            longestLength = Math.max(longestLength, j - i + 1);
        }

        return longestLength;
    }
}
