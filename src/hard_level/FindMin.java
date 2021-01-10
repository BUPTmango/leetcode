package hard_level;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 示例2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 *
 * 这道题是寻找旋转排序数组中的最小值的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/10 11:18 上午
 */
public class FindMin {
    /**
     * 同 153
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            // 注意！！ 这里和右边界比较
            if (nums[m] > nums[j]) {
                i = m + 1;
            } else if (nums[m] < nums[j]) {
                // 注意！！ 这里不是 m - 1  是因为有可能此时m就是最小值
                j = m;
            } else {
                // 相等的时候无法判断在左边还是在右边 缩小范围
                j--;
            }
        }
        // i==j的时候跳出循环
        return nums[i];
    }
}
