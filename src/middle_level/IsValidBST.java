package middle_level;

import data_structure.TreeNode;

/**
 * ���������� �ж�BST�ĺϷ��ԡ�����ɾ����
 * ����ת�㷨������Ƶ���⡷����������
 * 98. ��֤����������
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
 *
 * ����һ��������������������������
 *
 * �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
 * �ڵ��������ֻ�������ڵ�ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 * ʾ��?1:
 *
 * ����:
 *     2
 *    / \
 *   1   3
 * ���: true
 * ʾ��?2:
 *
 * ����:
 *     5
 *    / \
 *   1   4
 * ?    / \
 * ?   3   6
 * ���: false
 * ����: ����Ϊ: [5,1,4,null,null,3,6]��
 * ?    ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/11 9:40 ����
 */
public class IsValidBST {
    /**
     * �������ӽ��Ҫ���ڸýڵ㣬������������Ԫ�ض�Ӧ�ô��ڸýڵ㡣
     * ����ζ��������Ҫ�ڱ�������ͬʱ���������Ͻ����½磬�ڱȽ�ʱ�����Ƚ��ӽ���ֵ��ҲҪ�����½�Ƚϡ�
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (! helper(node.right, val, upper)) {
            return false;
        }
        if (! helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * ���ʹ��int����Сֵ���ǲ���С �������õ���int����Сֵ�Ľڵ��ʱ���������
     */
    long pre = Long.MIN_VALUE;
    /**
     * �������ʱ���жϵ�ǰ�ڵ��Ƿ�������������ǰһ���ڵ㣬
     * ������ڣ�˵������ BST����������������ֱ�ӷ��� false��
     * @param root
     * @return
     */
    public boolean isValidBST_another(TreeNode root) {
        if (root == null) {
            return true;
        }
        // ����������
        if (!isValidBST_another(root.left)) {
            return false;
        }
        // ���ʵ�ǰ�ڵ㣺�����ǰ�ڵ�С�ڵ������������ǰһ���ڵ㣬˵��������BST������ false���������������
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // ����������
        return isValidBST_another(root.right);
    }
}
