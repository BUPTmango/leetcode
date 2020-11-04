package middle_level;

import data_structure.TreeNode;

/**
 * ���������� �ж�BST�ĺϷ��ԡ�����ɾ����
 * 701. �����������еĲ������
 * ����������������BST���ĸ��ڵ��Ҫ�������е�ֵ����ֵ��������������� ���ز��������������ĸ��ڵ㡣 �������ݱ�֤����ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ��
 * <p>
 * ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ� ����Է���������Ч�Ľ����
 * <p>
 * ?
 * <p>
 * ����,?
 * <p>
 * ��������������:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * �� �����ֵ: 5
 * ����Է����������������:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * ���������Ҳ����Ч��:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ���������ϵĽڵ������� 0 �� 10^4 ֮��
 * ÿ���ڵ㶼��һ��Ψһ����ֵ��ȡֵ��Χ�� 0 �� 10^8
 * -10^8 <= val <= 10^8
 * ��ֵ��ԭʼ�����������е�����ڵ�ֵ����ͬ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/30 8:43 ����
 */
public class InsertIntoBST {

    /**
     * �ݹ� �Ƽ�
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // �ҵ���λ�ü����½ڵ�
        if (root == null) {
            return new TreeNode(val);
        }
        // ����BST�������ҵ���Ҫ����ĵ�
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
