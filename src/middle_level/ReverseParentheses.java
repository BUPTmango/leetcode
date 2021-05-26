package middle_level;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/26 10:52
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果是左括号，将 str 插入到栈中，并将 str 置为空，进入下一层；
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            // 如果是右括号，则说明遍历完了当前层，需要将 str 反转，返回给上一层。
            // 具体地，将栈顶字符串弹出，然后将反转后的 str 拼接到栈顶字符串末尾，将结果赋值给 str。
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            // 如果是小写英文字母，将其加到 str 末尾。
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
