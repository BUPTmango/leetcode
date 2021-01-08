package middle_level;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为O(1) 的原地算法。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/8 10:44 上午
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0)
            return;

        // 注意！！！  这里k有可能很大 所以要取余数
        int turns = k % nums.length;
        int middle = nums.length - turns;

        // reverse left part
        reverse(nums, 0, middle - 1);
        // reverse right part
        reverse(nums, middle, nums.length - 1);
        // reverse whole part
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
