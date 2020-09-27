package middle_level;

import data_structure.linked_list.ListNode;
import util.LinkedListUtil;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 148. ��������
 * ��O(nlogn) ʱ�临�ӶȺͳ������ռ临�Ӷ��£��������������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 4->2->1->3
 * ���: 1->2->3->4
 * ʾ�� 2:
 * <p>
 * ����: -1->5->3->4->0
 * ���: -1->0->3->4->5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/27 6:40 ����
 */
public class SortList {
    /**
     * �ݹ���� top-down ���ǲ�������Ŀ�ϵĿռ�Ҫ�� �ռ�ʹ����logn
     * ������ֳ����������������֮�����merge����
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // ��ָ��һ�������� ��ָ��һ����һ�� �����������������ͣ���м�
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        // һ������ֳ����� �м�ָ��Ͽ�
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }


    /**
     * �ϲ�������������
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pointer.next = l2;
                l2 = l2.next;
            } else {
                pointer.next = l1;
                l1 = l1.next;
            }
            pointer = pointer.next;
        }
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return dummy.next;
    }


    /**
     * ��������
     *
     * @param head
     * @return
     */
    public ListNode sortList_iterator(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ��ȡ������
        int len = listNodeLength(head);

        // �ڱ��ڵ㣬Ҳ�нп��ܽڵ㣨�������������һ�㼼�ɣ�
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // ѭ�� log n ��    <<1�൱�ڳ���2
        for (int i = 1; i < len; i <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            // ѭ�� n ��
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right, i);
                prev.next = mergeTwoLists(left, right);

                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    /**
     * ���ݲ����ָ�����
     *
     * @param head
     * @param step
     * @return
     */
    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        // �ϵ�����
        head.next = null;
        return right;
    }

    /**
     * ��ȡ����ĳ���
     *
     * @param head
     * @return
     */
    private int listNodeLength(ListNode head) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    /**
     * �ϲ�������������
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }


    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head = LinkedListUtil.create(new int[]{4, 2, 1, 3});
        LinkedListUtil.print(head);
        ListNode result = sl.sortList(head);
        LinkedListUtil.print(result);
    }
}
