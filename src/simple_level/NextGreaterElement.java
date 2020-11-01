package simple_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈
 * 496. 下一个更大元素 I
 * 给定两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。
 *
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 * 提示：
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2的数组大小都不超过1000。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/31 5:13 下午
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums2放入map中 方便查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        int[] fullRes = new int[nums2.length];
        // 倒着往栈里放
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 判断个子高矮
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                // 矮子起开 反正也被挡着了
                stack.pop();
            }
            fullRes[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = fullRes[map.get(nums1[i])];
        }
        return res;
    }
}
