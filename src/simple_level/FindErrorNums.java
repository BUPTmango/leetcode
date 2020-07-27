package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 645. 错误的集合
 * 集合 S 包含从1到?n?的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/27 2:17 下午
 */
public class FindErrorNums {
    /**
     * 检查 1 到 n 的每个数字在 map 中出现次数。如果一个数字在 map 中没有出现，它就是缺失数字。如果一个数字的出现了两次，它就是重复数字。
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Map< Integer, Integer > map = new HashMap();
        int dup = -1, missing = 1;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }
}
