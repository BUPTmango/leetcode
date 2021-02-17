package middle_level;

/**
 * 和两数之和相似
 * <p>
 * 633. 平方数之和
 * 给定一个非负整数c，你要判断是否存在两个整数 a 和 b，使得a2 + b2 = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 * <p>
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 0 <= c <= 231 - 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/17 9:31 下午
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
