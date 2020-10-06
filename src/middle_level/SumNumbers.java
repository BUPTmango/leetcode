package middle_level;

import data_structure.TreeNode;


/**
 * 《玩转算法面试视频例题》二叉树 递归终止条件
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个?0-9?的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明:?叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 * ?/ \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 8:48 下午
 */
public class SumNumbers {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        recur(root, 0);
        return sum;
    }

    private void recur(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        num = num * 10 + node.val;
        // 如果是叶子节点
        if (node.left == null && node.right == null) {
            sum += num;
        } else {
            // 继续遍历
            recur(node.left, num);
            recur(node.right, num);
        }
    }
}
