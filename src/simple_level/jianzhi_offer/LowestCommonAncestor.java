package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * ������68 - I. �����������������������
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
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/2 3:56 ����
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
        while (pointer != null) {
            if (pointer.val > p.val && pointer.val > q.val) {
                pointer = pointer.left;
            } else if  (pointer.val < p.val && pointer.val < q.val) {
                pointer = pointer.right;
            } else {
                return pointer;
            }
        }
        return null;
    }
}
