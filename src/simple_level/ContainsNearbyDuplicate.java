package simple_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 《玩转算法面试视频例题》滑动窗口 + 查找表
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 * ?
 *
 * 示例?1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/12 6:09 下午
 */
public class ContainsNearbyDuplicate {
    /**
     * 问题转化为在一个k长度的区间里有没有两个元素的值相等
     * 用散列表维护一个 k 大小的滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 存放窗口中的所有数值
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // 在散列表中搜索当前元素，如果找到了就返回true
            if (set.contains(nums[i])) {
                return true;
            }
            // 在散列表中插入当前元素
            set.add(nums[i]);
            // 如果当前散列表的大小超过了k， 删除散列表中最旧的元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
