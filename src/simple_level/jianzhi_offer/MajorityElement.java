package simple_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例?1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * ?
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/4 9:46 上午
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 票数和： 由于众数出现的次数超过数组长度的一半；若记 众数 的票数为 +1 ，非众数 的票数为 -1 ，则一定有所有数字的 票数和 > 0 。
     *
     * @param nums
     * @return
     */
    public int majorityElement_vote(int[] nums) {
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        return result;
    }
}
