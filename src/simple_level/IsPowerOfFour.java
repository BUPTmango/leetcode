package simple_level;

/**
 * 342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4?的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/26 9:22 上午
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        // 特殊情况0 不考虑
        if (num == 0) {
            return false;
        }
        // 一直除以4 直到不能除为止
        while (num % 4 == 0) {
            num /= 4;
        }
        // 检查最后是不是1
        return num == 1;
    }
}
