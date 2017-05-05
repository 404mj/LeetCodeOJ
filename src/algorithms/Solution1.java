package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zsx on 16-12-30.
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int i, in = 0;
        int[] ansr = new int[2];
        for (i = 0; i < nums.length; ++i) {
            int value = target - nums[i];
            int index;
            if ((index = findValue(nums, value)) > -1) {
                //找到符合条件的
                if (i > index) {
                    ansr[0] = index;
                    ansr[1] = i;
                } else if (i == index)
                    continue;
                else {
                    ansr[0] = i;
                    ansr[1] = index;
                }

            }
        }
        return ansr;
    }


    /**
     * find a value need,fail to return -1 or return index
     */
    private int findValue(int[] arr, int value) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }


    /**
     * BEST SOLUTION
     */
    public int[] twoSumBest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        /*
        思路是构造一个map，用值作为key，序号为value。经验就是单纯的遍历要加上对数据的整理以使操作更容易。
         */
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] nums = {3, 2, 4};
        s1.findValue(nums,23);
        int[] answer = s1.twoSum(nums, 28);
        for (int i : answer) {
            System.out.println("args = [" + i + "]");
        }
    }
}

