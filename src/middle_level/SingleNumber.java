package middle_level;

/**
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/26 8:14 下午
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // 如果当前位是1就++
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            // 如果能整除3 结果的位置就是0 否则为1
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
