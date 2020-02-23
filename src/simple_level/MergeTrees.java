package simple_level;

import data_structure.TreeNode;

/**
 * 617
 * ���������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���
 *
 * ����Ҫ�����Ǻϲ�Ϊһ���µĶ��������ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������Ϊ?NULL �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
 *
 * ʾ��?1:
 *
 * ����:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * ���:
 * �ϲ������:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * ע��:?�ϲ�������������ĸ��ڵ㿪ʼ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/7 10:37 ����
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
