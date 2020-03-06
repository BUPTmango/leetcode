package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * ������55 - II. ƽ�������
 * ����һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ������������ĳ������������ڵ���������������������1����ô������һ��ƽ���������
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ���������� [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���� true ��
 *
 * ʾ�� 2:
 *
 * ���������� [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * ����?false ��
 *
 * ?
 *
 * ���ƣ�
 *
 * 1 <= ���Ľ����� <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/6 7:20 ����
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((!isBalanced(root.left)) || (!isBalanced(root.right))) {
            return false;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return true;
    }

    /**
     * �������ĸ߶�
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
