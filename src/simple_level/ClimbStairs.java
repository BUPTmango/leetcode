package simple_level;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
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

    public static void main(String[] args) {
        System.out.println(climbStairs_roop(3));
    }
}