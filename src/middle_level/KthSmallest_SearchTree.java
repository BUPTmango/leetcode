package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;

/**
 * ����������
 * 230. �����������е�KС��Ԫ��
 * ����һ����������������дһ������?kthSmallest?���������е�?k?����С��Ԫ�ء�
 *
 * ˵����
 * ����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����
 *
 * ʾ�� 1:
 *
 * ����: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * ?  2
 * ���: 1
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
 * ���: 3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/1 11:26 ����
 */
public class KthSmallest_SearchTree {
    /**
     * �ݹ�
     * ͨ������ BST ������������У���� k-1 ��Ԫ�ؾ��ǵ� k С��Ԫ�ء�
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
