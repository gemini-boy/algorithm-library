package com.cloud.gemini.leetcode.easy;

import java.util.Arrays;

/**
* @author Perry
* @date 2019-07-19 09:52:28
* 
*/
public class ArrayPartitionI_561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,4,3,2};
		System.out.println(arrayPairSum(arr));
	}
	
	public static int arrayPairSum(int[] nums) {
        if(nums.length % 2 != 0){
            return 0;
        }

        int maxSum = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i+=2){
            maxSum += nums[i];
        }

        return maxSum;
    }

}
