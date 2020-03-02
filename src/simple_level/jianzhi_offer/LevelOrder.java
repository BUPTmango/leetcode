package simple_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ������32 - II. ���ϵ��´�ӡ������ II
 * ���ϵ��°����ӡ��������ͬһ��Ľڵ㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�С�
 *
 * ����:
 * ����������:?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * �������α��������
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * ?
 *
 * ��ʾ��
 *
 * �ڵ����� <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/1 9:34 ����
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
