package simple_level;

import data_structure.TreeNode;

/**
 * 700. �����������е�����
 * ����������������BST���ĸ��ڵ��һ��ֵ�� ����Ҫ��BST���ҵ��ڵ�ֵ���ڸ���ֵ�Ľڵ㡣 �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻� NULL��
 *
 * ���磬
 *
 * ��������������:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * ��ֵ: 2
 * ��Ӧ�÷�����������:
 *
 *       2
 *      / \
 *     1   3
 * ������ʾ���У����Ҫ�ҵ�ֵ�� 5������Ϊû�нڵ�ֵΪ 5������Ӧ�÷��� NULL��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/24 1:56 ����
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
