package simple_level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 * 给你一个整数数组arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回true；否则返回 false。
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * 
 *
 * 提示：
 *
 * 1 <= arr.length<= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 9:02 上午
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计次数
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        // 次数放入set中
        for (int key : map.keySet()) {
            Integer times = map.get(key);
            if (set.contains(times)) {
                return false;
            } else {
                set.add(times);
            }
        }
        return true;
    }
}
