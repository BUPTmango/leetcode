package middle_level;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为?n?的整数数组?nums，其中?n > 1，返回输出数组?output?，其中 output[i]?等于?nums?中除?nums[i]?之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在?O(n) 时间复杂度内完成此题。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/3 11:47 上午
 */
public class ProductExceptSelf {
    /**
     * 分为左右部分 将两部分相乘
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            // 将数组初始化为1
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }
}
