package simple_level;

/**
 * 326
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3?的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/22 10:03 上午
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        // 有特殊的数字就要首先进行判断，这样可以减少循环的次数
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0 || n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsPowerOfThree is = new IsPowerOfThree();
        System.out.println(is.isPowerOfThree(27));
    }
}
