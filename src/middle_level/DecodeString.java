package middle_level;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 9:34 上午
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            // 当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 0：
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // 入栈后重置
                multi = 0;
                res = new StringBuilder();
            }
            // 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            // 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
            else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            // 当 c 为字母时，在 res 尾部添加 c；
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
    }
}
