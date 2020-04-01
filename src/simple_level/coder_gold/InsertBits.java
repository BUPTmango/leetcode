package simple_level.coder_gold;

/**
 * 面试题 05.01. 插入
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 10000000000, M = 10011, i = 2, j = 6
 *  输出：N = 10001001100
 * 示例2:
 *
 *  输入： N = 0, M = 11111, i = 0, j = 4
 *  输出：N = 11111
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/1 11:57 上午
 */
public class InsertBits {
    /**
     * 不明白
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public int insertBits(int N, int M, int i, int j) {
        for (int distance = i; distance < j + 1; distance++) {
            // 将11111111111111111111111111111110首尾循环移动 distance 位并与 N 与运算将第 distance 位清零
            N = N & Integer.rotateLeft(~1, distance);
        }
        return N | (M << i);
    }
}
