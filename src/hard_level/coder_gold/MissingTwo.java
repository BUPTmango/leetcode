package hard_level.coder_gold;

/**
 * 寻找消失的数字
 * 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 *
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 *
 * nums.length <=30000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/30 7:37 下午
 */
public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        // nums数组求和
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 先求出消失的两个元素的和
        int sumTwo = (int) (n * (n + 1) / 2 - sum);
        int limits = sumTwo / 2;
        sum = 0;
        for (int num : nums) {
            // 两个数不相同 那么一个大于 一个小于
            if (num <= limits) {
                sum += num;
            }
        }
        int one = (int) (limits * (limits + 1) / 2 - sum);
        return new int[]{one, sumTwo - one};
    }
}
