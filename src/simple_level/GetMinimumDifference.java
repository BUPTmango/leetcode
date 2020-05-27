package simple_level;

import data_structure.TreeNode;

/**
 * 530. ��������������С���Բ�
 * ����һ�����нڵ�Ϊ�Ǹ�ֵ�Ķ�����������������������������ڵ�Ĳ�ľ���ֵ����Сֵ��
 *
 * ?
 *
 * ʾ����
 *
 * ���룺
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * �����
 * 1
 *
 * ���ͣ�
 * ��С���Բ�Ϊ 1������ 2 �� 1 �Ĳ�ľ���ֵΪ 1������ 2 �� 3����
 * ?
 *
 * ��ʾ��
 *
 * ���������� 2 ���ڵ㡣
 * ������ 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ ��ͬ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/27 11:05 ����
 */
public class GetMinimumDifference {
    private int pre;
    private int minDif;
    /**
     * ���ö��������������Ϊ��������ԣ�������ת��Ϊ���������е�����Ѱ�����������Ĳ����Сֵ��
     * ��һ��������¼��һ������ÿ��ֻҪ���㵱ǰ������һ�����ĲȻ�����Сֵ�Ƚϣ����ڱȽϺ������һ�������ɡ�
     * ��������������ɵõ�����������С���Բ
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        minDif = Integer.MAX_VALUE;
        inOrder(root);
        return minDif;
    }
    private void inOrder(TreeNode root) {
        if(root == null)    return;
        inOrder(root.left);
        if(pre != -1)
            minDif = Math.min(minDif, root.val - pre);
        pre = root.val;
        inOrder(root.right);
    }
}
