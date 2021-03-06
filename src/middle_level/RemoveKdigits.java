package middle_level;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 2:53 下午
 */
public class RemoveKdigits {
    /**
     * 利用单调栈思路解决
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        char[] chars = num.toCharArray();
        for (char c : chars) {
            // 移除比新添加的数字小的
            while (!deque.isEmpty() && deque.peekLast() > c && k > 0) {
                deque.removeLast();
                k--;
            }
            // 添加元素
            deque.offerLast(c);
        }
        // 如果k还有剩余 从后面大的开始删
        while (k-- > 0 && !deque.isEmpty()) {
            deque.removeLast();
        }
        if (deque.isEmpty()) {
            return "0";
        }
        // 构建 返回
        char[] res = new char[deque.size()];
        int index = 0;
        // 解决删除开头为0的问题
        boolean zeroHead = true;
        while (!deque.isEmpty()) {
            char c = deque.removeFirst();
            if (c == '0' && zeroHead) {
                continue;
            }
            zeroHead = false;
            res[index++] = c;
        }
        return index == 0 ? "0" : new String(Arrays.copyOf(res, index));
    }
}
