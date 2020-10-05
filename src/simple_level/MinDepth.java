package simple_level;

import data_structure.TreeNode;

/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ�
 * 111. ����������С���
 * ����һ�����������ҳ�����С��ȡ�
 * <p>
 * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
 * <p>
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * <p>
 * ʾ��:
 * <p>
 * ����������?[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ����������С��� ?2.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/27 11:06 ����
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // �����ݹ��������Ϊ�������
        // 1.���Ӻ��к��Ӷ�Ϊ�յ������˵��������Ҷ�ӽڵ㣬ֱ�ӷ���1����
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 2.������Ӻ��Һ�������һ��Ϊ�գ���ô��Ҫ���رȽϴ���Ǹ����ӵ����
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        // ��������һ���ڵ�Ϊ�գ�˵��m1��m2��һ����ȻΪ0�����Կ��Է���m1 + m2 + 1;
        if (root.left == null || root.right == null) {
            return m1 + m2 + 1;
        }

        // 3.���һ�������Ҳ�������Һ��Ӷ���Ϊ�գ�������С���+1����
        return Math.min(m1, m2) + 1;
    }
}
