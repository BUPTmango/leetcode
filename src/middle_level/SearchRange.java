package middle_level;

/**
 * 二分查找
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回[-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 11:05 上午
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] rangeRes = new int[]{-1, -1};

        int index = binarySearch(nums, target);
        if (index == -1) {
            return rangeRes;
        }

        // 找到位置后向左右扩展
        int start = index, end = index;
        while (start - 1 >= 0 && nums[start - 1] == target) {
            start--;
        }
        while (end + 1 < nums.length && nums[end + 1] == target) {
            end++;
        }

        rangeRes[0] = start;
        rangeRes[1] = end;
        return rangeRes;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
