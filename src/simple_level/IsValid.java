package simple_level;

import java.util.Stack;

/**
 * 《玩转算法面试视频例题》栈
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串，判断字符串是否有效。
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
 * 示例?2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例?3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例?4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例?5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 12:18 上午
 */
public class IsValid {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(') {
                stack.push(')');
            } else if(c=='{') {
                stack.push('}');
            } else if(c=='[') {
                stack.push(']');
            }
            // pop出来的和c不相同就够不成有效的括号
            else if(stack.empty()||c!=stack.pop()) {
                return false;
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}
