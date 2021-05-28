package middle_level;

import hard_level.Solution;

/**
 * 477. 汉明距离总和
 * 两个整数的汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * <p>
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 * <p>
 * 数组中元素的范围为从0到10^9。
 * 数组的长度不超过10^4。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/28 08:55
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                // 统计1的个数
                c += (val >> i) & 1;
            }
            // 如果第 i 位， c 个1， n - c 个0，则汉明距离之和为c * (n - c)
            ans += c * (n - c);
        }
        return ans;
    }
}
