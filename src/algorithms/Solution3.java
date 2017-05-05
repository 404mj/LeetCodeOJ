package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zsx on 17-2-23.
 * the length of longest substring without repeating characters
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {

        Set<String> container = new HashSet<String>(20);
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); ++i) {
            String nowS = s.substring(i, i + 1);
            if (container.add(nowS)) {
                if (container.size() > max)
                    max = container.size();
            } else {
                container.clear();
//                container.add(nowS);
                i = index;
                index++;
            }
        }
        return max;
    }

    /*
    官方解答， Sliding Window
    A sliding window is an abstract concept commonly used in array/string problems.
    A window is a range of elements in the array/string which usually defined by the
    start and end indices.

    Back to our problem. We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially).
     Then we slide the index jj to the right. If it is not in the HashSet,
     we slide jj further. Doing so until s[j] is already in the HashSet.
      At this point, we found the maximum size of substrings without
       duplicate characters start with index ii. If we do this for all ii,
       we get our answer.
     */
    private int bestSolution(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));//set.remove(s.charAt(i));i++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = new String("aaaa");
        Solution3 s3 = new Solution3();
        System.out.println(s3.lengthOfLongestSubstring(s));
    }

}
