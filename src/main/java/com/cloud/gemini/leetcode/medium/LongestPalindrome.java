package com.cloud.gemini.leetcode.medium;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * created by fufan on 2019-07-22 22:21
 **/
public class LongestPalindrome {

    /**
     * 解法一：采用中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int centerIndex = 0;
        int longestAmount = 0;
        for (int i = 1; i < 2 * s.length() - 1; i ++) {
            int temp = getLongestAmount(s, i);
            if (temp > longestAmount) {
                longestAmount = temp;
                centerIndex = i;
            }
        }
        if (centerIndex == 0 && longestAmount == 0) {
            return s.substring(0, 1);
        }
        return  s.substring((centerIndex - longestAmount) / 2, (centerIndex + longestAmount) / 2);


    }

    public static int getLongestAmount(String s, int i ) {
        int longestAmount = i % 2;
        int k = i / 2;
        while (i - k < s.length() && k > 0) {
            if (s.charAt(k -1) == s.charAt(i - k)) {
                longestAmount += 2;
            } else {
                break;
            }
            k --;
        }
        return longestAmount;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
