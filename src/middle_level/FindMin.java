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
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        // 如果第一个元素已经比最后一个小了 那就是正常的没有经过旋转的数组 直接返回第一个元素就好了 就是最小值
        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 说明mid+1是转折点
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // 说明mid是转折点
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            // 注意！！ 这里mid每次和数组的第一个元素做比较
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
