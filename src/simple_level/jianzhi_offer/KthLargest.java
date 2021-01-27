package simple_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * ������54. �����������ĵ�k��ڵ�
 * ����һ�ö��������������ҳ����е�k��Ľڵ㡣
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * ?  2
 * ���: 4
 * ʾ�� 2:
 *
 * ����: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * ���: 4
 * ?
 *
 * ���ƣ�
 *
 * 1 �� k �� ����������Ԫ�ظ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/1 10:11 ����
 */
public class KthLargest {
    private int count = 0;
    private int res = 0;

    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    /**
     * ע�⣡�� ������������ ���������ı����Ƿ������� �������Եõ����������
     * @param root
     * @param k
     */
    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        inorder(root.left, k);
    }
}
