package middle_level;

import java.util.Stack;

/**
 * 单调栈
 * 1081. 不同字符的最小子序列
 * 返回字符串 text中按字典序排列最小的子序列，该子序列包含text中所有不同字符一次。
 *
 * 示例 1：
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 * 
 * 提示：
 *
 * 1 <= text.length <= 1000
 * text由小写英文字母组成
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 4:15 下午
 */
public class SmallestSubsequence {
    public String smallestSubsequence(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            // 如果栈中已经有了 直接跳过
            if (stack.contains(c)) {
                continue;
            }
            // 后面还有机会出现的才能pop
            while (!stack.empty() && c < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestSubsequence s = new SmallestSubsequence();
        System.out.println(s.smallestSubsequence("cdadabcc"));
    }
}
