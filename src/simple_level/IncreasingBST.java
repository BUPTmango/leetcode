package simple_level;

import data_structure.TreeNode;

/**
 * 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 * /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *            \
 *             7
 *              \
 *               8
 *                \
 *                  9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/8 9:44 上午
 */
public class IncreasingBST {
    private TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return pre;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        node.right = pre;
        pre = node;
        inOrder(node.left);
        // 记得left指向null
        node.left = null;
    }
}
