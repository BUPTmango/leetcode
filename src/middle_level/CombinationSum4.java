package middle_level;

/**
 * 《玩转算法面试视频例题》动态规划 背包问题
 * 377. 组合总和 Ⅳ
 *
 * 注意！！！！ 和518的区别
 * 「力扣」 第 377 题：一个组合的不同排列是一个新的组合。[1, 1, 2]、[1, 2, 2]、[2, 1, 2] 视为为不同的组合。
 * 「力扣」 第 518 题：一个组合的不同排列在结果集中只出现一次，这一点是「背包问题」的特征，拿东西的顺序不重要。[2, 2, 1] 是一个组合，[1, 2, 2] 和 [2, 1, 2] 不是新的组合。
 *
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 因此输出为 7。
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/19 9:00 下午
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示凑出i有多少种组合
        int[] dp = new int[target + 1];
        // dp[0] = 1，表示，如果那个硬币的面值刚刚好等于需要凑出的价值，这个就成为 1 种组合方案
        dp[0] = 1;
        // 对于每个目标，每个数字在不同的顺序中可以重复出现，所以以target的顺序为准来遍历
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // dp[i]= dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ... （当 [] 里面的数 >= 0）
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum4 com = new CombinationSum4();
        System.out.println(com.combinationSum4(new int[]{1,2,3}, 4));
    }
}
