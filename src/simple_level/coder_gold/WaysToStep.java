package simple_level.coder_gold;

/**
 * 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/3 11:33 上午
 */
public class WaysToStep {
    /**
     * 取余公式： (a + b + c)%p = ((a%p + b%p)%p + c%p)%p
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            result[i] = ((result[i-3]%mod + result[i-2]%mod)%mod + result[i-1]%mod)%mod;
        }
        return result[n];
    }
}
