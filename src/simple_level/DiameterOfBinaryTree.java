package simple_level;

import data_structure.TreeNode;

/**
 * 543
 *  二叉树的直径
 *  给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回?3, 它的长度是路径 [4,2,1,3] 或者?[5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/15 11:09 上午
 */
public class DiameterOfBinaryTree {
    private int sum = 0;
    /**
     * 找到每个节点的深度(等于max(左节点深度,右节点深度)+1)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }
}
