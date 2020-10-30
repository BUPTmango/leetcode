package middle_level;

import data_structure.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
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
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 8:52 下午
 */
public class Flatten {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // 要先拉平左右子树才能进行后续操作 所以使用后序遍历框架
        flatten(root.left);
        flatten(root.right);

        // 左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 首先把左链表连接到右子树上 并且断掉左子树
        root.left = null;
        root.right = left;

        // 将右链表连接到右子树的末端
        // 寻找末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // 连接
        p.right = right;
    }
}
