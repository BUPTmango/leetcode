package middle_level;

/**
 * 50. Pow(x, n)
 * 实现?pow(x, n)?，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例?2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例?3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/11 12:35 下午
 */
public class MyPow {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        // 采用二分法，降低复杂度到logN
        double y = quickMul(x, N / 2);
        // 偶数是正常的，奇数还要多乘一个x
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        // 如果n小于0，返回倒数
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}
