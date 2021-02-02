package middle_level;

/**
 * 372. 超级次方
 * 你的任务是计算ab对1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1：
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 * 示例 2：
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 * 示例 3：
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 * 提示：
 *
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/2 3:23 下午
 */
public class SuperPow {
    private int base = 1337;

    public int superPow(int a, int[] b) {
        // 递归 取模 高效幂
        return findPow(a, b, b.length - 1);
    }

    private int findPow(int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        int last = b[index];
        // 缩小规模递归求解
        int part1 = myPow(a, last);
        int part2 = myPow(findPow(a, b, index - 1), 10);
        return (part1 * part2) % base;
    }

    private int myPow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        a %= base;
        // 奇数
        if (k % 2 == 1) {
            return (a * myPow(a, k - 1)) % base;
        // 偶数
        } else {
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }
}
