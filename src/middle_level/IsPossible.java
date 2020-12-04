package middle_level;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * 提示：
 * <p>
 * 输入的数组长度范围为 [1, 10000]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/4 8:52 上午
 */
public class IsPossible {
    /**
     * 哈希表 + 最小堆
     * 只要知道子序列的最后一个元素和子序列的长度就可以确定子序列
     * 哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列长度，最小堆满足堆顶的元素是最小的，因此堆顶的元素即为最小的子序列长度。
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<>());
            }
            // 当 x 在数组中时，如果存在一个子序列以 x-1 结尾，长度为 k，则可以将 x 加入该子序列中，得到长度为 k+1 的子序列。
            // 如果不存在以 x-1 结尾的子序列，则必须新建一个只包含 x 的子序列，长度为 1。
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                // 取空了记得删除
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                // 续在原来的子序列上
                map.get(x).offer(prevLength + 1);
            } else {
                // 创建新的子序列
                map.get(x).offer(1);
            }
        }

        // 因为最小的子序列都在堆顶 所以遍历每个堆的堆顶元素 长度不小于3即可
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * 贪心
     * 尽量避免创建短的子序列
     * @param nums
     * @return
     */
    public boolean isPossible_faster(int[] nums) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        // 存储数组中的每个数字作为结尾的子序列的数量
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int prevEndCount = endMap.getOrDefault(x - 1, 0);
                // 如果有x-1的子序列就加入
                if (prevEndCount > 0) {
                    // 因为使用了一次 count要减1
                    countMap.put(x, count - 1);
                    // x-1为结尾的数量减1 x为结尾的数量加1
                    endMap.put(x - 1, prevEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    // x要单独创建 因为长度不能少于3 那么x+1和x+2的个数都不能为0 否则不能创建
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
