package simple_level;

import data_structure.TreeNode;

/**
 * ���������� �����������
 * 538
 * ����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�
 * <p>
 * ���磺
 * <p>
 * ����: ����������:
 * 5
 * /   \
 * 2     13
 * <p>
 * ���: ת��Ϊ�ۼ���:
 * 18
 * /   \
 * 20     13
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/10 11:45 ����
 */
public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        // �ۼ�
        sum += node.val;
        node.val = sum;
        inOrder(node.left);
    }
}
