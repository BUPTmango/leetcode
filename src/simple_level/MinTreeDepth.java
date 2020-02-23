package simple_level;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @author mango
 * @create 2019-03-21 11:40 AM
 */
public class MinTreeDepth {
    /**
     * 1、最开始想到每一个父亲节点的最小深度都是其子节点最小深度数加一。
     * 2、当本节点为空时，返回深度0；
     * 3、当本节点的左孩子和右孩子为空的时候，返回深度1；
     * 4、当左孩子为空，右孩子非空时，返回右孩子的最小深度加一
     * 5、当右孩子为空，左孩子非空的时候，返回左孩子的最小深度加一
     * 6、最后一种为左右孩子都非空的情况，返回左右孩子最小深度的小值加一。
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}