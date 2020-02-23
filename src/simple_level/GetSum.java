package simple_level;

/**
 * 371
 * 两整数之和
 * 不使用运算符?+ 和?-????????，计算两整数????????a?、b????????之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/20 10:59 上午
 */
public class GetSum {
    /**
     * a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if(b == 0) {
            return a;        // when carry is zero, return
        }
        int sum = a ^ b;        // calculate sum without carry
        int carry = (a & b) << 1;       // calculate carry
        return getSum(sum, carry);
    }

}
