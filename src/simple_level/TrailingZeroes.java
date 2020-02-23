package simple_level;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 172
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @author mango
 * @create 2019-03-27 11:18 AM
 */
public class TrailingZeroes {
    /**
     * 想到求0也就是求其中2*5的个数，也就是5的个数，
     * 因为每一个偶数都含2，只要有5肯定有2。然后我就遍历求能不能被5整除
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n = n / 5;
            res += n;
        }
        return res;
    }

}