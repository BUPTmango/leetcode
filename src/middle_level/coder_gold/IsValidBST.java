package middle_level.coder_gold;

import data_structure.TreeNode;

/**
 * ������ 04.05. �Ϸ�����������
 * ʾ��1:
 * ����:
 *     2
 *    / \
 *   1   3
 * ���: true
 * ʾ��2:
 * ����:
 *     5
 *    / \
 *   1   4
 *     / \
 *    3   6
 * ���: false
 * ����: ����Ϊ: [5,1,4,null,null,3,6]��
 *     ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/10 10:26 ����
 */
public class IsValidBST {

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
