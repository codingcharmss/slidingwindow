import java.util.*;

public class Main {
    /**
    Given a string, find the length of the longest substring in it with no more than K distinct characters.
    
    Example 1:
    Input: String="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters is "araa".
    
    Example 2:
    Input: String="araaci", K=1
    Output: 2
    Explanation: The longest substring with no more than '1' distinct characters is "aa".

    Example 3:
    Input: String="cbbebi", K=3
    Output: 5
    Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
     */

    private static int getLongestSubstrKDistChars(String s, int k) {
      int n = s.length();
      int start = 0, maxLen = 0;
      HashMap<Character, Integer> freq = new HashMap<>();
      for (int end = 0; end < n; end++) {
        Character c = s.charAt(end);
        freq.put(c, freq.getOrDefault(c, 0) + 1);

        while (freq.size() > k) {
          c = s.charAt(start);
          if (freq.get(c) > 1) {
            freq.put(c, freq.get(c) - 1);
          } else {
            freq.remove(c);
          }

          start++;
        }

        maxLen = Math.max(maxLen, end - start + 1);
      }

      return maxLen;
    }

  // TC: O(n) | SC: O(n)

    public static void main(String[] args) {
      System.out.println(getLongestSubstrKDistChars("araaci", 2));
      System.out.println(getLongestSubstrKDistChars("araaci", 1));
      System.out.println(getLongestSubstrKDistChars("cbbebi", 3));
    }
}
