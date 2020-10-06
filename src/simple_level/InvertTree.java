package simple_level;

import data_structure.TreeNode;

/**
 * 《玩转算法面试视频例题》二叉树 递归
 * 226
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/9 10:48 下午
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        } else {
            TreeNode middle = root.right;
            root.right = root.left;
            root.left = middle;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    /**
     * 简化版本 之前的太复杂了
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_better(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode middle = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(middle);
        return root;
    }

}
