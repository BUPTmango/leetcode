package simple_level;

import data_structure.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * ?
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * ?
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/27 11:05 上午
 */
public class GetMinimumDifference {
    private int pre;
    private int minDif;
    /**
     * 利用二叉树的中序遍历为升序的特性，将问题转化为在升序排列的数中寻找相邻两数的差的最小值。
     * 用一个变量记录上一个数，每次只要计算当前数和上一个数的差，然后和最小值比较，并在比较后更新上一个数即可。
     * 中序遍历结束后便可得到二叉树的最小绝对差。
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        minDif = Integer.MAX_VALUE;
        inOrder(root);
        return minDif;
    }
    private void inOrder(TreeNode root) {
        if(root == null)    return;
        inOrder(root.left);
        if(pre != -1)
            minDif = Math.min(minDif, root.val - pre);
        pre = root.val;
        inOrder(root.right);
    }
}
