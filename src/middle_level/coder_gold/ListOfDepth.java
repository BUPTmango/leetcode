package middle_level.coder_gold;

import data_structure.TreeNode;
import data_structure.linked_list.ListNode;

import java.util.*;

/**
 * ������ 04.03. �ض���Ƚڵ�����
 * ����һ�ö����������һ���㷨����������ĳһ��������нڵ���������磬��һ���������Ϊ D����ᴴ���� D ������������һ������������ȵ���������顣
 *
 *
 * ʾ����
 *
 * ���룺[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * �����[[1],[2,3],[4,5,7],[8]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 9:29 ����
 */
public class ListOfDepth {
    /**
     * �������
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
