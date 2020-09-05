package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/5 8:35 下午
 */
public class ZigzagLevelOrder {
    /**
     * BFS 广度优先遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        // 使用 分隔符（例如：空节点）把不同层的节点分隔开。分隔符表示一层结束和新一层开始。
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        // 用null作为分隔符
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left) {
                    level_list.addLast(curr_node.val);
                } else {
                    level_list.addFirst(curr_node.val);
                }
                // 如果有左节点 就加到queue中
                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                // 如果有左节点 就加到queue中
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {
                // 完成了一层的遍历
                results.add(level_list);
                // 重置level_list
                level_list = new LinkedList<>();
                // 添加每层的分隔符
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                // 反转遍历顺序
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
