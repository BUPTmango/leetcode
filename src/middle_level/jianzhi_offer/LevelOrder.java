package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ָ Offer 32 - I. ���ϵ��´�ӡ������
 * ���ϵ��´�ӡ����������ÿ���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ��
 *
 * ����:
 * ����������:?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���أ�
 *
 * [3,9,20,15,7]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/7 10:56 ����
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        // ���ڵ�Ϊ�� ���ؿ�����
        if(root == null) return new int[0];
        // ����queue����root���ڶ�����
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            // ȡ��Ԫ�طŵ�������
            TreeNode node = queue.poll();
            ans.add(node.val);
            // ���ȡ���Ľڵ�����ڵ� �������
            if(node.left != null) queue.add(node.left);
            // ���ȡ���Ľڵ�����ڵ� �������
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
