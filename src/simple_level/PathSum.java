package simple_level;

import data_structure.TreeNode;

/**
 * 437
 * ����һ��������������ÿ����㶼�����һ������ֵ��
 *
 * �ҳ�·���͵��ڸ�����ֵ��·��������
 *
 * ·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
 *
 * ������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
 *
 * ʾ����
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * ���� 3���͵��� 8 ��·����:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/15 10:45 ����
 */
public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
