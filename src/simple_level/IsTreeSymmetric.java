package simple_level;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author mango
 * @create 2019-03-17 2:57 PM
 */
public class IsTreeSymmetric {
    /**
     * 如果两棵树满足以下条件则互为镜像：
     * 1.它们的两个根结点具有相同的值。
     * 2.每个树的右子树都与另一个树的左子树镜像对称。
     *
     * 可用递归的方式解决
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}