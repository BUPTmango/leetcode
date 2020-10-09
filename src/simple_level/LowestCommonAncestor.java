package simple_level;

import data_structure.TreeNode;

/**
 * ����ת�㷨������Ƶ���⡷����������
 * 235
 * �����������������������
 * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 * ���磬�������¶���������:? root =?[6,2,8,0,4,7,9,null,null,3,5]
 *
 * ʾ�� 1:
 *
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * ���: 6
 * ����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
 * ʾ�� 2:
 *
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * ���: 2
 * ����: �ڵ� 2 �ͽڵ� 4 ��������������� 2, ��Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
 * ?
 *
 * ˵��:
 *
 * ���нڵ��ֵ����Ψһ�ġ�
 * p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ����������С�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/24 10:44 ����
 */
public class LowestCommonAncestor {
    /**
     * BST�����ʾ����ұߵĴ��ڸ�����ߵ�С�ڸ�
     * ����֮����p��qһ��һС��root���ߵ��ڵ�ʱ�򣬲ŷ���
     * �����ھ�ȥ�ұ���
     * ��С�ھ�ȥ�����
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pointer = root;
        // ֻҪpointer�������tree����Ļ�
        while (pointer != null) {
            if (p.val > pointer.val && q.val > pointer.val) {
                pointer = pointer.right;
            } else if (p.val < pointer.val && q.val < pointer.val) {
                pointer = pointer.left;
            } else {
                return pointer;
            }
        }
        return null;
    }
}
