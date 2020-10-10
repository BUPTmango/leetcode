package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 *
 * 示例：
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * 提示：
 *
 * 树中节点数目在1到10^4之间。
 * 每个节点的值在1到100 之间。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/10 10:35 上午
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 先层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return sum;
    }
}
