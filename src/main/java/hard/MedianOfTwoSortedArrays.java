package hard;

/**
 * @author Heng Yu
 * @date 2/29/20 8:56 PM
 */

/**
 * leetcode 4: Median of Two Sorted Arrays
 */

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{1, 1};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        boolean oddLength = true;
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 0)
            oddLength = false;

        int left1 = 0;
        int right1 = nums1.length;
        int left2 = 0;
        int right2 = nums2.length;
        while (left1 < right1 || left2 < right2) {
            int mid = left1 + (right1 - left1) / 2;
            boolean inNums1 = true;
            if (left1 == right1) {
                inNums1 = false;
                mid = left2 + (right2 - left2) / 2;
            }
            int count = mid;
            if (inNums1) {
                int l = left2;
                int r = right2;
                int target = nums1[mid];
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (target <= nums2[m]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += l;
                if (oddLength) {
                    if (count == (totalLen - 1) / 2) {
                        res = nums1[mid];
                        break;
                    } else if (count < (totalLen - 1) / 2) {
                        left1 = mid + 1;
                    } else {
                        right1 = mid;
                    }
                } else {
                    if (count == totalLen / 2 - 1) {
                        res += nums1[mid];
                        if (mid + 1 == nums1.length) {
                            res += nums2[l];
                        } else if (l == nums2.length) {
                            res += nums1[mid + 1];
                        } else {
                            res += Math.min(nums1[mid + 1], nums2[l]);
                        }
                        res /= 2.0;
                        break;
                    } else if (count == totalLen / 2) {
                        res += nums1[mid];
                        if (mid == 0) {
                            res += nums2[l - 1];
                        } else if (l == 0) {
                            res += nums1[mid - 1];
                        } else {
                            res += Math.max(nums1[mid - 1], nums2[l - 1]);
                        }
                        res /= 2.0;
                        break;
                    } else if (count < totalLen / 2 - 1) {
                        left1 = mid + 1;
                    } else {
                        right1 = mid;
                    }
                }
            } else {
                int l = 0;
                int r = nums1.length;
                while (l < r) {
                    int target = nums2[mid];
                    int m = l + (r - l) / 2;
                    if (target < nums1[m]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += l;
                if (oddLength) {
                    if (count == (totalLen - 1) / 2) {
                        res = nums2[mid];
                        break;
                    } else if (count < (totalLen - 1) / 2) {
                        left2 = mid + 1;
                    } else {
                        right2 = mid;
                    }
                } else {
                    if (count == totalLen / 2 - 1) {
                        res += nums2[mid];
                        res += nums2[mid + 1];
                        res /= 2.0;
                        break;
                    } else if (count == totalLen / 2) {
                        res += nums2[mid];
                        res += nums2[mid - 1];
                        res /= 2.0;
                        break;
                    } else if (count < totalLen / 2) {
                        left2 = mid + 1;
                    } else {
                        right2 = mid;
                    }
                }
            }
        }
        return res;
    }
}
