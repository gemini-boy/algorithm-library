package com.cloud.gemini.leetcode.hard;

/**
 * created by fufan on 2019-07-17 10:04
 **/
public class FindMediumSortedArrays {


    /**
     * 解法1：合并数组后取中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        if ( n == 0) {
            if ( m % 2 == 0) {
                return (nums1[m/2 -1] + nums1[m/2])/2.0;
            } else {
                return nums1[m/2];
            }
        }

        if ( m == 0) {
            if ( n % 2 == 0) {
                return (nums2[n/2 -1] + nums2[n/2])/2.0;
            } else {
                return nums2[n/2];
            }
        }
        int[] nums;
        nums = new int[m + n];

        // merge两个数组，后取中位数
        int i = 0, j = 0, k = 0;
        while (k < m + n) {

            if (i == m) {
                while (j != n) {
                    nums[k++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[k++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        if (k % 2 == 0) {
            return (nums[k/2 -1] + nums[k/2])/2.0;
        } else {
            return nums[k/2];
        }

    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 4, 5, 9};
        int[] nums2 = new int[]{2, 8, 12, 16};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}
