package hard_level;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/3 9:53 上午
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个有序数组
        int[] merge = merge(nums1, nums2);
        // 获取中位数
        int n = merge.length;
        if (n % 2 == 0) {
            return (merge[n / 2 - 1] + merge[n / 2]) / 2;
        } else {
            return merge[n / 2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0, j = 0, index = 0;
        int[] res = new int[length1 + length2];
        while (i < length1 && j < length2) {
            if (nums1[i] <= nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        while (i < length1) {
            res[index++] = nums1[i++];
        }
        while (j < length2) {
            res[index++] = nums2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays find = new FindMedianSortedArrays();
        System.out.println(Arrays.toString(find.merge(new int[]{3, 5}, new int[]{2,4,6})));
    }
}
