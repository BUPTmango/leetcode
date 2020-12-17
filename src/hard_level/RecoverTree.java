package hard_level;

import data_structure.TreeNode;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 *
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/17 6:32 下午
 */
public class RecoverTree {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    /**
     * 中序遍历顺序是 4,2,3,1，我们只要找到节点 4 和节点 1 交换顺序即可！
     * 这里我们有个规律发现这两个节点：
     *
     * 第一个节点，是第一个按照中序遍历时候前一个节点大于后一个节点，我们选取前一个节点，这里指节点 4；
     * 第二个节点，是在第一个节点找到之后，后面出现前一个节点大于后一个节点，我们选择后一个节点，这里指节点 1；
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {

        in_order(root);
        // 交换两个节点的值
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void in_order(TreeNode root) {
        if (root == null) {
            return;
        }
        in_order(root.left);

        if (firstNode == null && preNode.val > root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val > root.val) {
            secondNode = root;
        }
        // 更新preNode
        preNode = root;

        in_order(root.right);
    }
}
