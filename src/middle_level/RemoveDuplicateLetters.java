package middle_level;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/20 11:19 上午
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        // 存放每个字符最后出现的位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        // 存放每个字符是不是已经访问过
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            // 如果已经访问过这个字符 跳过
            if (visited[charArray[i] - 'a']) {
                continue;
            }
            // 如果加入的元素比栈顶小 并且 栈顶元素在之后还出现过 就pop
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
