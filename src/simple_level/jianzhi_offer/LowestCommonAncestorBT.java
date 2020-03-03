package simple_level.jianzhi_offer;

import data_structure.TreeNode;

/**
 * ������68 - II. �������������������
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 * ���磬�������¶�����:? root =?[3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * ���: 3
 * ����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��
 * ʾ��?2:
 *
 * ����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * ���: 5
 * ����: �ڵ� 5 �ͽڵ� 4 ��������������ǽڵ� 5����Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
 * ?
 *
 * ˵��:
 *
 * ���нڵ��ֵ����Ψһ�ġ�
 * p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/3 10:03 ����
 */
public class LowestCommonAncestorBT {
    /**
     * �ݹ��������������ۣ�
     *
     * ���p��q�ֱ���root�����ҽڵ㣬��ôroot��������Ҫ�ҵ������������
     * ���p��q����root����ڵ㣬��ô����lowestCommonAncestor(root.left,p,q)
     * ���p��q����root���ҽڵ㣬��ô����lowestCommonAncestor(root.right,p,q)
     *
     * �߽��������ۣ�
     *
     * ���root��null����˵�������Ѿ��ҵ�����ˣ�����null��ʾû�ҵ�
     * ���root��p��Ȼ�����q��ȣ��򷵻�root
     * ���������û�ҵ����ݹ麯������null��֤��p��qͬ��root���Ҳ࣬��ô���յĹ������Ⱦ����������ҵ��Ľ��
     * ���������û�ҵ����ݹ麯������null��֤��p��qͬ��root����࣬��ô���յĹ������Ⱦ����������ҵ��Ľ��
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
