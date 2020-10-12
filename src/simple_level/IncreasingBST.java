package simple_level;

import data_structure.TreeNode;

/**
 * 897. ����˳�������
 * ����һ���������� ��������� ������������ʹ��������ߵĽ�����������ĸ�������ÿ�����û�����ӽ�㣬ֻ��һ�����ӽ�㡣
 *
 * ʾ�� ��
 *
 * ���룺[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 * /        / \
 * 1        7   9
 *
 * �����[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
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
 *            \
 *             7
 *              \
 *               8
 *                \
 *                  9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/8 9:44 ����
 */
public class IncreasingBST {
    TreeNode dummy = new TreeNode(0);
    TreeNode pointer = dummy;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);

        // ������������֮��һ��Ҫ������������Ϊnull �������ֻ�
        node.left = null;
        pointer.right = node;
        pointer = pointer.right;

        inOrder(node.right);
    }
}