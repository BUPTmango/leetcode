package middle_level;

import data_structure.TreeNode;

/**
 * 114. ������չ��Ϊ����
 * ����һ����������ԭ�ؽ���չ��Ϊһ��������
 *
 *
 * ���磬����������
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * ����չ��Ϊ��
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 8:52 ����
 */
public class Flatten {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // Ҫ����ƽ�����������ܽ��к������� ����ʹ�ú���������
        flatten(root.left);
        flatten(root.right);

        // ���������Ѿ�����ƽ��һ������
        TreeNode left = root.left;
        TreeNode right = root.right;

        // ���Ȱ����������ӵ��������� ���Ҷϵ�������
        root.left = null;
        root.right = left;

        // �����������ӵ���������ĩ��
        // Ѱ��ĩ��
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // ����
        p.right = right;
    }
}
