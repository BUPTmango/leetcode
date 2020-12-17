package hard_level;

import data_structure.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *   -10
 *  / \
 *  9 20
 *   / \
 *  15  7
 *
 * 输出：42
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/17 6:08 下午
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新答案   ！！选择左中右结构的路径
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回节点的最大贡献值   ！！选择左中或者右中的结构
        return node.val + Math.max(leftGain, rightGain);
    }
}
