package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * ������55 - I. �����������
 * ����һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 *
 * ���磺
 *
 * ���������� [3,9,20,null,null,15,7]��
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ��������������?3 ��
 *
 * ?
 *
 * ��ʾ��
 *
 * �ڵ����� <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/27 9:40 ����
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
