package hard_level;

import data_structure.TreeNode;

/**
 * 968. ��ض�����
 * ����һ�������������������Ľڵ��ϰ�װ����ͷ��
 * <p>
 * �ڵ��ϵ�ÿ����Ӱͷ�����Լ����丸����������ֱ���Ӷ���
 * <p>
 * �������������нڵ��������С����ͷ������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/22 8:46 ����
 */
public class MinCameraCover {
    /**
     * ������״̬:
     * 0=>�����������
     * 1=>�������Ѿ�����
     * 2=>�������ϰ�װ�����
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        // ��������� root��û�б����� ��������
        if (lrd(root) == 0) {
            res++;
        }
        return res;
    }

    int res = 0;

    /**
     * lrd �������
     * @param node
     * @return
     */
    int lrd(TreeNode node) {

        if (node == null) {
            return 1;
        }
        int left = lrd(node.left);
        int right = lrd(node.right);
        // ��ڵ�����ҽڵ�û�и��� �ڵ�ǰ�ڵ㰲װ�����
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        // ���ҽڵ㶼�Ѿ����� ��ǰ�ڵ����������
        if (left == 1 && right == 1) {
            return 0;
        }
        // һ��Ϊ1һ��Ϊ2 ��ǰ�ڵ�϶������� ����1
        if (left + right >= 3) {
            return 1;
        }

        return -1;
    }
}
