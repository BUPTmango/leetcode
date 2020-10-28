package simple_level;

/**
 * 二分查找
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 
 *
 * 提示：
 *
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/28 9:59 上午
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // [left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{1,2,2,2,5}, 9));
    }
}
