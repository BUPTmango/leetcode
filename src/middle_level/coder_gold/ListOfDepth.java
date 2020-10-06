package middle_level.coder_gold;

import data_structure.TreeNode;
import data_structure.linked_list.ListNode;

import java.util.*;

/**
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 9:29 上午
 */
public class ListOfDepth {
    /**
     * 层序遍历
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        List<ListNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(0);
            ListNode pointer = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                pointer.next = new ListNode(treeNode.val);
                pointer = pointer.next;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(dummy.next);
        }
        return result.toArray(new ListNode[result.size()]);
    }
}
