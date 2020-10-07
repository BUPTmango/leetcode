package middle_level;

import data_structure.TreeNode;

/**
 * ����ת�㷨������Ƶ���⡷������ �����߼�
 * 437. ·���ܺ� III
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
 * @date 2020/10/6 9:05 ����
 */
public class PathSumIII {
    /**
     * ����rootΪ���ڵ�Ķ������У�Ѱ�Һ�Ϊsum��·��
     * ����������·������
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // ����root�ڵ��·������
        int res = findPath(root, sum);
        // ������root�ڵ��·������
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * ����nodeΪ���ڵ�Ķ������У�Ѱ�Ұ���node��·������Ϊsum
     * ����������·������
     * @param node
     * @param sum
     * @return
     */
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == sum) {
            res++;
        }
        // ע�⣡���� ��Ϊ�ڵ�����Ǹ��� ��һ������һ�����ֵ���sum�� ����Ҫ��������
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
