package middle_level;

import data_structure.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回0 。
 *
 *
 * 示例：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 10:09 上午
 */
public class SumEvenGrandparent {
    private int count = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return count;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    count += node.left.left.val;
                }
                if (node.left.right != null) {
                    count += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    count += node.right.left.val;
                }
                if (node.right.right != null) {
                    count += node.right.right.val;
                }
            }
        }
        dfs(node.left);
        dfs(node.right);
    }
}
