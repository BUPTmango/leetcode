package middle_level;

import data_structure.TreeNode;

/**
 * 814. 二叉树剪枝
 * 给定二叉树根结点root，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 *
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 *
 *
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 *
 *
 * 说明:
 *
 * 给定的二叉树最多有100个节点。
 * 每个节点的值只会为0 或1。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/8 10:19 上午
 */
public class PruneTree {
    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        // 在递归结束之后，如果整颗二叉树都不包含 1，那么我们返回 null，否则我们返回原来的根节点。
        return containsOne(root) ? root : null;
    }

    /**
     * containsOne(node) 函数来判断以 node 为根的子树中是否包含 1，
     * 其不包含 1 当且仅当以 node 的左右孩子为根的子树均不包含 1，并且 node 节点本身的值也不为 1。
     *
     * @param node
     * @return
     */
    public boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        // 如果 node 的左右孩子为根的子树不包含 1，那我们就需要把对应的指针置为空。
        // 例如当 node 的左孩子为根的子树不包含 1 时，我们将 node.left 置为 null。
        if (!a1) {
            node.left = null;
        }
        if (!a2) {
            node.right = null;
        }
        return node.val == 1 || a1 || a2;
    }
}
