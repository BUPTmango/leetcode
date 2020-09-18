package middle_level;

/**
 * 《玩转算法面试视频例题》三路快排
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共?n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、?1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/18 7:53 下午
 */
public class SortColors {

    /**
     * 三路快排 <1 =1 >1
     * @param nums
     */
    public void sortColors(int[] nums) {
        // nums[0,zero] == 0
        int zero = -1;
        // nums[two,n-1] == 2
        int two = nums.length;
        for (int i = 0; i < two; ) {
            // ==1 直接往后遍历 中间部分为1
            if (nums[i] == 1) {
                i++;
                // ==2 two-1之后和i交换位置 保持数组结构 后面部分为2
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
                // ==0 zero+1之后交换位置 保持数组接口 前面部分为0
            } else {
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int middle = nums[i];
        nums[i] = nums[j];
        nums[j] = middle;
    }
}
