package simple_level;

import data_structure.TreeNode;

/**
 * 《玩转算法面试视频例题》二叉树 递归终止条件
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/27 11:07 下午
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 是左叶子才相加
        if (isLeftLeave(root.left)) {
            sum += root.left.val;
        } else {
            // 左子树但不是叶子 继续遍历
            sum += sumOfLeftLeaves(root.left);
        }
        // 右子树 继续遍历
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    /**
     * 判断节点是不是叶子节点
     * @param treeNode
     * @return
     */
    private boolean isLeftLeave(TreeNode treeNode) {
        return treeNode != null && (treeNode.left == null && treeNode.right == null);
    }
}
