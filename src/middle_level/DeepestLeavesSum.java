package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1302. ��������Ҷ�ӽڵ�ĺ�
 * ����һ�ö����������㷵�ز��������Ҷ�ӽڵ�ĺ͡�
 *
 *
 * ʾ����
 *
 *
 * ���룺root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * �����15
 *
 * ��ʾ��
 *
 * ���нڵ���Ŀ��1��10^4֮�䡣
 * ÿ���ڵ��ֵ��1��100 ֮�䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/10 10:35 ����
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // �Ȳ������
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
