package middle_level;

/**
 * 1111. 有效括号的嵌套深度
 * 有效括号字符串 仅由?"(" 和?")"?构成，并符合下述几个条件之一：
 *
 * 空字符串
 * 连接，可以记作?AB（A 与 B 连接），其中?A?和?B?都是有效括号字符串
 * 嵌套，可以记作?(A)，其中?A?是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度?depth(S)：
 *
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中?A 和?B?都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和?"()(()())"?都是有效括号字符串，嵌套深度分别为 0，1，2，而?")(" 和?"(()"?都不是有效括号字符串。
 *
 * ?
 *
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列?A 和?B，且?A 和?B?满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 *
 * 现在，你需要从中选出 任意?一组有效括号字符串?A 和?B，使?max(depth(A), depth(B))?的可能取值最小。
 *
 * 返回长度为?seq.length 答案数组?answer?，选择?A?还是?B?的编码规则是：如果?seq[i]?是?A?的一部分，那么?answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回?一个。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * ?
 *
 * 提示：
 *
 * 1 <= text.size <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/1 9:10 上午
 */
public class MaxDepthAfterSplit {
    /**
     * 如果当前字符是 (，就把 ( 压入栈中，此时这个 ( 的嵌套深度为栈的高度；
     * 如果当前字符是 )，此时这个 ) 的嵌套深度为栈的高度，随后再从栈中弹出一个 (。
     *
     * 知道如何计算嵌套深度，问题就很简单了：
     * 只要在遍历过程中，我们保证栈内一半的括号属于序列 A，一半的括号属于序列 B，
     * 那么就能保证拆分后最大的嵌套深度最小，是当前最大嵌套深度的一半。
     *
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.length() == 0) {
            return new int[0];
        }
        int[] res = new int[seq.length()];
        int count = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                count++;
                res[i] = count % 2;
            }
            if (c == ')') {
                res[i] = count % 2;
                count--;
            }
        }
        return res;
    }
}
