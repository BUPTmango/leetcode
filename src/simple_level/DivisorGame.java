package simple_level;

/**
 * 1025. 除数博弈
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字N。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一x，满足0 < x < N 且N % x == 0。
 * 用 N - x替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 11:40 上午
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }

        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                // j是i的因数并且剩下的i-j要能获胜
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}
