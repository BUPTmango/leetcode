package hard_level;

import data_structure.TreeNode;

/**
 * 124. �������е����·����
 * ����һ���ǿն����������������·���͡�
 *
 * �����У�·��������Ϊһ������������ڵ�������ظ��ڵ�-�ӽڵ����ӣ��ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * �����6
 * ʾ��2��
 *
 * ���룺[-10,9,20,null,null,15,7]
 *
 *   -10
 *  / \
 *  9 20
 *   / \
 *  15  7
 *
 * �����42
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/17 6:08 ����
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // �ݹ���������ӽڵ�������ֵ
        // ֻ���������ֵ���� 0 ʱ���Ż�ѡȡ��Ӧ�ӽڵ�
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // �ڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ
        int priceNewPath = node.val + leftGain + rightGain;

        // ���´�   ����ѡ�������ҽṹ��·��
        maxSum = Math.max(maxSum, priceNewPath);

        // ���ؽڵ�������ֵ   ����ѡ�����л������еĽṹ
        return node.val + Math.max(leftGain, rightGain);
    }
}
