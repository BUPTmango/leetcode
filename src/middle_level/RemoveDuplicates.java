package middle_level;

/**
 * 《玩转算法面试视频例题》
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例?1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例?2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为?0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/18 6:51 下午
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // 初始化第二个指针和计数器
        int j = 1, count = 1;

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素是重复元素 count++
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // 遇到不同元素重置指针
                count = 1;
            }

            // 如果count小于等于2 复制元素
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
