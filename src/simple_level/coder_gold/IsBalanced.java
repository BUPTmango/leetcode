package simple_level.coder_gold;

import data_structure.TreeNode;

/**
 * ������ 04.04. ���ƽ����
 * ʵ��һ�����������������Ƿ�ƽ�⡣����������У�ƽ�����Ķ������£�����һ���ڵ㣬�����������ĸ߶Ȳ���� 1��
 *
 *
 * ʾ�� 1:
 * ���������� [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���� true ��
 * ʾ�� 2:
 * ���������� [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * ����?false ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/23 11:13 ����
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

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
