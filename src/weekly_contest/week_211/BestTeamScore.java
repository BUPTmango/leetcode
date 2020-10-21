package weekly_contest.week_211;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 5545. 无矛盾的最佳球队
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 * <p>
 * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 * <p>
 * 输入：scores = [1,2,3,5], ages = [8,9,10,1]
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 * <p>
 * 提示：
 * <p>
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 11:08 上午
 */
public class BestTeamScore {
    /**
     * 300 最长上升子序列变种题
     *
     * @param scores
     * @param ages
     * @return
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores.length == 1) {
            return scores[0];
        }

        int[][] arr = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // 按年龄递增排序，年龄相同的按分数递增排序
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[] dp = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            dp[i] = arr[i][1];
        }

        int ans = 0;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < i; j++) { // 找在i之前有没有比i小的
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,3,2};
        Arrays.sort(array, Comparator.comparingInt(o -> o));
        for (int i : array) {
            System.out.println(i);
        }
    }
}
