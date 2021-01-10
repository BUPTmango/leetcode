package middle_level;

/**
 * 二分查找
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 10:21 上午
 */
public class FindMin {
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
