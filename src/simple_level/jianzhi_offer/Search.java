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
}
