package middle_level;

import data_structure.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例?1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例?2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 * ?    / \
 * ?   3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * ?    根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/11 9:40 上午
 */
public class IsValidBST {
    /**
     * 不仅右子结点要大于该节点，整个右子树的元素都应该大于该节点。
     * 这意味着我们需要在遍历树的同时保留结点的上界与下界，在比较时不仅比较子结点的值，也要与上下界比较。
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (! helper(node.right, val, upper)) {
            return false;
        }
        if (! helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
