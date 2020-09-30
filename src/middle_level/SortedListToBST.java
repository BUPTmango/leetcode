package middle_level;

import data_structure.TreeNode;
import data_structure.linked_list.ListNode;

/**
 * 109. ��������ת������������
 * ����һ�����������е�Ԫ�ذ��������򣬽���ת��Ϊ�߶�ƽ��Ķ�����������
 *
 * �����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
 *
 * ʾ��:
 *
 * �������������� [-10, -3, 0, 5, 9],
 *
 * һ�����ܵĴ��ǣ�[0, -3, 9, -10, null, 5], �����Ա�ʾ��������߶�ƽ�������������
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/30 8:57 ����
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        // �ҵ�������λ�ڵ���Ϊ���ڵ�
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    /**
     * �ҵ�������λ�ڵ�
     * @param left
     * @param right
     * @return
     */
    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
