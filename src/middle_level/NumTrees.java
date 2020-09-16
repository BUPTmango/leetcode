package middle_level;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以?1 ...?n?为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/16 4:54 下午
 */
public class NumTrees {
    /**
     * 动态规划
     * 给定一个有序序列 1 \cdots n1?n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 ii，将该数字作为树根，将 1 \cdots (i-1)1?(i?1) 序列作为左子树，将 (i+1) \cdots n(i+1)?n 序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。
     *
     * 在上述构建的过程中，由于根的值不同，因此我们能保证每棵二叉搜索树是唯一的。
     *
     * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
