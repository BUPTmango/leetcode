package simple_level;

/**
 * 双指针 原地修改
 * 《玩转算法面试视频例题》
 * 283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/10 10:08 下午
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }
        int currentIndex = 0;
        while (currentIndex + 1 < nums.length) {
            if (nums[currentIndex] == 0) {
                int i = currentIndex + 1;
                while (nums[i] == 0) {
                    i++;
                    if (i >= nums.length) {
                        return;
                    }
                }
                nums = switchElement(nums, i, currentIndex);
            }
            currentIndex++;
        }
    }

    private int[] switchElement(int[] nums, int oneIndex, int anotherIndex) {
        int middle = nums[anotherIndex];
        nums[anotherIndex] = nums[oneIndex];
        nums[oneIndex] = middle;
        return nums;
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[] {0,1,0,3,12});
    }

    /**
     * 两个指针 一个遍历指针另一个是存储换完位置的指针
     * @param nums
     */
    public void moveZeroes_better(int[] nums) {
        int temp;
        // idx指向下一个要交换的0的位置
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }
    }
}
