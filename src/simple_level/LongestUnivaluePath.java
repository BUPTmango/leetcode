package simple_level;

import data_structure.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/21 4:01 下午
 */
public class LongestUnivaluePath {
    private int ans;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.ans = 0;
        univaluePath(root);
        return this.ans;
    }

    private int univaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = univaluePath(root.left);
        int r = univaluePath(root.right);
        int pl = 0, pr = 0;
        // 如果根结点等于左节点 pl+1
        if (root.left != null && root.val == root.left.val) {
            pl = l + 1;
        }
        // 如果根结点等于右节点 pr+1
        if (root.right != null && root.val == root.right.val) {
            pr = r + 1;
        }
        // 用pl+pr更新ans的值
        this.ans = Math.max(this.ans, pl + pr);
        return Math.max(pl, pr);
    }
}
