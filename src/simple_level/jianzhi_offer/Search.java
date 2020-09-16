package simple_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例?2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * ?
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/11 8:13 上午
 */
public class Search {
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map.get(target) == null ? 0 : map.get(target);
    }

    /**
     * 应用两次二分，分别查找 right 和 left ，最终返回 right - left - 1 即可
     * @param nums
     * @param target
     * @return
     */
    public int search_binary(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) {
            return 0;
        }
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }
}
