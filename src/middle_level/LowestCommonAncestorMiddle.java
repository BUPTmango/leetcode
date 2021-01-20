package middle_level;

import data_structure.TreeNode;

/**
 * 236. �������������������
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 * ���磬�������¶�����:? root =?[3,5,1,6,2,0,8,null,null,7,4]
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
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/12 9:13 ����
 */
public class LowestCommonAncestorMiddle {
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
        // ���leftΪ�գ�˵���������ڵ���cur�����������ϣ�����ֻ��Ҫ�������������ҵĽ������
        if (left == null) {
            return right;
        }
        // ͬ��
        if (right == null) {
            return left;
        }
        // ���left��right����Ϊ�գ�˵���������ڵ�һ����cur����������һ����root���������ϣ�
        // ����ֻ��Ҫ����root��㼴�ɡ�
        return root;
    }
}
