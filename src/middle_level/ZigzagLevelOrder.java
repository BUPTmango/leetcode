package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. �������ľ���β�α���
 * ����һ����������������ڵ�ֵ�ľ���β�α����������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 *
 * ���磺
 * ����������?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���ؾ���β�α������£�
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/5 8:35 ����
 */
public class ZigzagLevelOrder {
    /**
     * BFS ������ȱ���
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        // ʹ�� �ָ��������磺�սڵ㣩�Ѳ�ͬ��Ľڵ�ָ������ָ�����ʾһ���������һ�㿪ʼ��
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        // ��null��Ϊ�ָ���
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
                // �������ڵ� �ͼӵ�queue��
                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                // �������ڵ� �ͼӵ�queue��
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {
                // �����һ��ı���
                results.add(level_list);
                // ����level_list
                level_list = new LinkedList<>();
                // ���ÿ��ķָ���
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                // ��ת����˳��
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
