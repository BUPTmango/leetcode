package middle_level.jianzhi_offer;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * ?
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * ?
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/11 11:22 上午
 */
public class TranslateNum {
    /**
     * 动态规划 两种情况相加 一种是前面所有加最后一位 另一种是前面所有加最后两位
     * 使用循环计数
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = s.length() - 2; i > -1; i--) {
            String tmp = s.substring(i, i + 2);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
