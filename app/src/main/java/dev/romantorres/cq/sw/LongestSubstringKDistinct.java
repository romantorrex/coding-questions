package dev.romantorres.cq.sw;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class LongestSubstringKDistinct {


    /**
     * Finds the length of the longest substring, in the given {@oce string}, with no more than {@code k} distinct characters.
     *
     * @return The lengh
     */
    public static int findLongestLength(String string, int k) {
        int  i = 0, j = 0, maxLongest = 0;
        Map<Character, Integer> charsCount = new HashMap<>();
        while (j < string.length()) {
            char rightChar = string.charAt(j);
            if (charsCount.containsKey(rightChar)) {
                charsCount.put(rightChar, charsCount.get(rightChar) + 1);
                j++;
                maxLongest = Math.max(maxLongest, j - i);
                continue;
            } else if (charsCount.size() + 1 <= k) {
                charsCount.put(rightChar, 1);
                j++;
                maxLongest = Math.max(maxLongest, j - i);
                continue;
            }

            char leftChar = string.charAt(i);
            charsCount.put(leftChar, charsCount.get(leftChar) - 1);
            if (charsCount.get(leftChar) == 0) {
                charsCount.remove(leftChar);
            }
            i++;
            maxLongest = Math.max(maxLongest, j - i);
        }
        return maxLongest;
    }
}
