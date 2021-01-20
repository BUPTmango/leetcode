package middle_level;

import data_structure.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:? root =?[3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例?2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/12 9:13 下午
 */
public class LowestCommonAncestorMiddle {
    /**
     * 递归体分三种情况讨论：
     *
     * 如果p和q分别是root的左右节点，那么root就是我们要找的最近公共祖先
     * 如果p和q都是root的左节点，那么返回lowestCommonAncestor(root.left,p,q)
     * 如果p和q都是root的右节点，那么返回lowestCommonAncestor(root.right,p,q)
     *
     * 边界条件讨论：
     *
     * 如果root是null，则说明我们已经找到最底了，返回null表示没找到
     * 如果root与p相等或者与q相等，则返回root
     * 如果左子树没找到，递归函数返回null，证明p和q同在root的右侧，那么最终的公共祖先就是右子树找到的结点
     * 如果右子树没找到，递归函数返回null，证明p和q同在root的左侧，那么最终的公共祖先就是左子树找到的结点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null) {
            return right;
        }
        // 同上
        if (right == null) {
            return left;
        }
        // 如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在root的右子树上，
        // 我们只需要返回root结点即可。
        return root;
    }
}
