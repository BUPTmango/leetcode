package middle_level;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数?k，你需要找到该数组中和为?k?的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/17 8:54 下午
 */
public class SubarraySum {
    /**
     * 前缀和加哈希表优化
     * [j..i] 这个子数组和为 k 这个条件我们可以转化为 : pre[i]?pre[j?1]==k
     * 我们考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]?k 的 pre[j] 即可。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // hash
        // 记录合适的连续字符串数量
        int count = 0;
        // 记录前面数字相加之和
        int pre = 0;
        // map记录前几个数字之和为K出现相同和的次数为V
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 如果前面数字之和加上这个数字正好等于K（存在一个数字加上nums[i]结果为K
            // 说明找到了
            if (map.containsKey(pre - k)) {
                // 累计
                count += map.get(pre - k);
            }
            // 计算新的和放入map
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
