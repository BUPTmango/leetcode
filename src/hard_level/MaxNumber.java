package hard_level;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈
 * 321. 拼接最大数
 * 给定长度分别为m和n的两个数组，其元素由0-9构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为k的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/2 10:13 上午
 */
public class MaxNumber {
    /**
     * 1：从nums1里取i个元素组成最大数组，从nums2里取k-i个元素组成最大数组。
     * 2：合并之前结果，得到一个长度为k的最大数组。
     * 3：对于不同长度分配的情况，比较每次得到的长度为k的最大数组，返回最大的一个。
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }
        return ans;
    }

    /**
     * 对两个数组进行合并
     */
    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    /**
     * 比较两个数组的大小
     */
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    /**
     * 取出数组中最大的k个元素
     */
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 先pop 判断剩余数组元素能不能凑够k
            while (!stack.isEmpty() && stack.peek() < nums[i] && n - i + stack.size() > k) {
                stack.pop();
            }
            // 再添加
            stack.push(nums[i]);
        }
        // stack变为数组
        int length = stack.size();
        int[] array = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        return Arrays.copyOfRange(array, 0, k);
    }

    public static void main(String[] args) {
        MaxNumber number = new MaxNumber();
        System.out.println(Arrays.toString(number.maxArray(new int[]{3, 4, 6, 5}, 2)));
    }
}
