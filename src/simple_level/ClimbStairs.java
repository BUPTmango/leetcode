package simple_level;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》动态规划
 * 动态规划应该满足 1. 重叠子问题 2. 最优子结构
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 * @author mango
 * @create 2019-03-15 8:30 PM
 */
public class ClimbStairs {
    /**
     * 其实多数几组你就会发现规律
     * 一阶楼梯：1种方法
     * 两阶楼梯：2种方法
     * 三阶楼梯：3种方法
     * 四阶楼梯：5种方法
     * 五阶楼梯：8种方法
     * 六阶楼梯：13种方法
     * 朋友们应该看出来了有规律了 这不就是斐波那契数列么，只不过缺少第一项而已。
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 不用递归的方式
     * @param n
     * @return
     */
    public static int climbStairs_roop(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int x = 1;
        int y = 2;
        int count = 0;
        while (n >= 3) {
            count = x + y;
            x = y;
            y = count;
            n--;
        }
        return count;
    }

    /**
     * 动态规划 每个位置只计算一次 记忆化
     * @param n
     * @return
     */
    public int climbStairs_better(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs_roop(3));
    }
}