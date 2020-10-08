package middle_level;

import data_structure.TreeNode;

/**
 * 814. ��������֦
 * ���������������root����������ÿ������ֵҪô�� 0��Ҫô�� 1��
 *
 * �����Ƴ������в����� 1 ��������ԭ��������
 *
 * ( �ڵ� X ������Ϊ X �����Լ����� X �ĺ����)
 *
 * ʾ��1:
 * ����: [1,null,0,0,1]
 * ���: [1,null,0,null,1]
 *
 * ����:
 * ֻ�к�ɫ�ڵ��������������в����� 1 ����������
 * ��ͼΪ���صĴ𰸡�
 *
 *
 * ʾ��2:
 * ����: [1,0,1,0,0,0,1]
 * ���: [1,null,1,null,1]
 *
 *
 *
 * ʾ��3:
 * ����: [1,1,0,1,1,0,1,0]
 * ���: [1,1,0,1,1,null,1]
 *
 *
 *
 * ˵��:
 *
 * �����Ķ����������100���ڵ㡣
 * ÿ���ڵ��ֵֻ��Ϊ0 ��1��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/8 10:19 ����
 */
public class PruneTree {
    /**
     * �ݹ�
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        // �ڵݹ����֮��������Ŷ������������� 1����ô���Ƿ��� null���������Ƿ���ԭ���ĸ��ڵ㡣
        return containsOne(root) ? root : null;
    }

    /**
     * containsOne(node) �������ж��� node Ϊ�����������Ƿ���� 1��
     * �䲻���� 1 ���ҽ����� node �����Һ���Ϊ���������������� 1������ node �ڵ㱾���ֵҲ��Ϊ 1��
     *
     * @param node
     * @return
     */
    public boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        // ��� node �����Һ���Ϊ�������������� 1�������Ǿ���Ҫ�Ѷ�Ӧ��ָ����Ϊ�ա�
        // ���統 node ������Ϊ�������������� 1 ʱ�����ǽ� node.left ��Ϊ null��
        if (!a1) {
            node.left = null;
        }
        if (!a2) {
            node.right = null;
        }
        return node.val == 1 || a1 || a2;
    }
}
