package simple_level;

import data_structure.TreeNode;

/**
 * 572. ��һ����������
 * ���������ǿն����� s �� t������?s ���Ƿ������ t ������ͬ�ṹ�ͽڵ�ֵ��������s ��һ���������� s ��һ���ڵ������ڵ���������s Ҳ���Կ����������һ��������
 *
 * ʾ�� 1:
 * �������� s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * �������� t��
 *
 *    4
 *   / \
 *  1   2
 * ���� true����Ϊ t �� s ��һ������ӵ����ͬ�Ľṹ�ͽڵ�ֵ��
 *
 * ʾ�� 2:
 * �������� s��
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * �������� t��
 *
 *    4
 *   / \
 *  1   2
 * ���� false��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/23 10:59 ����
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        // ��Ȼ������������л�������������
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    // �Ƚ��������Ƿ����
    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
}
