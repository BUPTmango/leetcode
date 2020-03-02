package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:? root =?[6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/2 3:56 下午
 */
public class LowestCommonAncestor {
    /**
     * BST的性质就是右边的大于根，左边的小于根
     * 所以之后在p和q一大一小于root或者等于的时候，才返回
     * 都大于就去右边找
     * 都小于就去左边找
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pointer = root;
        while (pointer != null) {
            if (pointer.val > p.val && pointer.val > q.val) {
                pointer = pointer.left;
            } else if  (pointer.val < p.val && pointer.val < q.val) {
                pointer = pointer.right;
            } else {
                return pointer;
            }
        }
        return null;
    }
}
