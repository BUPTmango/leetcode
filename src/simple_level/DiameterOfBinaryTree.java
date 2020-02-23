package simple_level;

import data_structure.TreeNode;

/**
 * 543
 *  ��������ֱ��
 *  ����һ�ö�����������Ҫ��������ֱ�����ȡ�һ�ö�������ֱ�������������������·�������е����ֵ������·�����ܴ�������㡣
 *
 * ʾ�� :
 * ����������
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * ����?3, ���ĳ�����·�� [4,2,1,3] ����?[5,2,1,3]��
 *
 * ע�⣺�����֮���·��������������֮��ߵ���Ŀ��ʾ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/15 11:09 ����
 */
public class DiameterOfBinaryTree {
    private int sum = 0;
    /**
     * �ҵ�ÿ���ڵ�����(����max(��ڵ����,�ҽڵ����)+1)
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }
}
