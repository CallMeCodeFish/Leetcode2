package newquestion.day40;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 6/21/20 5:51 PM
 */

/**
 * leetcode 658: Find k closest elements
 */
public class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k;

        while (start < end) {
            int mid = (start + end) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                start = mid + 1;
            else
                end = mid;
        }

        List<Integer> results = new ArrayList<>();
        for (int i = start; i < start + k; i++) {
            results.add(arr[i]);
        }
        return results;

    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        int j = binSearch(arr, x);

        int i = j - 1;

        int count = 0;
        while (i >= 0 && j < arr.length && count < k) {
            int num1 = x - arr[i];
            int num2 = arr[j] - x;
            if (num1 <= num2) {
                res.add(arr[i]);
                i--;
            } else {
                res.add(arr[j]);
                j++;
            }
            count++;
        }

        if (count < k) {
            if (i >= 0) {
                while (count < k) {
                    res.add(arr[i--]);
                    count++;
                }
            } else {
                while (count < k) {
                    res.add(arr[j++]);
                    count++;
                }
            }
        }

        res.sort((a, b) -> a - b);

        return res;
    }

    private int binSearch(int[] nums, int target) {
        int l = 0, h = nums.length;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (target <= nums[m]) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
