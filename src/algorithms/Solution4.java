package algorithms;

/**
 * Created by zsx on 17-2-23.
 * median of two sorted arrays
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int flag = (nums1.length + nums2.length) / 2;
        int i = 0, j = 0;
        int count = 0;
        int value;
        int[] newarr = new int[flag * 2 + 1];
        //将新的array排序好
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                newarr[count++] = nums2[j++];
                continue;
            } else if (j >= nums2.length) {
                newarr[count++] = nums1[i++];
                continue;
            } else if (nums1[i] > nums2[j])
                newarr[count++] = nums2[j++];
            else
                newarr[count++] = nums1[i++];
        }
        if (count % 2 != 0)
            return newarr[count / 2];
        return (newarr[count / 2] * 1.0 + newarr[count / 2 - 1] * 1.0) / 2;
    }

    public static void main(String[] args) {
        Solution4 s4 = new Solution4();
        int[] nums1 = {3, 5, 6, 7};
        int[] nums2 = {1, 2, 4, 8, 9};
        System.out.println(s4.findMedianSortedArrays(nums1, nums2));
    }

}
