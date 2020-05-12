package simple_level;

import data_structure.TreeNode;

/**
 * 669. �޼�����������
 * ����һ��������������ͬʱ������С�߽�L?�����߽�?R��ͨ���޼�������������ʹ�����нڵ��ֵ��[L, R]�� (R>=L) ���������Ҫ�ı����ĸ��ڵ㣬���Խ��Ӧ�������޼��õĶ������������µĸ��ڵ㡣
 *
 * ʾ�� 1:
 *
 * ����:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * ���:
 *     1
 *       \
 *        2
 * ʾ�� 2:
 *
 * ����:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * ���:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/12 9:28 ����
 */
public class TrimBST {
    /**
     * �ݹ鷽��
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        // ���rootС����߽磬root��������һ������[L, R]�У�ֱ�ӿ�������������
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        // ���root�����ұ߽磬root��������һ������[L, R]�У�ֱ�ӿ�������������
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
