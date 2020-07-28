package middle_level.jianzhi_offer;

/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/28 10:53 上午
 */
public class CountDigitOne {
    /**
     * while high != 0 or cur != 0: # 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
     *    low += cur * digit # 将 cur 加入 low ，组成下轮 low
     *    cur = high % 10 # 下轮 cur 是本轮 high 的最低位
     *    high //= 10 # 将本轮 high 最低位删除，得到下轮 high
     *    digit *= 10 # 位因子每轮 × 10
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) {
                res += high * digit;
            } else if(cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
