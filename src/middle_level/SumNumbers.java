package middle_level;

import data_structure.TreeNode;


/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ���ֹ����
 * 129. �����Ҷ�ӽڵ�����֮��
 * ����һ��������������ÿ����㶼���һ��?0-9?�����֣�ÿ���Ӹ���Ҷ�ӽڵ��·��������һ�����֡�
 *
 * ���磬�Ӹ���Ҷ�ӽڵ�·�� 1->2->3 �������� 123��
 *
 * ����Ӹ���Ҷ�ӽڵ����ɵ���������֮�͡�
 *
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3]
 *     1
 *    / \
 *   2   3
 * ���: 25
 * ����:
 * �Ӹ���Ҷ�ӽڵ�·�� 1->2 �������� 12.
 * �Ӹ���Ҷ�ӽڵ�·�� 1->3 �������� 13.
 * ��ˣ������ܺ� = 12 + 13 = 25.
 * ʾ�� 2:
 *
 * ����: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 * ?/ \
 * 5   1
 * ���: 1026
 * ����:
 * �Ӹ���Ҷ�ӽڵ�·�� 4->9->5 �������� 495.
 * �Ӹ���Ҷ�ӽڵ�·�� 4->9->1 �������� 491.
 * �Ӹ���Ҷ�ӽڵ�·�� 4->0 �������� 40.
 * ��ˣ������ܺ� = 495 + 491 + 40 = 1026.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 8:48 ����
 */
public class SumNumbers {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        recur(root, 0);
        return sum;
    }

    private void recur(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        num = num * 10 + node.val;
        // �����Ҷ�ӽڵ�
        if (node.left == null && node.right == null) {
            sum += num;
        } else {
            // ��������
            recur(node.left, num);
            recur(node.right, num);
        }
    }
}
