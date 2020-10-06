package simple_level;

import data_structure.TreeNode;

/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ���ֹ����
 * 404. ��Ҷ��֮��
 * ���������������������Ҷ��֮�͡�
 * <p>
 * ʾ����
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * ������������У���������Ҷ�ӣ��ֱ��� 9 �� 15�����Է��� 24
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/27 11:07 ����
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // ����Ҷ�Ӳ����
        if (isLeftLeave(root.left)) {
            sum += root.left.val;
        } else {
            // ������������Ҷ�� ��������
            sum += sumOfLeftLeaves(root.left);
        }
        // ������ ��������
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    /**
     * �жϽڵ��ǲ���Ҷ�ӽڵ�
     * @param treeNode
     * @return
     */
    private boolean isLeftLeave(TreeNode treeNode) {
        return treeNode != null && (treeNode.left == null && treeNode.right == null);
    }
}
