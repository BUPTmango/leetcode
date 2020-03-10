package simple_level.jianzhi_offer;

/**
 * 面试题65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 * ?
 * 提示：
 *
 * a,?b?均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/10 11:07 上午
 */
public class Add {
    /**
     * a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if(b == 0) {
            return a;        // when carry is zero, return
        }
        int sum = a ^ b;        // calculate sum without carry 异或 不一样为1
        int carry = (a & b) << 1;       // calculate carry  与 同为1为1
        return add(sum, carry);
    }
}

