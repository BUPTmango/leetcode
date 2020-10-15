package middle_level;

import data_structure.TreeNode;

/**
 * 1315. �游�ڵ�ֵΪż���Ľڵ��
 * ����һ�ö����������㷵�������������������нڵ��ֵ֮�ͣ�
 *
 * �ýڵ���游�ڵ��ֵΪż������һ���ڵ���游�ڵ���ָ�ýڵ�ĸ��ڵ�ĸ��ڵ㡣��
 * ����������游�ڵ�ֵΪż���Ľڵ㣬��ô����0 ��
 *
 *
 * ʾ����
 *
 * ���룺root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * �����18
 * ���ͣ�ͼ�к�ɫ�ڵ���游�ڵ��ֵΪż������ɫ�ڵ�Ϊ��Щ��ɫ�ڵ���游�ڵ㡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 10:09 ����
 */
public class SumEvenGrandparent {
    private int count = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return count;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    count += node.left.left.val;
                }
                if (node.left.right != null) {
                    count += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    count += node.right.left.val;
                }
                if (node.right.right != null) {
                    count += node.right.right.val;
                }
            }
        }
        dfs(node.left);
        dfs(node.right);
    }
}
