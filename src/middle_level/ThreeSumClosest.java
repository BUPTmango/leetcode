package middle_level;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 16
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author Wang Guolong
 * @create 2019-04-26 2:56 PM
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;
        int result = 0;
        for (int p = 0; p < nums.length; p++) {
            for (int q = p + 1; q < nums.length; q++) {
                for (int r = q + 1; r < nums.length; r++) {
                    if (Math.abs((nums[p] + nums[q] + nums[r]) - target) < distance) {
                        distance = Math.abs((nums[p] + nums[q] + nums[r]) - target);
                        result = nums[p] + nums[q] + nums[r];
                    }
                }
            }
        }
        return result;
    }

    /**
     * 假设取的第一个数是A[i]，那么第二三两个数从A[i+1]~A[len]中取出。
     * 找到“第一个数为A[i]固定，后两个数在A[i]后面元素中取。
     * 并且三数之和离target最近的情况。”
     * 这时，我们用两个指针j,k分别指向A[i+1]和A[len]，
     * 如果此时三数之和A[i]+A[j]+A[k]<target，说明三数之和小了，我们将j后移一格；
     * 反之，若和大于target，则将k前移一格；直到j和k相遇为止。
     * 在这期间，保留与target最近的三数之和。一旦发现有“和等于target的情况”,立即输出即可。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest_better(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;
        int result = 0;
        //先排序
        Arrays.sort(nums);
        for (int p = 0; p < nums.length; p++) {
            int left = p + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[p] + nums[left] + nums[right];
                if (distance > Math.abs(sum - target)) {
                    distance = Math.abs(sum - target);
                    result = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left ++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}