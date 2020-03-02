package simple_level.jianzhi_offer;

import data_structure.TreeNode;

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
    /**
     * ��������������������ǰ��մ�С������ߴӴ�С��˳�����еģ�ȡ������������ǰ������������ǰ��
     * ������õ�����
     * ֮���õ�stack��pop����k��
     * @param root
     * @param k
     * @return
     */


    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    private void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }
}
