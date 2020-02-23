package simple_level;

import data_structure.TreeNode;

/**
 * 112
 * 给定一个二叉树和一个目标和，
 * 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author mango
 * @create 2019-03-22 9:43 AM
 */
public class HasPathSum {
    /**
     * 采用递归调用的形式，每次开始都从sum中减去到根结点的值，
     * 然后再判断当前的节点作为根结点到其左孩子和右孩子的距离与t的关系。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int t = sum - root.val;
        if (root.left == null && root.right == null) {
            return t == 0 ? true : false;
        }
        return hasPathSum(root.left, t) || hasPathSum(root.right, t);
    }
}