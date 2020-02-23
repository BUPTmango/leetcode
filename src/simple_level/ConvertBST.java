package simple_level;

import data_structure.TreeNode;

/**
 * 538
 * ����һ��������������Binary Search Tree��������ת����Ϊ�ۼ�����Greater Tree)��ʹ��ÿ���ڵ��ֵ��ԭ���Ľڵ�ֵ�������д������Ľڵ�ֵ֮�͡�
 *
 * ���磺
 *
 * ����: ����������:
 *               5
 *             /   \
 *            2     13
 *
 * ���: ת��Ϊ�ۼ���:
 *              18
 *             /   \
 *           20     13
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/10 11:45 ����
 */
public class ConvertBST {
    int sum=0;

    /**
     * ��"�������"�ķ�ʽ����ÿ���ڵ��ֵ�������ýڵ��ֵ�ۼӵ�һ�� int sum �����ϣ����ø� sum �������¸ýڵ��ֵ��
     * Ҫע����ǣ��˴�������������ȱ������������ٷ��ʸ��ڵ㣬Ȼ���ٱ���������
     * ����Ϊ BST ���ڵ��ֵС�����������нڵ��ֵ���������������нڵ��ֵ����
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        addSum(root);
        return root;
    }

    /**
     * ����������
     * ���������������գ��������������н���ֵ��С�����ĸ�����ֵ��
     * ���������������գ��������������н���ֵ���������ĸ�����ֵ��
     * @param root
     */
    public void addSum(TreeNode root){
        if(root!=null){
            addSum(root.right);
            sum+=root.val;
            root.val = sum;
            addSum(root.left);
        }
    }
}
