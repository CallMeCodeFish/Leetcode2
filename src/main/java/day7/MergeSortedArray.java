package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 10:54 PM
 */

import java.util.Arrays;

/**
 * leetcode 88: Merge Sorted Array
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //edge case
        if (n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; ++i) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int[] copy = new int[m];
        for (int i = 0; i < m; ++i) {
            copy[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (copy[i] <= nums2[j]) {
                nums1[k++] = copy[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = copy[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}
