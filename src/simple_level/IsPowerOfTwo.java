package simple_level;

/**
 * 231
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例?1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20?= 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24?= 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/25 10:19 上午
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int remainder = 0;
        while (n > 1) {
            remainder = n % 2;
            if (remainder != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
