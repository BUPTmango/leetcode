package simple_level.coder_gold;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 *
 * 输入：[3,0,1]
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/21 8:58 上午
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int length = nums.length;
        for (int j = 0; j <= length; j++) {
            if (!set.contains(j)) {
                return j;
            }
        }
        return -1;
    }
}
