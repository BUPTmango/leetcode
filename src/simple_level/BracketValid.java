package simple_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author mango
 * @create 2019-03-07 10:24 AM
 */
public class BracketValid {
    /**
     * 算法
     *
     * 初始化栈 S。
     * 一次处理表达式的每个括号。
     * 如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
     * 如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
     * 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tar = s.charAt(i);
            if (hashMap.containsKey(tar)) {//字符是闭括号 拿出栈顶元素
                char top = stack.empty() ? '#' : stack.pop();
                //进行配对
                if (top != hashMap.get(tar)) {
                    return false;
                }
            } else {//如果遇到开括号，我们只需将其推到栈上即可
                stack.push(tar);
            }
        }
        return stack.empty();
    }
}