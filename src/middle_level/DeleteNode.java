package middle_level;

import data_structure.TreeNode;

/**
 * 二分搜索树 判断BST的合法性、增、删、查
 * 《玩转算法面试视频例题》二分搜索树
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的?key?对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为?O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/9 8:20 下午
 */
public class DeleteNode {

    /**
     * 找到后继节点
     * @param root
     * @return
     */
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 找到前序节点
     * @param root
     * @return
     */
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 从右子树寻找
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            // 从左子树寻找
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            // 删除节点
        } else {
            // 是叶子节点 直接删除
            if (root.left == null && root.right == null) {
                root = null;
                // 不是叶子节点 并且有右子树
            } else if (root.right != null) {
                // 使用后继节点作为新的根节点
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
                // 不是叶子节点 没有右子树 只有左子树
            } else {
                // 使用前序节点作为新的根节点
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
