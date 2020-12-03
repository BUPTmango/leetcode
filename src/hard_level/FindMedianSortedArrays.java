package hard_level;


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
    /**
     * 自己的做法 不满足题目要求的时间复杂度
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个有序数组
        int[] merge = merge(nums1, nums2);
        // 获取中位数
        int n = merge.length;
        if (n % 2 == 0) {
            return (merge[n / 2 - 1] + merge[n / 2]) / 2.0;
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

    public double findMedianSortedArrays_better(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            // 保证 m <= n
            return findMedianSortedArrays_better(B, A);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            // 对小的数组进行二分
            int i = (iMin + iMax) / 2;
            // 对大的数组取剩下的部分
            int j = (m + n + 1) / 2 - i;
            // 说明j取多了 i 需要增大
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                iMin = i + 1;
                // 说明 i 取多了 i 需要减小
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    // 奇数的话不需要考虑右半部分
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                // 如果是偶数的话返回结果
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays find = new FindMedianSortedArrays();
        System.out.println(find.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
