package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Ҷ�����Ƶ���
 * �뿼��һ�ö����������е�Ҷ�ӣ���ЩҶ�ӵ�ֵ�������ҵ�˳�������γ�һ��Ҷֵ���� ��
 *
 *
 * �ٸ����ӣ�����ͼ��ʾ������һ��Ҷֵ����Ϊ(6, 7, 4, 9, 8)������
 *
 * ��������ö�������Ҷֵ��������ͬ����ô���Ǿ���Ϊ������Ҷ���Ƶġ�
 *
 * ������������������ֱ�Ϊroot1 ��root2������Ҷ���Ƶģ��򷵻�true�����򷵻� false ��
 *
 * ʾ�� 1��
 *
 *
 * ���룺root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * �����true
 * ʾ�� 2��
 *
 * ���룺root1 = [1], root2 = [1]
 * �����true
 * ʾ�� 3��
 *
 * ���룺root1 = [1], root2 = [2]
 * �����false
 * ʾ�� 4��
 *
 * ���룺root1 = [1,2], root2 = [2,2]
 * �����true
 * ʾ�� 5��
 *
 *
 * ���룺root1 = [1,2,3], root2 = [1,3,2]
 * �����false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/10 09:24
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = findSequence(root1);
        List<Integer> sequence2 = findSequence(root2);
        // �Ա�
        if (sequence1.size() != sequence2.size()) {
            return false;
        }
        for (int i = 0; i < sequence1.size(); i++) {
            if (!sequence1.get(i).equals(sequence2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> findSequence(TreeNode root) {
        // ǰ�����Ѱ��
        List<Integer> sequence = new ArrayList<>();
        preOrder(root, sequence);
        return sequence;
    }
    
    private void preOrder(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }
        preOrder(node.left, sequence);
        if (node.left == null && node.right == null) {
            sequence.add(node.val);
        }
        preOrder(node.right, sequence);
    }
}
