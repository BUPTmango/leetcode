package middle_level;

import data_structure.TreeNode;

/**
 * 《玩转算法面试视频例题》二叉树 复杂逻辑
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 9:05 下午
 */
public class PathSumIII {
    /**
     * 在以root为根节点的二叉树中，寻找和为sum的路径
     * 返回这样的路径个数
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 包含root节点的路径个数
        int res = findPath(root, sum);
        // 不包含root节点的路径个数
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 在以node为根节点的二叉树中，寻找包含node的路径，和为sum
     * 返回这样的路径个数
     * @param node
     * @param sum
     * @return
     */
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == sum) {
            res++;
        }
        // 注意！！！ 因为节点可以是负数 加一个数减一个数又等于sum了 所以要继续计算
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
