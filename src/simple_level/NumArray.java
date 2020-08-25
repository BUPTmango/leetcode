package simple_level;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组 ?nums，求出数组从索引?i?到?j??(i?≤?j) 范围内元素的总和，包含?i,? j?两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用?sumRange?方法。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/25 11:06 下午
 */
class NumArray {

    private int[] sum;

    /**
     * 初始化的时候计算出每个索引代表的sum
     * @param nums
     */
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    /**
     * 将两个索引位置的sum相减就是结果
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
