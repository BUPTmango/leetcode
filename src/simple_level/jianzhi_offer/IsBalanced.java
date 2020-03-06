package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * 面试题55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * ?
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回?false 。
 *
 * ?
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/6 7:20 上午
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((!isBalanced(root.left)) || (!isBalanced(root.right))) {
            return false;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return true;
    }

    /**
     * 计算树的高度
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
