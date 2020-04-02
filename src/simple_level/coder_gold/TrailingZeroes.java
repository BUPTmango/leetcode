package simple_level.coder_gold;

/**
 * 面试题 16.05. 阶乘尾数
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释:?3! = 6, 尾数中没有零。
 * 示例?2:
 *
 * 输入: 5
 * 输出: 1
 * 解释:?5! = 120, 尾数中有 1 个零.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/2 11:47 上午
 */
public class TrailingZeroes {
    /**
     * 其实n!中的零全部是5和2的倍数贡献的，由于因子为2的个数大于5的，所以，只需计算其中有多少个5的倍数即可。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int m5 = 0;
        while(n > 0){
            m5 += n/5;
            n/=5;
        }
        return m5;
    }
}
