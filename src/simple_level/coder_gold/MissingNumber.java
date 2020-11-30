package simple_level.coder_gold;

import java.util.HashSet;
import java.util.Set;

/**
 * 寻找消失的数字
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

    /**
     * 位运算 异或
     * @param nums
     * @return
     */
    public int missingNumber_better(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先补一位索引 让索引和数字一一对应
        res ^= n;
        // 因为相同的数字异或的结果为0 所以最后剩下的就是结果
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    /**
     * 位运算同样的思想 只是^换成了-
     * @param nums
     * @return
     */
    public int missingNumber_diff(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 新补的索引
        res += n;
        // 剩下索引和元素的差加起来
        for (int i = 0; i < n; i++) {
            res += i - nums[i];
        }
        return res;
    }
}
