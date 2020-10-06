package middle_level;

import data_structure.TreeNode;

/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ�
 * 222. ��ȫ�������Ľڵ����
 * ����һ����ȫ����������������Ľڵ������
 *
 * ˵����
 *
 * ��ȫ�������Ķ������£�����ȫ�������У�������ײ�ڵ����û�����⣬����ÿ��ڵ������ﵽ���ֵ������������һ��Ľڵ㶼�����ڸò�����ߵ�����λ�á�����ײ�Ϊ�� h �㣬��ò���� 1~?2h?���ڵ㡣
 *
 * ʾ��:
 *
 * ����:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * ���: 6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 8:26 ����
 */
public class CountNodes {

    private int count = 0;

    /**
     * �Լ�������
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        count(root);
        return count;
    }
    private void count(TreeNode node) {
        if (node == null) {
            return;
        }
        count++;
        count(node.left);
        count(node.right);
    }


    public int countNodes_better(TreeNode root) {
        return root != null ? 1 + countNodes_better(root.right) + countNodes_better(root.left) : 0;
    }

}
