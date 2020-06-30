package middle_level;

/**
 * 1014. 最佳观光组合
 * 给定正整数数组?A，A[i]?表示第 i 个观光景点的评分，并且两个景点?i 和?j?之间的距离为?j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i?- j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 * ?
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/30 1:49 下午
 */
public class MaxScoreSightseeingPair {
    /**
     * 我们回过头来看得分公式，我们可以将其拆分成 A[i]+iA[i]+i 和 A[j]-jA[j]?j 两部分，
     * 这样对于统计景点 jj 答案的时候，由于 A[j]-jA[j]?j 是固定不变的，
     * 因此最大化 A[i]+i+A[j]-jA[i]+i+A[j]?j 的值其实就等价于求 [0,j-1][0,j?1] 中 A[i]+iA[i]+i 的最大值 mxmx，
     * 景点 jj 的答案即为 mx+A[j]-jmx+A[j]?j 。
     * 而 mxmx 的值我们只要从前往后枚举 jj 的时候同时维护即可
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }
}
