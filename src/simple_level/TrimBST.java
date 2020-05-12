package simple_level;

import data_structure.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * 给定一个二叉搜索树，同时给定最小边界L?和最大边界?R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/12 9:28 下午
 */
public class TrimBST {
    /**
     * 递归方法
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        // 如果root小于左边界，root的左子树一定不在[L, R]中，直接考虑右子树即可
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        // 如果root大于右边界，root的右子树一定不在[L, R]中，直接考虑左子树即可
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
