package simple_level;

import data_structure.TreeNode;

/**
 * 二分搜索树 中序遍历有序
 * 538
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/10 11:45 下午
 */
public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        // 累加
        sum += node.val;
        node.val = sum;
        inOrder(node.left);
    }
}
