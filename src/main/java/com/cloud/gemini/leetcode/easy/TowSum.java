package com.cloud.gemini.leetcode.easy;

/**
 * created by fufan on 2019-07-16 19:39
 **/
public class TowSum {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        for (int i: twoSum(new int[]{1,3,5,7,9}, 1)) {
            System.out.println(i);
        }
    }
}
