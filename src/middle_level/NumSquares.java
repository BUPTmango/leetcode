package middle_level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 279. 完全平方数
 * 给定正整数?n，找到若干个完全平方数（比如?1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例?1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/30 1:58 下午
 */
public class NumSquares {

    /**
     * 标签：动态规划
     * 首先初始化长度为n+1的数组dp，每个位置都为0
     * 如果n为0，则结果为0
     * 对数组进行遍历，下标为i，每次都将当前数字先更新为最大的结果，即dp[i]=i，比如i=4，最坏结果为4=1+1+1+1即为4个数字
     * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i表示当前数字，j*j表示平方数
     * 时间复杂度：O(n*sqrt(n))，sqrt为平方根
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    /**
     * 广度优先搜索
     * 首先，我们准备小于给定数字 n 的完全平方数列表（即 square_nums）。
     * 然后创建 queue 遍历，该变量将保存所有剩余项在每个级别的枚举。
     * 在主循环中，我们迭代 queue 变量。在每次迭代中，我们检查余数是否是一个完全平方数。
     * 如果余数不是一个完全平方数，就用其中一个完全平方数减去它，得到一个新余数，然后将新余数添加到 next_queue 中，以进行下一级的迭代。
     * 一旦遇到一个完全平方数的余数，我们就会跳出循环，这也意味着我们找到了解。
     * @param n
     * @return
     */
    public int numSquares_BFS(int n) {

        // 将可能的平方数放到list中
        ArrayList<Integer> square_nums = new ArrayList<>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
}
