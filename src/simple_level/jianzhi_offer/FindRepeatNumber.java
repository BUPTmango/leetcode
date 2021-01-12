package simple_level.jianzhi_offer;


import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. shu数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * ?
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/3 9:25 上午
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    public int findRepeatNumber_in_place(int[] nums) {
        int temp;
        // 将每个数放在他数字的索引的位置 如果位置上已经有数字了 就说明重复了 直接返回
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
