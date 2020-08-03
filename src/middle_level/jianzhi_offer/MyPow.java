package middle_level.jianzhi_offer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/3 9:42 上午
 */
public class MyPow {
    public double myPow(double x, int n) {
        // x为0，直接返回0
        if(x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        // 当 n < 0 时：把问题转化至 n≥0 的范围内，即执行 x = 1/x，n = - n；
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        // 循环计算：当 n = 0时跳出；
        while(b > 0) {
            // 当 n&1=1 时：将当前 x 乘入 res （即 res *= x ）；
            if((b & 1) == 1) res *= x;
            // 执行 x = x^2
            x *= x;
            // 执行 n 右移一位（即 n >>= 1）
            b >>= 1;
        }
        return res;
    }
}
