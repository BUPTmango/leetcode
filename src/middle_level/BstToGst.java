package middle_level;

import data_structure.TreeNode;

/**
 * ����������
 * 1038. �Ѷ���������ת��Ϊ�ۼ���
 * �������� ���� ���ĸ��ڵ㣬�����Ľڵ�ֵ������ͬ�����㽫��ת��Ϊ�ۼ�����Greater Sum Tree����ʹÿ���ڵ� node����ֵ����ԭ���д��ڻ����node.val��ֵ֮�͡�
 *
 * ����һ�£�������������������Լ��������
 *
 * �ڵ���������������� С�� �ڵ���Ľڵ㡣
 * �ڵ���������������� ���� �ڵ���Ľڵ㡣
 * ��������Ҳ�����Ƕ�����������
 * ע�⣺����Ŀ�� 538:https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ ��ͬ
 *
 *
 * ʾ�� 1��
 *
 * ���룺[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * �����[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * ʾ�� 2��
 *
 * ���룺root = [0,null,1]
 * �����[1,null,1]
 * ʾ�� 3��
 *
 * ���룺root = [1,0,2]
 * �����[3,3,2]
 * ʾ�� 4��
 *
 * ���룺root = [3,2,4,1]
 * �����[7,9,4,10]
 * 
 *
 * ��ʾ��
 *
 * ���еĽڵ������� 1 �� 100 ֮�䡣
 * ÿ���ڵ��ֵ����0 ��100֮�䡣
 * ���е�����ֵ ������ͬ ��
 * ��������Ϊ������������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/3 10:58 ����
 */
public class BstToGst {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        // �ۼ�
        sum += node.val;
        node.val = sum;
        inOrder(node.left);
    }
}
