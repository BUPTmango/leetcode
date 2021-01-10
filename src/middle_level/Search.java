package middle_level;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是?O(log?n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例?2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/8 12:11 下午
 */
public class Search {
    /**
     * 二分查找
     * middle分成的两边肯定有一边是有序的，通过端点可以判断哪一边有序
     * 有序那边的端点是max和min，可以判断target是不是在里面
     * 不在里面的话就去另一边寻找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // 可以发现二分搜索的两边肯定有一边是有序的
        // 所以可以通过分别判断两边的各自的左右端点来查看具体哪一边是有序的
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            // 左边升序
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target <= nums[middle]) {
                    // target在左边范围内
                    right = middle - 1;
                } else {
                    // 只能从右边找
                    left = middle + 1;
                }
            } else {
                if (target >= nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
