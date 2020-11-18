package hard_level;

/**
 * 阶乘零
 * 793. 阶乘函数后K个零
 * f(x)是x!末尾是0的数量。（回想一下x! = 1 * 2 * 3 * ... * x，且0! = 1）
 *
 * 例如，f(3) = 0，因为3! = 6的末尾没有0；而f(11) = 2，因为11!= 39916800末端有2个0。给定K，找出多少个非负整数x，有f(x) = K的性质。
 *
 * 示例 1:
 * 输入:K = 0
 * 输出:5
 * 解释:0!, 1!, 2!, 3!, and 4!均符合 K = 0 的条件。
 *
 * 示例 2:
 * 输入:K = 5
 * 输出:0
 * 解释:没有匹配到这样的 x!，符合K = 5 的条件。
 * 注意：
 *
 * K是范围在[0, 10^9]的整数。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/18 11:08 上午
 */
public class PreimageSizeFZF {
    /**
     * 使用二分查找
     * @param K
     * @return
     */
    public int preimageSizeFZF(int K) {
        // 左右边界之差加一就是结果
        return (int)(rightBound(K) - leftBound(K) + 1);
    }

    /**
     * 寻找 trailingZeroes(n) == K 的左边界
     * @param target
     * @return
     */
    private long leftBound(int target) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long curr = trailingZeroes(mid);
            if (curr > target) {
                right = mid;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                // 寻找左边界 所以找到后不返回 而是收紧右边界
                right = mid;
            }
        }
        return left;
    }

    /**
     * 寻找 trailingZeroes(n) == K 的右边界
     * @param target
     * @return
     */
    private long rightBound(int target) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long curr = trailingZeroes(mid);
            if (curr > target) {
                right = mid;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                // 寻找右边界 所以找到后不返回 而是收紧左边界
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private long trailingZeroes(long n) {
        long res = 0;
        while (n >= 5) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}
