package simple_level;

import data_structure.TreeNode;


/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *
 * 提示：
 *
 * 树中的结点数量最多为10000个。
 * 最终的答案保证小于2^31。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/17 10:34 上午
 */
public class RangeSumBST {
    int ans;

    /**
     * 递归实现深度优先搜索
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            // 如果当前的node的val在范围里就累加
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            // 如果 node.val 小于等于 L，那么只需要继续搜索它的右子树；
            // 如果 node.val 大于等于 R，那么只需要继续搜索它的左子树；
            // 如果 node.val 在区间 (L, R) 中，则需要搜索它的所有子树
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (node.val < R) {
                dfs(node.right, L, R);
            }
        }
    }
}
