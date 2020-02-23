package simple_level;

/**
 * 268
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n?中?n?个数的序列，找出 0 .. n?中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例?2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/20 10:50 上午
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int subSum = 0;
        int sum = 0;
        for (int i : nums) {
            subSum += i;
        }
        for (int j = 0; j <= nums.length; j++) {
            sum += j;
        }
        return sum - subSum;
    }
}
