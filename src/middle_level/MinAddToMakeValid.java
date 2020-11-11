package middle_level;

/**
 * 括号问题
 * 921. 使括号有效的最少添加
 * 给定一个由'('和')'括号组成的字符串 S，我们需要添加最少的括号（ '('或是')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 * 示例 1：
 *
 * 输入："())"
 * 输出：1
 * 示例 2：
 *
 * 输入："((("
 * 输出：3
 * 示例 3：
 *
 * 输入："()"
 * 输出：0
 * 示例 4：
 *
 * 输入："()))(("
 * 输出：4
 * 
 *
 * 提示：
 *
 * S.length <= 1000
 * S 只包含'(' 和')'字符。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 8:34 下午
 */
public class MinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        // res 记录括号的插入次数
        int res = 0;
        // need 记录右括号的需求量
        int need = 0;

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                // 对右括号的需求量 + 1
                need++;
            }
            if (chars[i] == ')') {
                // 对右括号的需求量 - 1
                need--;
            }
            if (need == -1) {
                need = 0;
                // 需要插入一个左括号
                res++;
            }
        }
        // for结束之后 如果need不为0 表示右括号还不够 需要插入
        return res + need;
    }
}
