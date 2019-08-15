package com.cloud.gemini.leetcode.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * created by fufan on 2019-08-15 22:50
 **/
public class IsValid {

    /**
     * 需要判断两步
     *
     * step 1： 若为左括号，则入栈
     * step 2： 若为右括号，则出栈比对是否是同一类型的匹配
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        boolean result = true;
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char a: array) {
            if (a == '(' || a == '[' || a== '{') {
                stack.add(a);
            }
            else if (a == ')') {
                result = result && !stack.isEmpty() && '(' == stack.pop();
            }
            else if (a == ']') {
                result = result && !stack.isEmpty() && '[' == stack.pop();
            }
            else if (a == '}') {
                result = result && !stack.isEmpty() && '{' == stack.pop();
            }
        }
        result = result && stack.isEmpty();
        return result;
    }

    public static void main(String[] args) {

        System.out.println(isValid("{[(1 + 2)} * 3 ]]"));

    }
}
