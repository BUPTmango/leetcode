package hard_level;

import data_structure.TreeNode;

/**
 * 99. �ָ�����������
 * ��������������ĸ��ڵ� root �������е������ڵ㱻����ؽ��������ڲ��ı���ṹ������£��ָ��������
 *
 * ���ף�ʹ�� O(n) �ռ临�ӶȵĽⷨ������ʵ�֡��������һ��ֻʹ�ó����ռ�Ľ��������
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,3,null,null,2]
 * �����[3,1,null,null,2]
 * ���ͣ�3 ������ 1 ���ӣ���Ϊ 3 > 1 ������ 1 �� 3 ʹ������������Ч��
 * ʾ�� 2��
 *
 * ���룺root = [3,1,4,null,null,2]
 * �����[2,1,4,null,null,3]
 * ���ͣ�2 ������ 3 ���������У���Ϊ 2 < 3 ������ 2 �� 3 ʹ������������Ч��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/17 6:32 ����
 */
public class RecoverTree {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    /**
     * �������˳���� 4,2,3,1������ֻҪ�ҵ��ڵ� 4 �ͽڵ� 1 ����˳�򼴿ɣ�
     * ���������и����ɷ����������ڵ㣺
     *
     * ��һ���ڵ㣬�ǵ�һ�������������ʱ��ǰһ���ڵ���ں�һ���ڵ㣬����ѡȡǰһ���ڵ㣬����ָ�ڵ� 4��
     * �ڶ����ڵ㣬���ڵ�һ���ڵ��ҵ�֮�󣬺������ǰһ���ڵ���ں�һ���ڵ㣬����ѡ���һ���ڵ㣬����ָ�ڵ� 1��
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {

        in_order(root);
        // ���������ڵ��ֵ
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void in_order(TreeNode root) {
        if (root == null) {
            return;
        }
        in_order(root.left);

        if (firstNode == null && preNode.val > root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val > root.val) {
            secondNode = root;
        }
        // ����preNode
        preNode = root;

        in_order(root.right);
    }
}
