package middle_level;

/**
 * 718. 最长重复子数组
 * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * 
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/4 10:22 上午
 */
public class FindLength {
    /**
     * 滑动窗口
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        // B 不变，A 的首元素与 B 中的某个元素对齐 之后进行寻找
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        // A 不变，B 的首元素与 A 中的某个元素对齐 之后进行寻找
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    /** 比较两个数组相同的子数组的最大长度 */
    private int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    /**
     * 动态规划
     * @param A
     * @param B
     * @return
     */
    public int findLength_dp(int[] A, int[] B) {
        int max = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = B.length; j >= 1; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
