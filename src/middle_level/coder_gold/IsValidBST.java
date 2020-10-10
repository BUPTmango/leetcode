package middle_level.coder_gold;

import data_structure.TreeNode;

/**
 * 面试题 04.05. 合法二叉搜索树
 * 示例1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *     根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/10 10:26 上午
 */
public class IsValidBST {

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
